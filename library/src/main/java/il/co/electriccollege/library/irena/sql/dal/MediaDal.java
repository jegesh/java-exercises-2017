package il.co.electriccollege.library.irena.sql.dal;

import il.co.electriccollege.library.irena.sql.dao.*;
import il.co.electriccollege.library.irena.sql.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Comp8 on 23/08/17.
 */
public class MediaDal {
    private DatabaseConnector dbConnector;

    public MediaDal(DatabaseConnector connector) {
        dbConnector = connector;
    }

    public boolean addMediaToLib(AbstractMedia media) {
        String sql = "INSERT into MEDIA ("+media.getName()+", "+media.getPublisher()+", "+media.getPublicationDate()+", "+ MediaStatus.AVAILABLE+", "+null;
        if(media instanceof AudioBook)
         if(media instanceof AudioBook){
            sql += ", "+((AudioBook) media).getNarrator()+", "+((AudioBook) media).getDuration();
        }
        if(media instanceof Magazine){
            sql += ", "+((Magazine) media).getIssueNum();
        }
        sql += ")";
        return false;
    }

    public boolean removeMedia(AbstractMedia media) {
        return false;
    }

    public AbstractMedia getById(int id) throws SQLException {
        String query = "SELECT * FROM media WHERE id = %s";
        ResultSet rs = exequteQuery(String.format(query, id));
        if(rs != null){
            ArrayList<AbstractMedia> listMedia  = buildMediaObject(rs);
            if(listMedia != null) return listMedia.get(0);
        }
        return null;
    }

    public ArrayList<AbstractMedia> getByName(String name) {
        return null;
    }

    public ArrayList<AbstractMedia> getByMediaType(MediaType type) {
        return null;
    }

    public boolean checkoutMedia(int id) {
        return false;
    }

    public boolean returnMedia(int id) {
        return false;
    }

    private ArrayList<AbstractMedia> buildMediaObject(ResultSet rs) throws SQLException {
        ArrayList<AbstractMedia> medialist = new ArrayList<>();
        boolean flag = true;
        while (flag){
            try {
                flag = rs.next();
                if(flag){

                  if(rs.getString("media_type").equals(MediaType.BOOK.name())){

                      Book book = new Book(rs.getString("name") , rs.getString("publisher"), rs.getDate("publication_date"));
                      medialist.add(book);
                  }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    private ResultSet exequteQuery(String queryString) {
        Connection conn = dbConnector.getDbConnection();
        if (conn != null) {
            Statement stmt = null;
            System.out.println("Creating database statement");
            try {
                // create query statement
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryString);
                /*stmt.close();
                conn.close();*/
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
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        return null;
    }
}

