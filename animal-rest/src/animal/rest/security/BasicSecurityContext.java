package animal.rest.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.sun.jersey.spi.container.ContainerRequest;

import animal.dal.User;

public class BasicSecurityContext implements SecurityContext{
	private User user;
	private String scheme;
	
	public BasicSecurityContext(User user, ContainerRequest request) {
		this.user = user;
		this.scheme = request.getRequestUri().getScheme();
	}
	
	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public boolean isUserInRole(String role) {
		return user.getRole().equals(role);
	}

	@Override
	public boolean isSecure() {
		return scheme.equals("https");
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
