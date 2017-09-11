package il.co.electriccollege.restaurant.hibernate;

import il.co.electriccollege.restaurant.hibernate.entity.AbstractDish;
import il.co.electriccollege.restaurant.hibernate.entity.Breakfast;
import il.co.electriccollege.restaurant.hibernate.entity.Category;
import il.co.electriccollege.restaurant.hibernate.entity.Pasta;
import il.co.electriccollege.restaurant.hibernate.DbSessionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static il.co.electriccollege.restaurant.hibernate.entity.Category.BREAKFAST;


/**
 * Created by yaakov on 8/28/17.
 */
public class Main {



        public static void main (String[]args) throws Exception {

            DbSessionManager sessionManager = new DbSessionManager();
            SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            AbstractDish dish = new AbstractDish();
            dish.setName("yami");
            dish.setDescription("very good one");
            dish.setPrice(55.30);
            session.save(dish);
            session.close();
            sessionManager.tearDownSession();
        }


}
