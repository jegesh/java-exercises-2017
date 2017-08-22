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
   //private ArrayList<Order> highPriorityQueue = new ArrayList<>();
    private static ArrayList<Order> midPriorityQueue = new ArrayList<>();
   //private static ArrayList<Order> midPriorityQueue = new ArrayList<>();
    private static ArrayList<Order> lowPriorityQueue = new ArrayList<>();

    private Order start = null;
    private int index = 0;
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
       return index < highPriorityQueue.size()+midPriorityQueue.size()+lowPriorityQueue.size();
    }
    @Override
    public Order next() {
        Order curr = this.start;
        while (index < highPriorityQueue.size()){
            return curr = highPriorityQueue.get(index++);
        }
        while (index >= highPriorityQueue.size() && index < midPriorityQueue.size()+highPriorityQueue.size()){
            return curr = midPriorityQueue.get(index++-highPriorityQueue.size());
        }
        while (index >= midPriorityQueue.size() + highPriorityQueue.size() && index < midPriorityQueue.size()+highPriorityQueue.size()+lowPriorityQueue.size()){
            return curr = lowPriorityQueue.get(index++-(midPriorityQueue.size()+highPriorityQueue.size()));
        }
        return curr;
     }
  @Override
    public void remove(){
        if(index < highPriorityQueue.size()) {
            highPriorityQueue.remove(index);
        }
        if (index >= highPriorityQueue.size() && index < midPriorityQueue.size()+highPriorityQueue.size()) {
            midPriorityQueue.remove(index-highPriorityQueue.size());
        }
        if (index >= midPriorityQueue.size() + highPriorityQueue.size() && index < midPriorityQueue.size()+highPriorityQueue.size()+lowPriorityQueue.size()) {
           lowPriorityQueue.remove(index-(midPriorityQueue.size()+highPriorityQueue.size()));
        }
    }
}
