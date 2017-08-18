package il.co.electriccollege.restaurant;

import il.co.electriccollege.restaurant.dishes.AbstractDish;
import il.co.electriccollege.restaurant.dishes.BusinessLunch;
import il.co.electriccollege.restaurant.dishes.SideDish;
import il.co.electriccollege.restaurant.dishes.StandardDish;
import il.co.electriccollege.restaurant.orders.Order;
import il.co.electriccollege.restaurant.orders.Priority;
import il.co.electriccollege.restaurant.staff.WaitStaffMember;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IrKha on 18.08.2017.
 */
public class Test {
    private static Random gen = new Random();
    public static void main(String[] args) {
        Order order = setRandomOrder();
        //WaitStaffMember oleg = new WaitStaffMember("Oleg", order, 10);
        System.out.println(order);

        //oleg.registerOrder(Priority.MIDDLE);
       // System.out.println(oleg);
        System.out.println();
    }
    private static Order setRandomOrder(){
        ArrayList<AbstractDish> orderlist = new ArrayList<>();
        ArrayList<AbstractDish> menu = new ArrayList<>();
         // creating menu
        menu.add(new BusinessLunch("Business",150));
        menu.add(new SideDish("mashrooms",20));
        menu.add(new SideDish("egg roll", 35));
        menu.add(new StandardDish("soup", 180));
        menu.add(new StandardDish("salad", 50));
       // setting random dishes to order
       int count = gen.nextInt(10);
       for(int i = 0; i < count; i++) {
           AbstractDish ab = menu.get(gen.nextInt(menu.size()));
           orderlist.add(ab);
           System.out.println(ab);
       }
        return new Order(orderlist);
    }
}
