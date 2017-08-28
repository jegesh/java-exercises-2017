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
        int duration = 0;
        String issue = "";

        if (media instanceof AudioBook) {
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

    private String formatDate(Date d) {
        DateFormat isoFormat = new SimpleDateFormat("YYYY-MM-dd");
        return isoFormat.format(d);
    }

    public boolean removeMedia(AbstractMedia media) {
        return false;

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

<<<<<<< HEAD
    private ArrayList<AbstractMedia> buildMediaObject(ResultSet rs){
        ArrayList<AbstractMedia> mediaList = new ArrayList<AbstractMedia>();
=======
    private ArrayList<AbstractMedia> buildMediaObject(ResultSet rs) {
        ArrayList<AbstractMedia> mediaList = new ArrayList<>();
>>>>>>> 359795762fce42113a73c8e06a3e2d1498802759
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

    public ArrayList<AbstractMedia> getByMediaType(MediaType type) {
        return null;
    }

    public ArrayList<AbstractMedia> getByName(String name) {
        return null;
    }

    public boolean checkoutMedia(int id) {
        return false;

    }

    public boolean returnMedia(int id) {
        return false;

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
}
