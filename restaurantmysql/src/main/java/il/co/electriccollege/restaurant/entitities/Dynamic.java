package il.co.electriccollege.restaurant.entitities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Dynamic {
    private DbSessionManager sessionManager;

    public Dynamic(String configfile)
    {
        sessionManager= new DbSessionManager(configfile);
    }

    public static void main(String[] args) {
        new Dynamic(args[0]).start();
    }

    private void start() {
    //    Session session = DbSessionManager.getSessionFactoryInstance().openSession();
  //      CriteriaBuilder builder = session.getCriteriaBuilder();

        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Menu menu= new Menu();
        menu.setName("Dynamic pizza2");
        menu.setHoursAvailable("12:00-18:00");

        session.save(menu);
        session.close();
    }


}
