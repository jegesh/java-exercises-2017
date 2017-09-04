package il.co.electriccollege.restaurant.irena.hibernate.dao;

import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.Garnish;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name="dishes")
public class BusinessLunch extends Dish {
    private Garnish garnish;
    /*public BusinessLunch(){
        super();
    }*/
    public BusinessLunch(Garnish garnish){
        super();
        this.garnish = garnish;
    }
    @Column
    public Garnish getGarnish() {
        return garnish;
    }

    public void setGarnish(Garnish garnish) {
        this.garnish = garnish;
    }

    @Override
    public String toString() {
        return super.toString() +
                " garnish=" + garnish +
                '}';
    }
}
