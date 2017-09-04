package il.co.electriccollege.library.hibernate;

import il.co.electriccollege.library.hibernate.entitities.Library;
import il.co.electriccollege.library.hibernate.entitities.Media;
import il.co.electriccollege.library.hibernate.entitities.MediaStatus;
import il.co.electriccollege.library.hibernate.entitities.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by yaakov on 8/22/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager();
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Media book = new Media();
        book.setMediaType(MediaType.BOOK.name());
        book.setName("Lord of the Rings");
        book.setPublicationDate(new GregorianCalendar(1942, 5, 12).getTime());
        book.setStatus(MediaStatus.AVAILABLE.name());
        Library library = new Library();
        library.setName("Hadera Library");
        library.setAddress("10 HaShalom");
        book.setLibrary(library);
        session.save(book);

        session.close();
        sessionManager.tearDownSession();
    }
}
