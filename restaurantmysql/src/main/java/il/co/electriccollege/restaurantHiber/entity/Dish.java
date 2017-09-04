package il.co.electriccollege.restaurantHiber.entity;

import javax.persistence.*;

@Entity
@Table(name="dishes")
public class Dish {
    private int id;
    private String name;
    private String description;
    private double price;
    private String dishCategory;

//    public Dish(int id, String name, String description, double price, DishCategory dishCategory) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.dishCategory = dishCategory;
//    }


    public Dish() {
    }

    public Dish(String name, String description, double price, String dishCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishCategory = dishCategory;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="category")
    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", dishCategory=" + dishCategory +
                '}';
    }
}
