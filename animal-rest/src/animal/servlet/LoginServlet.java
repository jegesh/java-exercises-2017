package animal.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;

import org.apache.commons.codec.digest.DigestUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import animal.dal.User;
import animal.dal.UserDal;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SECRET = "thequickbr0vvnfoxjumps overthe l azydog";
    public static final String ISSUER = "myserver";

    private String createToken(User user) {
        try {
            Algorithm algorithm = null;
            try {
                algorithm = Algorithm.HMAC256(SECRET);
            } catch (UnsupportedEncodingException e) {
                throw new WebApplicationException(e);
            }
            return JWT.create()
                    .withClaim("iat", new Date())
                    .withClaim("aud", user.getName())
                    .withClaim("rol", user.getRole())
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new WebApplicationException(exception);
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || password == null ) {
			response.setStatus(400);
			return;
		}
		
		// retrieve user from database
        UserDal userDal = new UserDal();
        User user;
		try {
			user = userDal.getByName(username);
			
			// check password
			if(user == null || !user.getPassword().equals(hashPassword(password))) {
				response.setStatus(401);
				return;
			}
			
			// set token in cookie
			String jwt = createToken(user);
			response.addCookie(new Cookie("jwt", jwt));
			return;
		}catch (Exception e){
			response.getWriter().write(e.getMessage());
			response.setStatus(500);
			return;
		}
		
	}
		
	private String hashPassword(String rawPassword) {
    		return DigestUtils.sha1Hex(rawPassword + "elecjava");
    }

}








