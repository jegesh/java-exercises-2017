package il.co.electriccollege.sql.jdo;

import il.co.electriccollege.sql.jdo.entities.Category;
import il.co.electriccollege.sql.jdo.entities.Dish;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) {
        PersistenceManagerFactory pmf = JdoManager.getPmf();
        PersistenceManager persistenceManager = pmf.getPersistenceManager();

        Query q = persistenceManager.newQuery(Category.class);

        Dish dish = new Dish();
//        dish.setCategory();

//        persistenceManager.makePersistent()
    }
}
