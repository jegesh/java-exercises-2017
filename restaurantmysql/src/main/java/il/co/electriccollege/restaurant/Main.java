package il.co.electriccollege.restaurant;

import il.co.electriccollege.restaurant.dal.DishDAL;
import il.co.electriccollege.restaurant.dao.DatabaseConnector;
import il.co.electriccollege.restaurant.dish.*;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {
        DishDAL dish = new DishDAL(new DatabaseConnector());



//        for(int i=1; i<10; i++) {
//           EndDish ed = new EndDish("Cake" + i, "Asian" + i, 2.5 + i);
//            boolean added = dish.addDish(md);
//       }
//       for(int i=1; i<10; i++) {
//           MainDish md = new MainDish("Fish" + i, "Europe" + i, 2.5 + i);
//         boolean added = dish.addDish(md);
//       }

//         StartDish sd = new StartDish("Sandwitch", "Israel", 2.3);
//         boolean added = dish.addDish(sd);
//         System.out.println("Was dish added to Restaraunt? " + added);
//        StartDish sd1 =new StartDish("Eggs","Best",2.5);
//        boolean added = dish.addDish(sd1);
     //   boolean removed= dish.removeDish(d1);
  //      Dish d2 = new StartDish("Omlet","Italian", 2.0);
//        boolean updated = dish.updateDishPrice(d2,7.3);
//        System.out.println("Was dish updated by price? " + updated);

        ArrayList<Dish > dishList = new ArrayList<Dish>();
//        dishList = dish.getAllDishes();
//        dishList = dish.getDishesByCategory(DishCategory.MAIN_DISH);
        dishList =dish.getTenCheapestDishes();
        for (Dish curr: dishList) {
            System.out.println(curr.toString());
        }
    }
}
