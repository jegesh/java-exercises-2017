package jersey.explore.providers.security;

import jersey.explore.dal.PrincipalUser;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private PrincipalUser user;
    private String scheme;

    public MySecurityContext(PrincipalUser user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }

    public Principal getUserPrincipal() {return this.user;}

    public boolean isUserInRole(String s) {
        if (user.getRole() != null) {
            return user.getRole().contains(s);
        }
        return false;
    }

    public boolean isSecure() {return "https".equals(this.scheme);}

    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}

