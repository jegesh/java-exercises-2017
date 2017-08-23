package il.co.electriccollege.library.sql.dal;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dao.AbstractMedia;
import il.co.electriccollege.library.sql.dao.MediaType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Comp14 on 23/08/2017.
 */
public class MediaDAL {

    DatabaseConnector databaseCconnector = new DatabaseConnector();

    public MediaDAL(DatabaseConnector databaseCconnector) {
        this.databaseCconnector = databaseCconnector;
    }

    public boolean addMediaToLibrary(AbstractMedia media){
        return false;
    }

    public boolean removeMedia(AbstractMedia media){
        return false;

    }

    public AbstractMedia getById(int id){
        return null;
    }

    public ArrayList<AbstractMedia> getByMediaType(MediaType type){
        return null;
    }

    public ArrayList<AbstractMedia> getByName(String name){
        return null;
    }

    public boolean checkoutMedia(int id){
        return false;

    }

    public boolean returnMedia(int id){
        return false;

    }

    private ResultSet executeQuery(String queryStr){
        Connection conn = databaseCconnector.getDbConnection();
        if (conn != null) {
            Statement stmt = null;

            System.out.println("Creating database statement");
            try {
                // create query statement
                stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(queryStr);
                // Clean-up environment
            
                return rs;

            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();

            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();

                } catch (SQLException se2) {
                    // nothing we can do
                }
                try {
                    if (conn != null)
                        conn.close();

                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }
        return null;
    }

}