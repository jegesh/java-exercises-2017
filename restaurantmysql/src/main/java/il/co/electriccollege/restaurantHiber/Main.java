package il.co.electriccollege.restaurantHiber;

//import il.co.electriccollege.restaurant.dal.DishDAL;
//import il.co.electriccollege.restaurant.dao.DatabaseConnector;
import il.co.electriccollege.restaurantHiber.entity.*;
import il.co.electriccollege.restaurantHiber.entity.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.awt.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by yaakov on 8/28/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        DbSessionManager sessionManager = new DbSessionManager();
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Dish dish = new Dish();
        dish.setDishCategory("START_DISH");
        dish.setName("EggsRus");
        dish.setPrice(2.5);
        session.save(dish);
        session.close();
        sessionManager.tearDownSession();
    }
}
