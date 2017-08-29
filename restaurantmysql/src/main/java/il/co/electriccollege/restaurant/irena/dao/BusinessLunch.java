package il.co.electriccollege.restaurant.irena.dao;

import il.co.electriccollege.restaurant.irena.enums.Garnish;

/**
 * Created by IrKha on 29.08.2017.
 */
public class BusinessLunch extends Dish {
    private Garnish garnish;
    public BusinessLunch(Garnish garnish){
        super();
        this.garnish = garnish;
    }
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
