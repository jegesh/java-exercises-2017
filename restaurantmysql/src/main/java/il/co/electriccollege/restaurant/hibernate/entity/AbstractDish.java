package il.co.electriccollege.restaurant.hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name="dishes")
public class AbstractDish {


    int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int countId = 0;
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "menu")
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    public AbstractDish() {
    }

    /*public AbstractDish(int id, String name, String description, double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }*/

    public AbstractDish(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        countId = countId+1;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public int getId() {
        return id;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Column
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AbstractDish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
