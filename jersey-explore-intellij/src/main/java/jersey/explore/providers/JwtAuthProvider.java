package jersey.explore.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;


@Provider
public class JwtAuthProvider implements ContainerRequestFilter {
    private static final String SECRET = "thequickbr0vvnfoxjumped overthe l azydog";
    private static final String ISSUER = "myserver";


    private String createToken() {
        try {
            Algorithm algorithm = null;
            try {
                algorithm = Algorithm.HMAC256(SECRET);
            } catch (UnsupportedEncodingException e) {
                throw new WebApplicationException(e);
            }
            return JWT.create()
                    .withClaim("dat", new Date())
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new WebApplicationException(exception);
        }
    }

    /**
     *
     * @param token
     * @return
     */
    private DecodedJWT verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            return verifier.verify(token);
        } catch (UnsupportedEncodingException exception){
            throw new WebApplicationException(exception);
        } catch (JWTVerificationException exception){
            throw new WebApplicationException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    public ContainerRequest filter(ContainerRequest request) {
            MultivaluedMap<String, String> cookieMap = request.getCookieNameValueMap();
            String token = cookieMap.getFirst("jwt");

            DecodedJWT jwt = verifyToken(token);
            if(jwt.getIssuedAt().after(new Date())) // compare date
                return request;
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);

        }
}
