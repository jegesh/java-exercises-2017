package il.co.electriccollege.restaurant.gil.sql.dao;

/**
 * Created by Comp3 on 30/08/17.
 */
public class Appetizer extends AbstractDish {

    private boolean centerDish;

    public Appetizer(String name, double price, String description, Boolean centerDish) {
        super(name, price, description);
        this.type = DishType.APPETIZER;
        this.centerDish = centerDish;

    }

    public boolean isCenterDish() {
        return centerDish;
    }

    public void setCenterDish(boolean centerDish) {
        this.centerDish = centerDish;
    }
}
