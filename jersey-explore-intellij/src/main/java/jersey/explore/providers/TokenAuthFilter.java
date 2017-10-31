package jersey.explore.providers;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import sun.misc.BASE64Decoder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class TokenAuthFilter implements ContainerRequestFilter {

    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
        MultivaluedMap<String, String> cookieMap = containerRequest.getCookieNameValueMap();
        String username = cookieMap.getFirst("username");
        String token = cookieMap.getFirst("token");

        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if(username == null || token == null){
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        boolean isAuthenticated = true;
        // check if token matches user, and is still valid
//         PrincipalUser u = UserDal.getUserByName();
//         check if token is more than two weeks old
//         if(!u.getToken().equals(token) || System.currentTimeMillis() - u.getTokenTime() > 1000*60*60*24*14){
//              isAuthenticated = false;
//         }

        //Our system refuse login and password
        if(!isAuthenticated){
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        return containerRequest;
    }
}