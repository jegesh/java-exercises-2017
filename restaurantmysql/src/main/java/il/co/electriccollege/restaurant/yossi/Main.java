package il.co.electriccollege.restaurant.yossi;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dal.DishesDal;
import il.co.electriccollege.restaurant.yossi.sql.dao.Breakfast;
import il.co.electriccollege.restaurant.yossi.sql.dao.Pasta;
import il.co.electriccollege.restaurant.yossi.sql.dao.Sandwiches;

import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.BREAKFAST;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.PASTA;
import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.SANDWICHES;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {

        DishesDal mediaDal = new DishesDal(new DatabaseConnector());

        //Breakfast b = new Breakfast("kafrit", "includ all vegteble and fresh drink", 50, BREAKFAST,"shpigel");
        //Pasta p = new Pasta("3 chees", "includ 3 kind of smely chees", 62.55, PASTA,"spaghetti","cheesee");
        Sandwiches s = new Sandwiches("salamy", "includ 2 kind of salamy with humus", 17.95, SANDWICHES,"brown","half");
        System.out.println(s.toString());
        mediaDal.addDish(s);
    }
}
