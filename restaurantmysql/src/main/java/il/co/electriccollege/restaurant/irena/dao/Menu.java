package il.co.electriccollege.restaurant.irena.dao;

/**
 * Created by Comp8 on 30/08/17.
 */
public class Menu {
    private Dish dish;
    private float price;
    public Menu(Dish dish, float price){
        this.dish = dish;
        this.price = price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
