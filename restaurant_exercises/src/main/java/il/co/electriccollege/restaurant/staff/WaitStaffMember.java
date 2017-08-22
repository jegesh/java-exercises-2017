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
    private Order currentOrder;
    private float tips;
    private CashRegistry cashRegistry = new CashRegistry();
    private OrderRegistry orderRegistry = new OrderRegistry(currentOrder);

    public WaitStaffMember(String name){
        this.name = name;
    }

    public void receiveOrder(Order order){
        this.currentOrder = order;
      // registerOrder(Priority.HIGH);
    }

    public void takePayment(float tips){
        float payment = currentOrder.getOrderPrice() + tips;
        cashRegistry.registrySale(currentOrder);
    }

    public void registerOrder(Priority priority){
        cashRegistry.registryOrder(this.currentOrder);
        orderRegistry.add(currentOrder, priority);
    }

    @Override
    public String toString() {
        return "WaitStaffMember{" +
                "name='" + name + '\'' +
                ", currentOrder=" + currentOrder.toString() +
                ", tips=" + tips +
                '}';
    }
}
