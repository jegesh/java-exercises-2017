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

        //
        ArrayList<AbstractDish> list = new ArrayList<>();
        BusinessLunch bus = new BusinessLunch("B", 20, null);
        bus.setSideDish(new SideDish("eggroll",225));
        list.add(bus);

        StandardDish st = new StandardDish("steak",180);

        st.setSideDish(new SideDish("salad", 21));
        list.add(st);

        list.add(new StandardDish("steak", 180));
        list.add(new StandardDish("steak", 180));
        list.add(new StandardDish("steak", 220));



        SideDish chips = new SideDish("chips", 20);
        list.add(chips);

        Order order = new Order(list);
        order.removeDish(4);
        oleg.receiveOrder(order);
        oleg.registerOrder(Priority.MIDDLE);
        //System.out.println(order);
        //list.clear();
        ArrayList<AbstractDish> list2 = new ArrayList<>();
        StandardDish st1 = new StandardDish("steak 120",1000);
        list2.add(st1);
        Order order1 = new Order(list2);
        oleg.receiveOrder(order1);
        oleg.registerOrder(Priority.LOW);

        ArrayList<AbstractDish> list3 = new ArrayList<>();
        st1 = new StandardDish("steak 320",100);
        list3.add(st1);
        order1 = new Order(list3);
        oleg.receiveOrder(order1);
        oleg.registerOrder(Priority.HIGH);


        ArrayList<AbstractDish> list4 = new ArrayList<>();
        st1 = new StandardDish("steak 420",100);
        st1.setSideDish(new SideDish("haka",1));
        list4.add(st1);
        order1 = new Order(list4);
        oleg.receiveOrder(order1);
        oleg.registerOrder(Priority.HIGH);

        Order or = new Order();
        System.out.println(or);
       // System.out.println(order1);


        Iterator<Order> queue = new OrderRegistry(order);
        Order o = null;
        while (queue.hasNext()) {
            System.out.println(queue.next());
            o = queue.next();
        }
        oleg.takePayment(20);
        queue.remove();
        System.out.println(cashRegistry.getBalance());
        queue = new OrderRegistry(order);
        while (queue.hasNext()) {
            System.out.println(queue.next());
            o = queue.next();
        }
        System.out.println();
        System.out.println(o);
        System.out.println();
        queue.remove();
        queue = new OrderRegistry(order);
        while (queue.hasNext()) {
            System.out.println(queue.next());
        }
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
