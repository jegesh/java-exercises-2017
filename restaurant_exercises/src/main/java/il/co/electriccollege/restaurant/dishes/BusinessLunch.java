package il.co.electriccollege.restaurant.dishes;

/**
 * Created by yaakov on 8/16/17.
 */
public class BusinessLunch extends AbstractDish {

    public BusinessLunch(String name, float price) {
        super(name, price);
    }

    /**
     * adds dish to order at no additional price
     * @param sideDish
     */
    public void setSideDish(SideDish sideDish){
        // TODO
    }
}
