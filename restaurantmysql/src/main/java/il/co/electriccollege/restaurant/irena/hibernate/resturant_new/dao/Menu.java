package il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao;

import javax.persistence.*;

/**
 * Created by Comp8 on 05/09/17.
 */
@Entity
@Table(name = "menu")
public class Menu {
    private int id;
    private String name;
    private String hours_available;

    public Menu(){
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public String getHours_available() {
        return hours_available;
    }

    public void setHours_available(String hours_available) {
        this.hours_available = hours_available;
    }
}
