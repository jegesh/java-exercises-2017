package il.co.electriccollege.library.sql.dal;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dao.AbstractMedia;
import il.co.electriccollege.library.sql.dao.Book;
import il.co.electriccollege.library.sql.dao.MediaType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yaakov on 8/23/17.
 */
public class MediaDal {
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;

    public MediaDal(DatabaseConnector connector){
        databaseConnector = connector;
    }

    public boolean addMediaToLibrary(AbstractMedia media){
        return false;
    }

    public boolean removeMedia(AbstractMedia media){
        return false;

    }

    public AbstractMedia getById(int id){
        String query = "SELECT * FROM media WHERE id = %s";
        ResultSet rs = executeQuery(String.format(query, id));
        if(rs != null){
            ArrayList<AbstractMedia> returnedObjs = buildMediaObject(rs);
            if(returnedObjs != null)
                return returnedObjs.get(0);
        }
        return null;
    }

    private ArrayList<AbstractMedia> buildMediaObject(ResultSet rs){
        ArrayList<AbstractMedia> mediaList = new ArrayList<>();
        boolean hasNextRow = true;
        while(hasNextRow){
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if(hasNextRow){
                    if (rs.getString("media_type").equals(MediaType.BOOK.name())){
                            Book book = new Book(
                                    rs.getString("name"),
                                    rs.getString("publisher"),
                                    rs.getDate("publication_date")
                                    );
                            book.setId(rs.getInt("id"));
                            mediaList.add(book);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();

                return null;
            }



        }
        //finally block used to close resources
        try {
            rs.close();
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
        return mediaList;
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

    private ResultSet executeQuery(String queryStr) {
        conn = databaseConnector.getDbConnection();
        if (conn != null) {

            System.out.println("Creating database statement");
            try {
                // create query statement
                stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(queryStr);

                return rs;

            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            }
        }
        return null;
    }
}
