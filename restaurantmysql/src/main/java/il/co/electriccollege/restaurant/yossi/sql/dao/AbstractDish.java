package il.co.electriccollege.restaurant.yossi.sql.dao;

public abstract class AbstractDish {

    int id;
    String name;
    public String description;
    public float price;
    Category category;
    int countId = 0;

    public AbstractDish() {
    }

    public AbstractDish(int id, String name, String description, float price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public AbstractDish(String name, String description, float price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        countId++;
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
