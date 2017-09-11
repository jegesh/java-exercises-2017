package il.co.electriccollege.restaurant.dishes;

public  abstract  class AbstractDish {
    private String name;
    private int id;
    private String description;
    private float price;
    private static int idCounter = 0;
    private DishCatagory catagory;
    private int preparationTime;

    public AbstractDish(int id, String name, float price, DishCatagory  catagory){
        this.name = name;
        this.price = price;
        this.id = id;
        idCounter++;
    }

    public AbstractDish(String name, float price,  DishCatagory  catagory){
        this.name = name;
        this.price= price;
        this.catagory=catagory;
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



    public DishCatagory getCatagory() {
        return catagory;
    }

    public void setCatagory(DishCatagory catagory) {
        this.catagory = catagory;
    }

    @Override
    public String toString() {
        return "il.co.electriccollege.restaurant.dishes.AbstractDish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                '}';
    }
}
