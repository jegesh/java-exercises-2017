package il.co.electriccollege.restaurant.registry;

import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by IrKha on 18.08.2017.
 */
public class OrderRegistry implements Iterator<Order> {
    private ArrayList<Order> highPriorityQueue;
    private ArrayList<Order> midPriorityQueue;
    private ArrayList<Order> lowPriorityQueue;

    public OrderRegistry(Order order, Priority priority){
        switch (priority){
            case LOW:
                lowPriorityQueue.add(order);
             break;
            case MIDDLE:
                midPriorityQueue.add(order);
             break;
            case HIGH:
                highPriorityQueue.add(order);
             break;
        }
    }
    @Override
    public boolean hasNext() {
        if(highPriorityQueue.iterator().hasNext() || midPriorityQueue.iterator().hasNext() || lowPriorityQueue.iterator().hasNext())
            return true;
        return false;
    }
    @Override
    public Order next() {
        if(highPriorityQueue.iterator().hasNext())
            return highPriorityQueue.iterator().next();
        if(midPriorityQueue.iterator().hasNext())
            return midPriorityQueue.iterator().next();
        if(lowPriorityQueue.iterator().hasNext())
            return lowPriorityQueue.iterator().next();
        return null;
    }
    @Override
    public void remove() {

    }
}
