package il.co.electriccollege.restaurant;


import il.co.electriccollege.restaurant.dishes.AbstractDish;
import il.co.electriccollege.restaurant.dishes.BusinessLunch;
import il.co.electriccollege.restaurant.dishes.SideDish;
import il.co.electriccollege.restaurant.dishes.StandardDish;
import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;
import il.co.electriccollege.restaurant.registry.CashRegistry;
import il.co.electriccollege.restaurant.staff.WaitStaffMember;

import java.util.ArrayList;
import org.junit.*;
import org.junit.Test;

/**
 * Created by yaakov on 8/20/17.
 */
public class OrderRegistryTest {

    @Test
    public void testRemoveDish(){
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
        assert order.getSize() == 5;

        assert st.getPrice() == 201;
        assert bus.getPrice() == 100;
    }

    @Test
    public void testRegistryPriority(){
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

    }
}
