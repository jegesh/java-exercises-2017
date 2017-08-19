package il.co.electriccollege.restaurant;

import il.co.electriccollege.restaurant.dishes.*;
import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;
import il.co.electriccollege.restaurant.registry.CashRegistry;
import il.co.electriccollege.restaurant.registry.OrderRegistry;
import il.co.electriccollege.restaurant.staff.WaitStaffMember;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by IrKha on 18.08.2017.
 */
public class Test {
    private static Random gen = new Random();
    public static void main(String[] args) {
        CashRegistry cashRegistry = new CashRegistry();
        WaitStaffMember oleg = new WaitStaffMember("Oleg");

        ArrayList<AbstractDish> list = new ArrayList<>();
        BusinessLunch bus = new BusinessLunch("B", 20);
        bus.setSideDish(new SideDish("eggroll",225));
        list.add(bus);
        StandardDish st = new StandardDish("steak",180);
        st.setSideDish(new SideDish("salad", 21));
        list.add(st);
        Order order = new Order(list);
        oleg.receiveOrder(order);
        oleg.registerOrder(Priority.HIGH);
        //System.out.println(order);
        //list.clear();
        StandardDish st1 = new StandardDish("steak 120",1000);
        list.add(st1);
        Order order1 = new Order(list);
        oleg.receiveOrder(order1);
        oleg.registerOrder(Priority.MIDDLE);

        st1 = new StandardDish("steak 220",100);
        list.add(st1);
        order1 = new Order(list);
        oleg.receiveOrder(order1);
        oleg.registerOrder(Priority.MIDDLE);

        oleg.takePayment(20);
       // System.out.println(order1);
        Iterator<Order> queue = new OrderRegistry();
        while (queue.hasNext()) {
            System.out.println(queue.next());
        }

        System.out.println(cashRegistry.getBalance());

    }
    private static Order setRandomOrder(){
        ArrayList<AbstractDish> orderlist = new ArrayList<>();
        ArrayList<AbstractDish> menu = new ArrayList<>();
         // creating menu
       // menu.add(new BusinessLunch("Business",150));
        menu.add(new SideDish("mashrooms",20));
        menu.add(new SideDish("egg roll", 35));
        menu.add(new StandardDish("soup", 180));
        menu.add(new StandardDish("salad", 50));
       // setting random dishes to order
        int count = 0;
        while (count == 0)
        {
            count = gen.nextInt(10);
        }
       for(int i = 0; i < count; i++) {
           AbstractDish ab = menu.get(gen.nextInt(menu.size()));
           orderlist.add(ab);
           System.out.println(ab);
       }
        return new Order(orderlist);
    }
}
