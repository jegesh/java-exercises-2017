
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class DbSessionManager {
    private static SessionFactory sessionFactory;

//    public DbSessionManager(){
//        setupSession();
//    }

    public DbSessionManager(String configFile){//add in order to use Dynamic class
        setupSession(configFile);
    }

    public void setupSession(String configFile) {//add in order to use Dynamic class
        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(configFile));
            sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public void setupSession(){//הפונקציה פועלת בכניסה לאפליקציה
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() //StandardServiceRegistry= שולט על כל הדברים מול הDB
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory(); //sessionFactory== מייצר את החיבור לDB
//        }
//        catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            e.printStackTrace();
//            StandardServiceRegistryBuilder.destroy( registry );
//            throw new ExceptionInInitializerError(e);
//        }
//    }

    public void tearDownSession() throws Exception {  //פונקציה זו עובדת כאשר יוצאים מהאפליקציה. החיבור לdb נסגר
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactoryInstance(){
        return sessionFactory;
    }
}
