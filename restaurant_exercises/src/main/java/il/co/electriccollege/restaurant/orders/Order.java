package il.co.electriccollege.restaurant.orders;

/**
 * Created by yaakov on 8/16/17.
 */
public class Order {

    private Date orderTime;
    private ArrayList<int> orderDishes;

    public Order() {
    }

    public Order(Date orderTime, ArrayList<int> orderDishes) {
        this.orderTime = orderTime;
        this.orderDishes = orderDishes;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void getTotal() {

            float total = 0;
            for(int i: orderDishes){
                total += getPrice;
            }

    }
}
