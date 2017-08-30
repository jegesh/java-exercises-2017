package il.co.electriccollege.restaurant.dish;

/**
 * Created by Comp14 on 30/08/2017.
 */
abstract  public class AbstractDish {
    private int id;
    private String name;
    private String description;
    private double price;
    private DishCategory dishCategory;

    public AbstractDish(int id, String name, String description, double price, DishCategory dishCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishCategory = dishCategory;
    }

    public AbstractDish() {
    }

    public AbstractDish(String name, String description, double price, DishCategory dishCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dishCategory = dishCategory;
    }

    public int getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    @Override
    public String toString() {
        return "AbstractDish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", dishCategory=" + dishCategory +
                '}';
    }
}
