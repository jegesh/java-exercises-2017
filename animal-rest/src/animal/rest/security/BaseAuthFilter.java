package animal.rest.security;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import animal.dal.User;
import animal.dal.UserDal;
import sun.misc.BASE64Decoder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;

@Provider
public class BaseAuthFilter implements ContainerRequestFilter {

        public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
            //Get the authentification passed in HTTP headers parameters
            String auth = containerRequest.getHeaderValue("authorization");

            //If the user does not have the right (does not provide any HTTP Basic Auth)
            if(auth == null){
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }

            //credentials : loginAndPassword
            String[] credentials = new String[1];
            String username = null;
            String password = null;
            try {
            		String headerBody = auth.split(" ")[1];
            		String unencodedHeaderBody = new String(new BASE64Decoder().decodeBuffer(headerBody)); 
                credentials = unencodedHeaderBody.split(":");
                username = credentials[0];
                password = credentials[1];
            } catch (IOException e) {
                e.printStackTrace();
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }

            // retrieve user from database
            UserDal userDal = new UserDal();
            User user;
			try {
				user = userDal.getByName(username);
				
				// check password
				if(user == null || !user.getPassword().equals(hashPassword(password)))
					throw new WebApplicationException(Response.Status.UNAUTHORIZED);
				
				// add user info to request
	            containerRequest.setSecurityContext(
	            		new BasicSecurityContext(user, containerRequest)
	        		);
	            return containerRequest;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new WebApplicationException(e);
			}

        }
        
        private String hashPassword(String rawPassword) {
        		return DigestUtils.sha1Hex(rawPassword + "elecjava");
        }

}



