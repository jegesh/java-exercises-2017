package animal.rest.security;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import animal.dal.User;
import animal.servlet.LoginServlet;

@Provider
public class JwtTokenFilter implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String token = request.getCookieNameValueMap().getFirst("jwt");
		
		// verify token
		DecodedJWT jwt = null;
		try {
			jwt = verifyToken(token);
		}catch(Exception e) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		
		// check that token didn't expire
		Date issuedAt = jwt.getClaim("iat").asDate();
		if(new Date().getTime() - issuedAt.getTime() > 1000*120) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		
		User user = new User();
		user.setUsername(jwt.getClaim("aud").asString());
		user.setRole(jwt.getClaim("rol").asString());
		
		SecurityContext securityContext = new BasicSecurityContext(user, request);
		request.setSecurityContext(securityContext);
		return request;
	}

	private DecodedJWT verifyToken(String token) throws IllegalArgumentException, UnsupportedEncodingException{
            Algorithm algorithm = Algorithm.HMAC256(LoginServlet.SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(LoginServlet.ISSUER)
                    .build();
            return verifier.verify(token);
    }
}
