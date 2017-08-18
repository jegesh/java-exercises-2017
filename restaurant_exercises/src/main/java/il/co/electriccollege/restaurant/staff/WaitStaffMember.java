package il.co.electriccollege.restaurant.staff;

import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;
import il.co.electriccollege.restaurant.registry.CashRegistry;
import il.co.electriccollege.restaurant.registry.OrderRegistry;

/**
 * Created by yaakov on 8/16/17.
 */
public class WaitStaffMember {

    private String name;
    private static int id = 0;
    private Order currentOrder;
    private float tips;
    private CashRegistry c = new CashRegistry();

    public WaitStaffMember(String name, Order currentOrder, float tips){
        this.name = name;
        this.currentOrder = currentOrder;
        receiveOrder(currentOrder);
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "WaitStaffMember{" +
                "name='" + name + '\'' +
                ", currentOrder=" + currentOrder +
                ", tips=" + tips +
                ", c=" + c +
                '}';
    }

    public void receiveOrder(Order order){
        this.id++;
        registerOrder(Priority.HIGH);
    }

    public void takePayment(float tips){
        c.registrySale(currentOrder);
    }

    public void registerOrder(Priority priority){
        c.registrySale(this.currentOrder);
        OrderRegistry reg = new OrderRegistry(currentOrder, priority);
    }

}
