package il.co.electriccollege.restaurant.gil.sql.dao;

/**
 * Created by Comp3 on 30/08/17.
 */
public class Dessert extends AbstractDish {

    private boolean bDay;

    public Dessert (String name, double price, String description, boolean bDay){
        super (name, price, description);
        this.type=DishType.DESSERT;
        this.bDay= bDay;


    }
    public boolean isbDay() {
        return bDay;
    }

    public void setbDay(boolean bDay) {
        this.bDay = bDay;
    }


}
