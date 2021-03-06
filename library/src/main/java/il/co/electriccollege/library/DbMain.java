package il.co.electriccollege.library;

import il.co.electriccollege.library.sql.DatabaseConnector;
import il.co.electriccollege.library.sql.dal.MediaDal;
import il.co.electriccollege.library.sql.dao.AbstractMedia;
import il.co.electriccollege.library.sql.dao.Book;
import il.co.electriccollege.library.sql.dao.MediaType;

import java.io.IOException;
import java.util.List;

/**
 * Created by yaakov on 8/23/17.
 */
public class DbMain {

    public static void main(String[] args) throws IOException {
        String configFile = args[0];

        // retrieval
        MediaDal mediaDal = new MediaDal(new DatabaseConnector());
//        AbstractMedia returnedMedia = mediaDal.getById(2);
//        System.out.println(returnedMedia);

        // Add to library
//        Book b = new Book("The Dibbuk", "Random House", Main.getDateWithCalendar("09/09/1980"));
//        b.setType(MediaType.BOOK);
//        boolean added = mediaDal.addMediaToLibrary(b);
//        System.out.println("Was book added to library? " + added);

        List<AbstractMedia> media = mediaDal.getByTypeWithLibrary(MediaType.BOOK);
        System.out.println(media);
        System.out.println(media.get(0).getLibrary());
    }
}
