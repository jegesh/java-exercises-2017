package il.co.electriccollege.restaurant.registry;

import il.co.electriccollege.restaurant.orders.Order;

import java.util.Iterator;

/**
 * Created by IrKha on 18.08.2017.
 */
public class OrderIterator implements Iterator<Order> {
    Order first;
    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public Order next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
