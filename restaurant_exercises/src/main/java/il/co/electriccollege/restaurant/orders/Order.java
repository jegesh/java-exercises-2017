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
    private int id;


    public Order(ArrayList<AbstractDish> dishes){
        this.dishes = dishes;
        this.orderTime = new Date();
        this.orderPrice = getTotal();
    }
    public float getTotal(){
        float summ = 0;
        for(AbstractDish d : dishes){
            summ += d.getPrice();
        }
        return summ;
    }
    public void setId(int id){
        this.id = id;
    }
    @Override
    public String toString() {
        String s = "";
        for(AbstractDish a: dishes){
            s+=a.toString()+" ";
        }
        return "Order{" +
                "id " + id+
                s+
                ", orderTime=" + orderTime +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
