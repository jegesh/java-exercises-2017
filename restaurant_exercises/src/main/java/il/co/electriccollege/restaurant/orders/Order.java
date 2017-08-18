package il.co.electriccollege.restaurant.orders;

/**
 * Created by yaakov on 8/16/17.
 */
public class Order {
    private ArrayList<SideDish> sideDish;
    private float price;
    public Order(SideDish sideDish){
        this.sideDish = sideDish;

    }
}
