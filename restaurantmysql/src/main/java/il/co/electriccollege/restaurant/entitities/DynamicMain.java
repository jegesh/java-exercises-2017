package il.co.electriccollege.restaurant.entitities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.print.attribute.standard.Media;

public class DynamicMain {

    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager(args[0]);
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Menu menu= new Menu();
        menu.setName("Dynamic pizza");
        session.save(menu);

        session.close();
        sessionManager.tearDownSession();
    }

}
