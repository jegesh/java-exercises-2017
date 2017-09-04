package il.co.electriccollege.library.hibernate.entitities;

import javax.persistence.*;

/**
 * Created by yaakov on 9/4/17.
 */
@Entity
@Table(name="library")
public class Library {
    private long id;
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    public long getId() {
        return this.id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id){
        this.id = id;
    }

}
