package il.co.electriccollege.restaurant.irena.hibernate;


import il.co.electriccollege.restaurant.irena.hibernate.dao.*;
import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.Roasting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Comp8 on 04/09/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager();
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Dish grill = new Dish();
        grill.setDescription("grill tov");
        grill.setPrice(20);
        grill.setName("name");
        session.save(grill);
        session.close();
        sessionManager.tearDownSession();
    }

}
