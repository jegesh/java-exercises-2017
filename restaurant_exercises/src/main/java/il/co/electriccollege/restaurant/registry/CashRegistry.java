package il.co.electriccollege.restaurant.registry;

import il.co.electriccollege.restaurant.orders.Order;

/**
 * Created by IrKha on 18.08.2017.
 */
public class CashRegistry {
    private static float balance=0;
    public CashRegistry(){
    }
    public void registrySale(Order order){
        this.balance += order.getTotal();
    }
    public void registryOrder(Order order){this.balance -= order.getTotal();}
    public float getBalance(){return balance;}
}
