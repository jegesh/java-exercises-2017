package il.co.electriccollege.restaurant.orders;

import il.co.electriccollege.restaurant.dishes.AbstractDish;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yaakov on 8/16/17.
 */
public class Order {
    private ArrayList<AbstractDish> dishes;
    private Date orderTime;
    private float orderPrice = 0;
    public Order(ArrayList<AbstractDish> dishes){
        this.dishes = dishes;
        this.orderTime = new Date();
    }
    public float getOrderPrice(){
        for(AbstractDish d : dishes){
            orderPrice += d.getPrice();
        }
        return orderPrice;
    }

}
