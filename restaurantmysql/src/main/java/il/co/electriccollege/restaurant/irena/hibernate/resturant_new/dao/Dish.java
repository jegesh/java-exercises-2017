package il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao;

import il.co.electriccollege.restaurant.irena.hibernate.resturant_new.dao.enums.CategoryEnum;

import javax.persistence.*;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name="dishes")
public class Dish {
    private int id;
    private String name;
    private float price;
    private String description;
    private CategoryEnum category;
    private Menu menu;

    public Dish(){}

    public Dish(String name, float price){
        this.name = name;
        this.price = price;
    }
    @ManyToOne
    @JoinColumn(name = "menu_id")
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Column
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public int getId() {
        return id;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {

        this.id = id;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
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
