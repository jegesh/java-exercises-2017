package il.co.electriccollege.restaurant.irena.sql.dao;

import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.Roasting;

/**
 * Created by IrKha on 29.08.2017.
 */
public class Grill extends Dish{
    private Roasting roasting;
    public Grill(){}
    public Grill(Roasting roasting){
        super();
        this.roasting = roasting;
    }

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
