package il.co.electriccollege.restaurant.dishes;

/**
 * Created by yaakov on 8/16/17.. yossi
 */
public abstract class AbstractDish {
    private String name;
    private int id;
    private String description;
    private float price;
<<<<<<< HEAD
    private int preparationTime;
=======
    private static int idCounter = 0;
>>>>>>> master

    public AbstractDish(String name, float price){
        this.name = name;
        this.price = price;
        this.id = idCounter;
        idCounter++;
    }

    public static void resetIdCounter(){
        idCounter = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
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

    protected void setPrice(float price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

<<<<<<< HEAD
=======
    private int preparationTime;

    @Override
    public String toString() {
        return "AbstractDish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                '}';
    }
>>>>>>> master
}
