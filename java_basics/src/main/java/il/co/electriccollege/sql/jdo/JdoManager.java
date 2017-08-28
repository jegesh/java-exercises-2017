package il.co.electriccollege.sql.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import java.util.Properties;

/**
 * Created by yaakov on 8/20/17.
 */
public class JdoManager {

    public static PersistenceManagerFactory getPmf() {
        Properties properties = new Properties();
        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "");
        properties.setProperty("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:mysql://localhost/test");
        properties.setProperty("javax.jdo.option.ConnectionUserName", "root");
//        properties.setProperty("javax.jdo.option.ConnectionPassword", "root");

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(properties);
        return pmf;
    }
}
