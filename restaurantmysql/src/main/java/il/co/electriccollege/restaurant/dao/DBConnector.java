package il.co.electriccollege.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Comp14 on 30/08/2017.
 */
public class DBConnector
{
    private Connection conn = null;

    static final String DBurl = "jdbc:mysql://localhost/restaurantmysql";

    static final String USER ="root";
    static final String PASS ="root";

    public Connection getDBConnection()
    {
        System.out.println("Connecting to DB");
        try {
            conn = DriverManager.getConnection(DBurl, USER, PASS);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
