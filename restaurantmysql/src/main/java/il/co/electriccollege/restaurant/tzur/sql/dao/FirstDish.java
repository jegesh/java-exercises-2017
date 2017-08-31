package il.co.electriccollege.restaurant.tzur.sql.dao;

import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;

import java.util.ArrayList;

public class FirstDish extends Dish {
    boolean includeDrink;


    public FirstDish(String name, String description, float price, boolean includeDrink) {
        super(name, description, price,Category.FIRST);
        this.includeDrink = includeDrink;
    }

    public FirstDish(int dishId, String name, String description, float price, boolean includeDrink) {
        super(dishId, name, description, price, Category.FIRST);
        this.includeDrink = includeDrink;
    }

    public boolean isIncludeDrink() {
        return includeDrink;
    }

    public void setIncludeDrink(boolean includeDrink) {
        this.includeDrink = includeDrink;
    }

}
