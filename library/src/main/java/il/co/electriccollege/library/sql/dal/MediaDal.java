package il.co.electriccollege.library.sql.dal;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dao.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by yaakov on 8/23/17.
 */
public class MediaDal {
    public static final String FIELD_ID = "id";
    public static final String FIELD_NARRATOR = "narrator";
    public static final String FIELD_DURATION = "duration";
    public static final String FIELD_ISSUE = "issue";
    private DatabaseConnector databaseConnector;
    private Statement stmt;
    private Connection conn;
    private static final String FIELD_MEDIA_TYPE = "media_type";
    private static final String FIELD_MEDIA_STATUS = "media_status";
    private static final String FIELD_NAME = "name";
    private static final String TABLE_NAME = "media";
    private static final String FIELD_PUBLISHER = "publisher";
    private static final String FIELD_PUBLICATION_DATE = "publication_date";

    public MediaDal(DatabaseConnector connector) {
        databaseConnector = connector;
    }

    private String formatDate(Date d) {
        DateFormat isoFormat = new SimpleDateFormat("YYYY-MM-dd");
        return isoFormat.format(d);
    }

    /**
     * Example query:
     * INSERT INTO library (name, publication_date, media_type, media_status, publisher, narrator, duration, issue)
     * VALUES ('The Dibbuk', DATE '1980-09-09', 'null', 'AVAILABLE', 'Random House', null, '0', '')
     *
     * @param media
     * @return
     */
    public boolean addMediaToLibrary(AbstractMedia media) {
        // fields: name, publication_date, media_type, media_status, publisher, narrator, duration, issue
        String query1 = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s) ";
        query1 = String.format(query1, TABLE_NAME, FIELD_NAME, FIELD_PUBLICATION_DATE,
                FIELD_MEDIA_TYPE, FIELD_MEDIA_STATUS, FIELD_PUBLISHER, FIELD_NARRATOR,
                FIELD_DURATION, FIELD_ISSUE);

        String query2 = "VALUES ('%s', DATE '%s', '%s', '%s', '%s', %s, '%s', '%s')";
        String name = media.getName();
        String publisher = media.getPublisher();
        MediaStatus status = MediaStatus.AVAILABLE;
        Date publicationDate = media.getPublicationDate();
        String narrator = null;
        String mediaType = MediaType.BOOK.name();
        int duration = 0;
        String issue = "";

        if (media instanceof AudioBook) {
            mediaType = MediaType.AUDIOBOOK.name();
            narrator = "'" + ((AudioBook) media).getNarrator() + "'";
            duration = ((AudioBook) media).getDuration();
        }
        if (media instanceof Magazine) {
            issue = ((Magazine) media).getIssueNo();
        }

        query2 = String.format(query2, name, formatDate(publicationDate),
                media.getType(), status, publisher, narrator, duration, issue
        );
        int result = -1;
        try {
            result = executeUpdate(query1 + query2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return result > 0;
    }

    private Statement getStatement() throws SQLException {
        conn = databaseConnector.getDbConnection();
        if (conn != null) {

            System.out.println("Creating database statement");
            // create query statement
            stmt = conn.createStatement();
            return stmt;
        }
        throw new SQLException("Unable to connect to database");
    }

    private int executeUpdate(String queryStr) {
        try {
            stmt = getStatement();
            int result = stmt.executeUpdate(queryStr);
            return result;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return -1;
    }

    private ResultSet executeQuery(String queryStr) {
        try {
            stmt = getStatement();
            ResultSet rs = stmt.executeQuery(queryStr);
            return rs;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return null;
    }

    private ArrayList<AbstractMedia> buildMediaObject(ResultSet rs) {
        ArrayList<AbstractMedia> mediaList = new ArrayList<>();
        boolean hasNextRow = true;
        while (hasNextRow) {
            // read all the rows
            try {
                hasNextRow = rs.next();
                // here we do the actual work
                if (hasNextRow) {
                    String name = rs.getString(FIELD_NAME);
                    String publisher = rs.getString(FIELD_PUBLISHER);
                    Date publicationDate = rs.getDate(FIELD_PUBLICATION_DATE);
                    int duration = rs.getInt(FIELD_DURATION);
                    String mediaType = rs.getString(FIELD_MEDIA_TYPE);

                    int libraryId = rs.getInt("library_id");
                    String libraryName = rs.getString("library_name");
                    String address = rs.getString("address");

                    Library library = new Library();
                    library.setName(libraryName);
                    library.setId(libraryId);
                    library.setAddress(address);

                    AbstractMedia media = null;

                    if (mediaType.equals(MediaType.BOOK.name())) {
                        media = new Book(
                                name,
                                publisher,
                                publicationDate
                        );
                    }
                    if (mediaType.equals(MediaType.AUDIOBOOK.name())) {
                        media = new AudioBook(
                                name,
                                publisher,
                                publicationDate,
                                rs.getString(FIELD_NARRATOR),
                                duration
                        );

                    }
                    if (mediaType.equals(MediaType.MAGAZINE.name())) {
                        media = new Magazine(
                                name,
                                publisher,
                                publicationDate,
                                rs.getString(FIELD_ISSUE)
                        );
                    }
                    media.setType(MediaType.valueOf(mediaType));
                    media.setStatus(MediaStatus.valueOf(rs.getString(FIELD_MEDIA_STATUS)));
                    media.setId(rs.getInt(FIELD_ID));
                    media.setLibrary(library);
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

    public AbstractMedia getById(int id) {
        String query = "SELECT * FROM media WHERE id = %s";
        ResultSet rs = executeQuery(String.format(query, id));
        if (rs != null) {
            ArrayList<AbstractMedia> returnedObjs = buildMediaObject(rs);
            if (returnedObjs != null)
                return returnedObjs.get(0);
        }
        return null;
    }
    //ours
    public boolean removeMedia(AbstractMedia media) {
        //DELETE FROM table_name WHERE some_column = some_value
        String query = "DELETE FROM %s WHERE %s=%s";
        executeUpdate(String.format(query, TABLE_NAME, FIELD_ID, media.getId()));
        return false;

    }

    /**
     * query like this: SELECT media.*, library.* FROM media
                        LEFT JOIN library ON media.library_id = library.id
                        WHERE media.media_type='BOOK';
     * @param type
     * @return
     */
    public ArrayList<AbstractMedia> getByTypeWithLibrary(MediaType type){
        String query = "SELECT media.*, library.id AS lib_id, library.name AS library_name, library.address FROM media " +
                "LEFT JOIN library ON media.library_id = library.id " +
                "WHERE media.media_type='%s'";
        query = String.format(query, type.name());
        ResultSet rs = executeQuery(query);
        if(rs!=null)
        {
            return buildMediaObject(rs);
        }
        return null;

    }

    public ArrayList<AbstractMedia> getByMediaType(MediaType type) {
        //SELECT * FROM table_name WHERE some_column = some_value
        String query="SELECT * FROM %s WHERE %s = '%s'";
        query= String.format(query, TABLE_NAME,FIELD_MEDIA_TYPE,type);
        ResultSet rs =executeQuery(query);
        if(rs!=null)
        {
            return buildMediaObject(rs);
        }
        return null;
    }

    public ArrayList<AbstractMedia> getByName(String name) {
        //SELECT * FROM table_name WHERE some_column = some_value
        String query="SELECT * FROM %s WHERE %s = '%s'";
        query= String.format(query, TABLE_NAME,FIELD_NAME,name);
        ResultSet rs =executeQuery(query);
        if(rs!=null)
        {
            return buildMediaObject(rs);
        }
        return null;
    }

    public boolean checkoutMedia(int id) {
        //UPDATE Customers SET ContactName='Juan' WHERE Country='Mexico';
        String query="UPDATE %s SET %s = '%s' WHERE %s = '%s'";
        query= String.format(query, TABLE_NAME,FIELD_MEDIA_STATUS,MediaStatus.LOANED.name(),FIELD_ID,id);
        if(executeUpdate(query)>0)
            return true;
        return false;

    }

    public boolean returnMedia(int id) {
        //UPDATE Customers SET ContactName='Juan' WHERE Country='Mexico';
        String query="UPDATE %s SET %s = '%s' WHERE %s = '%s'";
        query= String.format(query, TABLE_NAME,FIELD_MEDIA_STATUS,MediaStatus.AVAILABLE.name(),FIELD_ID,id);
        if (executeUpdate(query)>0)
            return true;
        return false;

    }


}
