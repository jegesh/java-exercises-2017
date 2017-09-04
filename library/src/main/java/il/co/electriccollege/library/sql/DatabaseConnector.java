package il.co.electriccollege.library.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yaakov on 8/19/17.
 */
public class DatabaseConnector {
    private Connection conn = null;
    private static final String DB_NAME = "DB_NAME";
    private static final String DB_HOSTNAME = "DB_HOSTNAME";
    private static final String DB_USERNAME = "DB_USERNAME";
    private static final String DB_PASSWORD = "DB_PASSWORD";

    // JDBC driver name and database URL

    private String dbHost = "localhost";
    //  Database credentials
    private String USER = "root";
    private String PASS = null;
    private String DB_URL = "jdbc:mysql://%s/%s";
    private String dbName = "library";

    public DatabaseConnector(){
        Map<String, String> envMap = System.getenv();
        if(envMap.containsKey(DB_HOSTNAME)){
            dbHost = envMap.get(DB_HOSTNAME);
        }
        if(envMap.containsKey(DB_NAME))
            dbName = envMap.get(DB_NAME);
        if(envMap.containsKey(DB_USERNAME))
            USER = envMap.get(DB_USERNAME);
        if(envMap.containsKey(DB_PASSWORD))
            PASS = envMap.get(DB_PASSWORD);
        DB_URL = String.format(DB_URL, dbHost, dbName);
    }

    public DatabaseConnector(boolean useDefaultConfigFile) throws IOException {
        setConnectionProperties(null);

    }

    private void setConnectionProperties(String configFile) throws IOException {
        Properties properties = new Properties();
        if(configFile != null)
            properties.load(new FileInputStream(new File(configFile)));
        else
            properties.load(new FileInputStream(new File("config.properties")));
        dbName = properties.getProperty("library.db.name");
        dbHost = properties.getProperty("library.db.hostname");
        USER = properties.getProperty("library.db.username");
        PASS = properties.getProperty("library.db.password");
        DB_URL = String.format(DB_URL, dbHost, dbName);
    }

    public DatabaseConnector(String configFile) throws IOException {
        setConnectionProperties(configFile);
    }

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
