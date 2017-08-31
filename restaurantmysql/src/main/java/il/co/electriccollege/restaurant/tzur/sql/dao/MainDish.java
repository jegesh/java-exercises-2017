package il.co.electriccollege.restaurant.tzur.sql.dao;

import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;

import java.util.ArrayList;

public class MainDish extends Dish {
    int satiationLevel;


    public MainDish(String name, String description, float price,  int satiationLevel) {
        super(name, description, price, Category.MAIN);
        this.satiationLevel = satiationLevel;
    }

    public MainDish(int dishId, String name, String description, float price, int satiationLevel) {
        super(dishId, name, description, price, Category.MAIN);
        this.satiationLevel = satiationLevel;
    }

    public int getSatiationLevel() {
        return satiationLevel;
    }

    public void setSatiationLevel(int satiationLevel) {
        this.satiationLevel = satiationLevel;
    }
}
