package il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao;

import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao.enums.DrinkEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name="dishes")
public class Dessert extends Dish {
    private DrinkEnum drinkEnum;
    public Dessert(){}
    public Dessert(DrinkEnum drinkEnum){
        super();
        this.drinkEnum = drinkEnum;
    }
@Column(name="drink")
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
