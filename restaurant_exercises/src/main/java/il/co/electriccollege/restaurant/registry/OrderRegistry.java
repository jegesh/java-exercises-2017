package il.co.electriccollege.restaurant.registry;

import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by IrKha on 18.08.2017.
 */
public class OrderRegistry implements Iterator<Order> {
    private static ArrayList<Order> highPriorityQueue = new ArrayList<>();
    private static ArrayList<Order> midPriorityQueue = new ArrayList<>();
    private static ArrayList<Order> lowPriorityQueue = new ArrayList<>();

    private Order start = null;
    private int index = 0;
     public OrderRegistry(){
         super();
    }
    public void add(Order order, Priority priority){
        switch (priority){
            case LOW:
                this.lowPriorityQueue.add(order);
                return;
            case MIDDLE:
                this.midPriorityQueue.add(order);
                return;
            case HIGH:
                this.highPriorityQueue.add(order);
                return;
        }
    }

    @Override
    public boolean hasNext() {
       return index < highPriorityQueue.size()+midPriorityQueue.size()+lowPriorityQueue.size();
    }
    @Override
    public Order next() {
        Order curr = start;
        while(index < highPriorityQueue.size()) {
            curr = highPriorityQueue.get(index);
            index++;
        }
        while (index >= highPriorityQueue.size() && index < (midPriorityQueue.size() + highPriorityQueue.size())-1) {
            curr = midPriorityQueue.get(index);
            index++;
        }
        while (index >= (highPriorityQueue.size() + midPriorityQueue.size()) && hasNext()) {
            curr = lowPriorityQueue.get(index);
            index++;
        }
        return curr;
     }
    @Override
    public void remove(){
        while(index < highPriorityQueue.size()) {
            highPriorityQueue.remove(index);
        }
        while (index - highPriorityQueue.size() < midPriorityQueue.size()) {
            midPriorityQueue.remove(index);
        }
        while (index - highPriorityQueue.size() - midPriorityQueue.size() < lowPriorityQueue.size()) {
           lowPriorityQueue.remove(index);
        }
    }
}
