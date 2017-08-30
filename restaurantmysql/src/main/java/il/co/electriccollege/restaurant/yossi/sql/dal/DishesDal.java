package il.co.electriccollege.restaurant.yossi.sql.dal;

import il.co.electriccollege.restaurant.yossi.sql.DatabaseConnector;
import il.co.electriccollege.restaurant.yossi.sql.dao.AbstractDish;


public class DishesDal {

    DatabaseConnector databaseConnector;

    public DishesDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    public void addDish(AbstractDish dish){
        String query1 = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) ";


    }
}
