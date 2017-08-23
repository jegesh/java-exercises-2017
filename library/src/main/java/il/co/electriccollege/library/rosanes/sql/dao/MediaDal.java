package il.co.electriccollege.library.rosanes.sql.dao;

import il.co.electriccollege.library.rosanes.sql.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MediaDal
{
    private DatabaseConnector databaseConnector;

    public MediaDal(DatabaseConnector connection) {
        databaseConnector = connection;
    }
    public boolean addMediaToLibrary(AbstractMedia media){
        return false;
    }

    public boolean removeMedia(AbstractMedia media){
        return false;

    }

    public AbstractMedia getById(int id){
       String query = "SELECT * FROM media WHERE  id = %s";
       ResultSet rs =executeQuery(String.format(query,id));
       if (rs != null)
       {
           ArrayList<AbstractMedia> returnObjs = buildMediaObject(rs);
           if(returnObjs!= null)
             return buildMediaObject(rs).get(0);
       }
       return null;

    }


    private ArrayList<AbstractMedia> buildMediaObject (ResultSet rs)
    {
        ArrayList<AbstractMedia> mediaList = new ArrayList<AbstractMedia>();
        boolean hasNextRow = true;
        while ( hasNextRow)
        {
            try
            {
                hasNextRow= rs.next();
                if( hasNextRow)
                {
                   if( rs.getString("media_type").equals(MediaType.BOOK.name()))
                   {
                       Book book = new Book(rs.getString("name"),
                                            rs.getString("publisher"),
                                            rs.getDate("publication_date"));
                       book.setId(rs.getInt("id"));
                       mediaList.add(book);

                   }
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
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
    private ResultSet executeQuery (String querStr) {
        Connection conn = databaseConnector.getDbConnection();
        if (conn != null) {
            Statement stmt = null;


            System.out.println("Creating database statement");
            try {
                // create query statement
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(querStr);
                rs.close();
                stmt.close();
                return rs;

                }
            catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            }
            finally {
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
