package il.co.electriccollege.library.hibernate.entitities;

import javax.persistence.*;

/**
 * Created by yaakov on 9/4/17.
 */
@Entity
@Table(name="library")
public class Library {
    private int id;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    public int getId() {
        return this.id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        String desc = "Name: %s, Address: %s, id: %s";
        return String.format(desc, name, address, id);
    }
}
