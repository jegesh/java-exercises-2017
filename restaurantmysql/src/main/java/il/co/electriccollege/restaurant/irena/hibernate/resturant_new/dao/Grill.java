package il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao;

import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao.enums.Roasting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name="dishes")
public class Grill extends Dish {

    private Roasting roasting;

    public Grill(Roasting roasting){
        super();
        this.roasting = roasting;
    }

    @Column
    public Roasting getRoasting() {
        return roasting;
    }

    public void setRoasting(Roasting roasting) {
        this.roasting = roasting;
    }


    @Override
    public String toString() {
        return  super.toString() +
                " roasting=" + roasting +
                '}';
    }
}
