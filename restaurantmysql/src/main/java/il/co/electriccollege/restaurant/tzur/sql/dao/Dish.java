package il.co.electriccollege.restaurant.tzur.sql.dao;

import il.co.electriccollege.restaurant.tzur.sql.dao.enums.Category;

public class Dish {

    private int dishId;
    private String name;
    private String description;
    private float price;
    private Category category;



    //con


    public Dish(int dishId, String name, String description, float price, Category category) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Dish(String name, String description, float price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Dish() {
    }
    //get&set



    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    //to string

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
