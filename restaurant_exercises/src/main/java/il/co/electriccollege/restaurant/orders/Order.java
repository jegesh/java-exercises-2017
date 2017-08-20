package il.co.electriccollege.restaurant.orders;

import il.co.electriccollege.restaurant.dishes.AbstractDish;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yaakov on 8/16/17.
 */
public class Order {

    private Date orderTime;
    private ArrayList<AbstractDish> dishes = new ArrayList<>();

    public Order() {
    }

    public Order(Date orderTime, ArrayList<AbstractDish> dishes) {
        this.orderTime = orderTime;
        this.dishes = dishes;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void getTotal() {

            float total = 0;
            for(AbstractDish i: dishes){
             total += i.getPrice();
            }

    }
}
