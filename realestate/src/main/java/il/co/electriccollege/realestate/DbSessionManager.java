package il.co.electriccollege.realestate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by yaakov on 8/22/17.
 */
public class DbSessionManager {
    private static SessionFactory sessionFactory;

    /**
     *
     */
    public DbSessionManager(){
        setupSession();
    }

    private void setupSession(){
//         A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings from hibernate.cfg.xml or other xml config

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    public void tearDownSession() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public SessionFactory getSessionFactoryInstance(){
        return sessionFactory;
    }
}