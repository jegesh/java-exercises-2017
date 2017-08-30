package il.co.electriccollege.restaurant.gil.sql.dao;

/**
 * Created by Comp3 on 30/08/17.
 */
public abstract class AbstractDish {

    protected DishType type;
    private String name;
    private int dishid;
    private double price;
    private String description;


    public AbstractDish(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public AbstractDish()
    {}


    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        String print = "Name: %s, id: %s, price: %s";
        return String.format(print, name, dishid, price);
    }
}
