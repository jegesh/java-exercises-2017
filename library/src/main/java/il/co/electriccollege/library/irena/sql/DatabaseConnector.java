package il.co.electriccollege.library.irena.sql;

import java.sql.*;

/**
 * Created by yaakov on 8/19/17.
 */
public class DatabaseConnector {
    private Connection conn = null;

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


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
