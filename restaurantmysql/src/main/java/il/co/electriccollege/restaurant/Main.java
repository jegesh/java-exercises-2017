package il.co.electriccollege.restaurant;

import il.co.electriccollege.restaurant.dal.DishDAL;
import il.co.electriccollege.restaurant.dao.DBConnector;
import il.co.electriccollege.restaurant.dish.StartDish;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {
        DishDAL dish = new DishDAL(new DBConnector());

                StartDish sd = new StartDish("Salad", "Bulgarian", 2.5);

              boolean added = dish.addDishToRestaurant(sd);
             System.out.println("Was dish added to Restaraunt? " + added);

    }
}
