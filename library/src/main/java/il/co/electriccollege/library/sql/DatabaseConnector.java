package il.co.electriccollege.library.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yaakov on 8/19/17.
 */
public class DatabaseConnector {
    private Connection conn = null;

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost/library";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Java2017";

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
