package il.co.electriccollege.restaurant.tzur.sql.dao;

import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;

import java.util.ArrayList;

public class DessertDish extends Dish {
    int sweetLevel;


    public DessertDish(String name, String description, float price, int sweetLevel) {
        super(name, description, price, Category.DESSERT);
        this.sweetLevel = sweetLevel;
    }

    public DessertDish(int dishId, String name, String description, float price,  int sweetLevel) {
        super(dishId, name, description, price, Category.DESSERT);
        this.sweetLevel = sweetLevel;
    }

    public int getSweetLevel() {
        return sweetLevel;
    }

    public void setSweetLevel(int sweetLevel) {
        this.sweetLevel = sweetLevel;
    }

    @Override
    public String toString() {
        return super.toString()+"DessertDish{" +
                "sweetLevel=" + sweetLevel +
                '}';
    }
}
