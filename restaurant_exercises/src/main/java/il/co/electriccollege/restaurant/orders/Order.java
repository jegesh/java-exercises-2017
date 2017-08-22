package il.co.electriccollege.restaurant.orders;

import com.sun.org.apache.xpath.internal.operations.Or;
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
    private static int idCounter = 0;

    public Order(){
        this(new ArrayList<AbstractDish>());
        this.id = idCounter++;
    }

    public Order(ArrayList<AbstractDish> dishes){
        this.dishes = dishes;
        this.orderTime = new Date();
        this.orderPrice = getTotal();
    }

    public int getSize(){
        return dishes.size();
    }

    public void addDish(AbstractDish dish){
        dishes.add(dish);
        orderPrice += dish.getPrice();
    }

    public void removeDish(AbstractDish dish){
        dishes.remove(dish);
        orderPrice -= dish.getPrice();
    }

    public void removeDish(int dishId){
        for(AbstractDish dish: dishes){
            if(dish.getId() == dishId){
                dishes.remove(dish);
                orderPrice -= dish.getPrice();
                return;
            }
        }
    }

    public float getOrderPrice(){
        return orderPrice;
    }

    private float getTotal(){
        float summ = 0;
        for(AbstractDish d : dishes){
            summ += d.getPrice();
        }
        return summ;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
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
