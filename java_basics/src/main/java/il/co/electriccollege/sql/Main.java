package il.co.electriccollege.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yaakov on 8/19/17.
 */
public class Main {

    public static void main(String[] args) {
        // connect to database
        DatabaseConnector connector = new DatabaseConnector();
        Connection conn = connector.getDbConnection();
        if (conn != null) {
            Statement stmt = null;

            System.out.println("Creating database statement");
            try {
                // create query statement
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT * FROM categories";
                ResultSet rs = stmt.executeQuery(sql);

                // Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    //Display values
                    System.out.println("ID: " + id + ", name: " + name);
                }
                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }
    }


}

