package il.co.electriccollege.restaurant.irena.hibernate.resturant_new;

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

    public DbSessionManager(String configFile){
        setupSession(configFile);
    }

    public void setupSession(String configFile){
        // A SessionFactory is set up once for an application!
       /* final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();*/
        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(configFile));
            sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }
       /* try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
            throw new ExceptionInInitializerError(e);
        }*/
    }

    public void tearDownSession() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactoryInstance(){
        return sessionFactory;
    }
}
