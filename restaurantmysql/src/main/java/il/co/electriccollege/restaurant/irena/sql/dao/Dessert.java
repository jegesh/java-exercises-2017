package il.co.electriccollege.restaurant.irena.sql.dao;

import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.DrinkEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table
public class Dessert extends Dish {
    private DrinkEnum drinkEnum;
    public Dessert(DrinkEnum drinkEnum){
        super();
        this.drinkEnum = drinkEnum;
    }
    @Column
    public DrinkEnum getDrinkEnum() {
        return drinkEnum;
    }

    public void setDrinkEnum(DrinkEnum drinkEnum) {
        this.drinkEnum = drinkEnum;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " drinkEnum=" + drinkEnum +
                '}';
    }
}
