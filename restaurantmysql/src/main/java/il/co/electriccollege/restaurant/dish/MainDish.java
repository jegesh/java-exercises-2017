package il.co.electriccollege.restaurant.dish;

/**
 * Created by Comp14 on 30/08/2017.
 */
public class MainDish extends AbstractDish{
    public MainDish(String name, String description, double price) {
        super(name, description, price, DishCategory.MAIN_DISH);
    }
}
