package il.co.electriccollege.restaurant.registry;

import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by IrKha on 18.08.2017.
 */
public class OrderRegistry implements Iterator<Order> {
    private ArrayList<Order> highPriorityQueue = new ArrayList<>();
    private ArrayList<Order> midPriorityQueue = new ArrayList<>();
    private ArrayList<Order> lowPriorityQueue = new ArrayList<>();

    private Order start = null;

    public OrderRegistry(Order order){
         super();
        // this.start = highPriorityQueue.size()>0?highPriorityQueue.get(0):midPriorityQueue.size()>0?midPriorityQueue.get(0):lowPriorityQueue.size()>0?lowPriorityQueue.get(0):null;
         this.start = order;
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
       return highPriorityQueue.size() + midPriorityQueue.size() + lowPriorityQueue.size() > 0;
    }

    @Override
    public Order next() {
        if (!highPriorityQueue.isEmpty()){
            return highPriorityQueue.remove(0);
        }
        if (!midPriorityQueue.isEmpty()){
            return midPriorityQueue.remove(0);
        }
        if (!lowPriorityQueue.isEmpty()){
            return lowPriorityQueue.remove(0);
        }
        return null;
     }

     public void remove(Order order){
        // TODO
     }

    @Override
    public void remove(){

    }
}
