package il.co.electriccollege.library.irena.sql.dal;

import il.co.electriccollege.library.irena.sql.dao.*;
import il.co.electriccollege.library.irena.sql.DatabaseConnector;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Comp8 on 23/08/17.
 */
public class MediaDal {

    private static final String FIELD_MEDIA_TYPE = "media_type";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PABLISHER = "pablisher";
    private static final String FIELD_PABLISHER_DATE = "publication_date";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NARRATOR = "narrator";
    private static final String FIELD_DURATION = "duration";
    private static final String FIELD_ISSUE = "issue";
    private static final String FIELD_MEDIA_STATUS = "media_status";
    private static final String TABLE_NAME = "media";
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;

    public MediaDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    public boolean addMediaToLib(AbstractMedia media) {
        String name = media.getName();
        String publisher = media.getPublisher();
        LocalDate publication_date = media.getPublicationDate();
        String mediaStatus = MediaStatus.AVAILABLE.name();
        String mediaType = MediaType.BOOK.name();
        String narrator = null;
        Integer duration = null;
        String issue = "";
        String query = "INSERT into %s (%s,%s,%s,%s,%s,%s,%s,%s) ";
        String queryRes = "VALUES ('%s', '%s','%s','%s','%s',%s,%s,'%s')";
        if(media instanceof AudioBook){
            narrator = "'"+((AudioBook) media).getNarrator()+"'";
            duration = ((AudioBook) media).getDuration();
            mediaType = MediaType.AUDIOBOOK.name();
        }
        if(media instanceof Magazine){
            issue = ((Magazine) media).getIssueNum();
            mediaType = MediaType.MAGAZINE.name();
        }
        query = String.format(query, TABLE_NAME, FIELD_NAME, FIELD_PABLISHER_DATE, FIELD_MEDIA_TYPE, FIELD_MEDIA_STATUS, FIELD_PABLISHER, FIELD_NARRATOR, FIELD_DURATION, FIELD_ISSUE);
        queryRes = String.format(queryRes, name, publication_date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")), mediaType, mediaStatus, publisher,narrator,duration,issue);
        int res = exequteUpdate(query+queryRes);
        if(res != 0) return true;
        return false;
    }

    public boolean removeMedia(AbstractMedia media) {
        String query = "DELETE FROM media WHERE id = %s OR name LIKE '%s'";
        int rs = exequteUpdate(String.format(query, media.getBookId(), "%"+media.getName()+"%"));
        if(rs > 0) return true;
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
        String query = "SELECT * FROM media WHERE name LIKE '%s'";
        ResultSet rs = exequteQuery(String.format(query, "%"+name+"%"));
        if(rs != null){
            ArrayList<AbstractMedia> listMedia  = buildMediaObject(rs);
            if(listMedia != null) return listMedia;
        }
        return null;
    }

    public boolean checkoutMedia(int id) {
        String query = "UPDATE media SET %s = '%s' WHERE id = %s AND %s != '%s'";
        int rs = exequteUpdate(String.format(query, FIELD_MEDIA_STATUS, MediaStatus.LOANED, id, FIELD_MEDIA_STATUS, MediaStatus.LOANED));
        if(rs > 0) return true;
        return false;
    }

    public boolean returnMedia(int id) {
        String query = "UPDATE media SET %s = '%s' WHERE id = %s AND %s = '%s'";
        int rs = exequteUpdate(String.format(query, FIELD_MEDIA_STATUS, MediaStatus.AVAILABLE, id, FIELD_MEDIA_STATUS, MediaStatus.LOANED));
        if(rs > 0) return true;
        return false;
    }

    public ArrayList<AbstractMedia> getByMediaType(MediaType type){
        String query = "SELECT * FROM media WHERE media_type = '%s'";
        ResultSet rs = exequteQuery(String.format(query, type));
        if(rs != null){
            ArrayList<AbstractMedia> listMedia  = buildMediaObject(rs);
            if(listMedia != null) return listMedia;
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
                    String publisher = rs.getString(FIELD_PABLISHER);
                    LocalDate publication_date = null;
                    if(rs.getDate(FIELD_PABLISHER_DATE) != null) {
                        publication_date = LocalDate.parse(rs.getDate(FIELD_PABLISHER_DATE).toString(), DateTimeFormatter.ofPattern("YYYY-MM-dd"));
                    }
                    String narrator = rs.getString(FIELD_NARRATOR);
                    String name  = rs.getString(FIELD_NAME);
                    Integer duration = rs.getInt(FIELD_DURATION);
                    String issue = rs.getString(FIELD_ISSUE);
                    AbstractMedia media = null;
                    if (rs.getString(FIELD_MEDIA_TYPE).equals(MediaType.BOOK.name())){
                        System.out.println(1);
                        media = new Book(
                               name,
                               publisher,
                               publication_date
                        );
                    }
                    if (rs.getString(FIELD_MEDIA_TYPE).equals(MediaType.AUDIOBOOK.name())){
                        System.out.println(2);
                         media = new AudioBook(
                                name,
                                publisher,
                                publication_date,
                                narrator, 
                                duration
                                 
                        );
                    }
                    if(rs.getString(FIELD_MEDIA_TYPE).equals(MediaType.MAGAZINE.name())){
                        System.out.println(3);
                        media = new Magazine(
                                name,
                                publisher,
                                publication_date,
                                issue
                        );
                    }
                    media.setBookId(rs.getInt(FIELD_ID));
                    mediaList.add(media);
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

    private Statement getStmt(){
        conn = databaseConnector.getDbConnection();
        if (conn != null) {
            System.out.println("Creating database statement");
            try {
                return stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private int exequteUpdate(String queryStr){
        System.out.println(queryStr);
        stmt = getStmt();
         if(stmt != null){
          try{
             int rs = stmt.executeUpdate(queryStr);
             return rs;
         } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
    private ResultSet exequteQuery(String queryStr) {
        System.out.println(queryStr);
        stmt = getStmt();
        if(stmt != null) {
            try {
                ResultSet rs = stmt.executeQuery(queryStr);
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

