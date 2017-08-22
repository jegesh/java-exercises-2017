package il.co.electriccollege.sql.jdo.entities;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by yaakov on 8/20/17.
 */
@PersistenceCapable(identityType= IdentityType.APPLICATION)
public class Category {

    public Category(){
        super();
    }

    @Persistent
    @PrimaryKey
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Persistent
    private String name;
}
