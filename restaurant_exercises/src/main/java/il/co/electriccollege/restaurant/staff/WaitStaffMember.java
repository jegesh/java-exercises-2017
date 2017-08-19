package il.co.electriccollege.restaurant.staff;

import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;

/**
 * Created by yaakov on 8/16/17.
 */
public class WaitStaffMember {

    private String name;
    private int id;
    private Order currentOrder;
    private float tips;
    private float salary;

    public WaitStaffMember() {
    }

    public WaitStaffMember(String name, Order currentOrder, float tips, float salary) {
        this.name = name;
        this.currentOrder = currentOrder;
        this.tips = tips;
        this.salary = salary;
    }

    public void receiveOrder(Order order){
        // TODO
    }

    public void takePayment(float tips){
        // TODO
    }

    public void registerOrder(Priority priority){
        // TODO
    }

}
