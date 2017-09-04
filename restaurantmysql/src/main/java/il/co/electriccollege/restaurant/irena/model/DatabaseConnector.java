package il.co.electriccollege.restaurant.irena.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yaakov on 8/19/17.
 */
public class DatabaseConnector {
    private Connection conn = null;
    Properties prop = new Properties();
    String dbhost = "localhost";

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/resturant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public Connection getDbConnection() {

        try {
            // Open a connection
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS); // add password if necessary
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
