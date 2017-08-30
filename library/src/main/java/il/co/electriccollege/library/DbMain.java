package il.co.electriccollege.library;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dal.MediaDal;
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
public class DbMain {

    public static void main(String[] args) {
        // retrieval
        MediaDal mediaDal = new MediaDal(new DatabaseConnector());
//        AbstractMedia returnedMedia = mediaDal.getById(2);
//        System.out.println(returnedMedia);

        // Add to library
        Book b = new Book("The Dibbuk", "Random Cottedge", Main.getDateWithCalendar("09/09/1980"));
        b.setType(MediaType.BOOK);
        boolean added = mediaDal.addMediaToLibrary(b);
        System.out.println("Was book added to library? " + added);
//        boolean removed =mediaDal.removeMedia(b);
//        System.out.println("Was book removed from library? " + removed);

        ArrayList<AbstractMedia> arr = new ArrayList<AbstractMedia>();
        arr = mediaDal.getByMediaType(MediaType.BOOK);

        for (AbstractMedia curr: arr ) {
            System.out.println(curr.toString());
        }
        }


}
