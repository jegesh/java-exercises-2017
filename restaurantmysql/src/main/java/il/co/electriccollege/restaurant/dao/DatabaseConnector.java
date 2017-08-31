package il.co.electriccollege.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Comp14 on 30/08/2017.
 */
public class DatabaseConnector
{
  private Connection conn = null;

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost/restaurant";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

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
