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
public class HibernateMain {

    public static void main(String[] args) throws Exception {
        DbSessionManager sessionManager = new DbSessionManager(args[0]);
        SessionFactory sessionFactory = DbSessionManager.getSessionFactoryInstance();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Media book = new Media();
        book.setMediaType(MediaType.BOOK.name());
        book.setName("Lord of the Rings");
        book.setPublicationDate(new GregorianCalendar(1942, 5, 12).getTime());
        book.setStatus(MediaStatus.AVAILABLE.name());
        Library library = session.get(Library.class, 3);
        book.setLibrary(library);
        session.save(book);

        session.close();
        sessionManager.tearDownSession();
    }
}
