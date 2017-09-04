package il.co.electriccollege.restaurant.irena.hibernate.dao;

import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.Roasting;

import javax.persistence.*;

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
