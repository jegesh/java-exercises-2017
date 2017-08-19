package il.co.electriccollege.restaurant.dishes;

/**
 * Created by yaakov on 8/16/17.
 */
public class BusinessLunch extends AbstractDish {
    private SideDish sideDish;
    public BusinessLunch(String name, float price) {
        super(name, price);
    }
    /**
     * adds dish to order at no additional price
     * @param sideDish
     */
    public void setSideDish(SideDish sideDish){
        this.sideDish = sideDish;
    }

    @Override
    public String toString() {
        return super.toString() + "SideDish{" +
                "sideDish=" + sideDish +
                '}';
    }
}
