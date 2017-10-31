package jersey.explore.dal;

import javax.security.auth.Subject;
import java.security.Principal;

public class PrincipalUser implements Principal {
    private String name;
    private String role;

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return null;
    }

    public boolean implies(Subject subject) {
        return subject.getPrincipals().contains(this);
    }

    public String getRole() {
        return null;
    }
}
