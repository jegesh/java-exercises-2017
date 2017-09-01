package il.co.electriccollege.restaurant.yossi;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dal.DishesDal;
import il.co.electriccollege.restaurant.yossi.sql.dao.*;

import java.util.ArrayList;

import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.BREAKFAST;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.PASTA;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.SANDWICHES;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {

        DishesDal dishesDal = new DishesDal(new DatabaseConnector());

        //Breakfast b = new Breakfast("kafrit", "includ all vegteble and fresh drink", 50, BREAKFAST,"shpigel");
        //Pasta p = new Pasta("3 chees", "includ 3 kind of smely chees", 62.55, PASTA,"spaghetti","cheesee");
        //Sandwiches s = new Sandwiches("salamy", "includ 2 kind of salamy with humus", 17.95, SANDWICHES,"brown","half");
        //System.out.println(s.toString());
        //.addDish(s);

        ///get all dishes
        ArrayList<AbstractDish> dishList = new ArrayList<AbstractDish>();
        System.out.println("\n");
        System.out.println("ALL DISHES");
        System.out.println("===================");
        dishList = dishesDal.getAllDishes();
        for (AbstractDish curr: dishList)
        {
            System.out.println("Current DISH: " + curr.toString());
        }

        ///get all by catagory
        ArrayList<AbstractDish> dishList1 = new ArrayList<AbstractDish>();
        System.out.println("\n");
        System.out.println("BY CATAGORY");
        System.out.println("===================");
        dishList1 = dishesDal.getDishesByCategory(Category.PASTA.name());
        for (AbstractDish curr: dishList1)
        {
            System.out.println("Current DISH: " + curr.toString());
        }

        ///get all by catagory
        ArrayList<AbstractDish> dishList2 = new ArrayList<AbstractDish>();
        System.out.println("\n");
        System.out.println("3 cheepest");
        System.out.println("===================");
        dishList2 = dishesDal.getTenCheapestDishes();
        for (AbstractDish curr: dishList2)
        {
            System.out.println("Current DISH: " + curr.toString());
        }

        Breakfast b1 = new Breakfast("greeny", "includ all vegteble and fresh drink and frut", 30, BREAKFAST,"flat egg");
        System.out.println(b1.toString());
        dishesDal.addDish(b1);
        boolean updated = dishesDal.updatePrice(b1,29.5);
        System.out.println("Was dish updated by price? " + updated);

    }


}
