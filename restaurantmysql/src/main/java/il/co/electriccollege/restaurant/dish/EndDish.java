package il.co.electriccollege.restaurant.dish;

/**
 * Created by Comp14 on 30/08/2017.
 */
public class EndDish extends Dish {

    public EndDish(String name, String description, double price) {
        super(name, description, price, DishCategory.END_DISH);
    }

    @Override
    public String toString() {
        return "EndDish: " + super.toString();
    }
}

