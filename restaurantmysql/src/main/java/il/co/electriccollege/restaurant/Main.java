package il.co.electriccollege.restaurant;

import il.co.electriccollege.restaurant.dal.DishDAL;
import il.co.electriccollege.restaurant.dao.DatabaseConnector;
import il.co.electriccollege.restaurant.dish.Dish;
import il.co.electriccollege.restaurant.dish.StartDish;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {
        DishDAL dish = new DishDAL(new DatabaseConnector());

        StartDish sd = new StartDish("Sandwitch", "Israel", 2.3);

              boolean added = dish.addDish(sd);
             System.out.println("Was dish added to Restaraunt? " + added);
//        Dish d1 =new StartDish("Eggs",null,2.5);
//        boolean removed= dish.removeDish(d1);

        Dish d2 = new StartDish("Salad","Russian", 0.0);
        boolean updated = dish.updateDishPrice(d2,7.3);
        System.out.println("Was dish updated by price? " + updated);
    }
}
