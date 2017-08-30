package il.co.electriccollege.restaurant.yossi;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dal.DishesDal;
import il.co.electriccollege.restaurant.yossi.sql.dao.Breakfast;

import static il.co.electriccollege.restaurant.yossi.sql.dao.Category.BREAKFAST;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) {

        DishesDal mediaDal = new DishesDal(new DatabaseConnector());

        Breakfast b = new Breakfast("kafrit", "includ all vegteble and fresh drink", 50.00f, BREAKFAST,"shpigel eye");
        mediaDal.addDish(b);
    }
}
