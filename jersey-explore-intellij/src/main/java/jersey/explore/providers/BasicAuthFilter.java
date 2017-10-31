package jersey.explore.providers;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import jersey.explore.dal.PrincipalUser;
import jersey.explore.providers.security.MySecurityContext;
import sun.misc.BASE64Decoder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class BasicAuthFilter implements ContainerRequestFilter {

        public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
            //Get the authentification passed in HTTP headers parameters
            String auth = containerRequest.getHeaderValue("authorization");

            //If the user does not have the right (does not provide any HTTP Basic Auth)
            if(auth == null){
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }

            //credentials : loginAndPassword
            String[] credentials = new String[1];
            try {
                credentials = new String(new BASE64Decoder().decodeBuffer(auth.split(" ")[1])).split(":");
            } catch (IOException e) {
                e.printStackTrace();
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }

            //DO YOUR DATABASE CHECK HERE
            if(!credentials[0].equals("yaakov") || !credentials[1].equals("pword"))
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);

            // add user info to request
            PrincipalUser u = new PrincipalUser();
            u.setName(credentials[0]);
            u.setRole("admin");
            containerRequest.setSecurityContext(new MySecurityContext(u, containerRequest.getAuthenticationScheme()));
            return containerRequest;
        }

}
