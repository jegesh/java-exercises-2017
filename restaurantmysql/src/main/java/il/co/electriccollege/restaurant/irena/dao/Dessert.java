package il.co.electriccollege.restaurant.irena.dao;

import il.co.electriccollege.restaurant.irena.enums.DrinkEnum;

/**
 * Created by IrKha on 29.08.2017.
 */
public class Dessert extends Dish {
    private DrinkEnum drinkEnum;
    public Dessert(DrinkEnum drinkEnum){
        super();
        this.drinkEnum = drinkEnum;
    }

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
