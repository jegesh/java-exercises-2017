package il.co.electriccollege.restaurant.irena.dao;

/**
 * Created by IrKha on 29.08.2017.
 */
public abstract class Dish {
    private int id;
    private String name;
    private float price;
    private String description;
    public Dish(){}
    public Dish(String name, float price){
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
