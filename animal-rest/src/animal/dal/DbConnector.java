package animal.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    //  Database credentials
    private String USER = "elecjava2017";
    private String PASS = "elecjava2017";
    private String DB_URL = "jdbc:mysql://electric-java-2017.ceavgnl7zcnr.eu-west-2.rds.amazonaws.com:3306/";
    public static final String DB_TEST = "carsales_test";
    public static final String DB_PRODUCTION = "animals";
    private String dbName;
    
    public DbConnector(String dbName) {
    		this.dbName = dbName;
    }
    
    public Connection getDbConnection() {

        try {
            // Open a connection
            System.out.println("Connecting to database");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(DB_URL + dbName, USER, PASS); // add password if necessary

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
