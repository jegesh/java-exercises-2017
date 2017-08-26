package il.co.electriccollege.library;

import il.co.electriccollege.library.irena.exceptions.LibraryException;
import il.co.electriccollege.library.irena.lender.Lender;
import il.co.electriccollege.library.irena.media.*;

import java.util.Date;
import java.util.Map;

//import il.co.electriccollege.library.library.Library;
/*import il.co.electriccollege.library.media.AbstractMedia;
import il.co.electriccollege.library.media.AudioBook;
import il.co.electriccollege.library.media.Book;
import il.co.electriccollege.library.media.Magazine;
*/
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



/**
 * Created by yaakov on 8/20/17.
 */
public class Main {
    static Library library;
    public static void main(String[] args) throws LibraryException {

        Book book1 = null;
        try {
            book1 = new Book("book1", "publisher1", getDateWithSimpleFormat("21880/2017"));
        } catch (ParseException e) {
            e.printStackTrace();
//           throw new LibraryException();
        }
        AudioBook audioBook = new AudioBook("Lord of the Rings", "Knopf", getDateWithCalendar("01/01/1933"), "Sean Connery", 999);
        Magazine magazine = new Magazine("Rolling Stone", "publisher", getDateWithCalendar("01/08/2017"), "555");
        Book book2 = new Book(book1.getName(), book1.getPublisher(), book1.getPublicationDate());
        AbstractMedia video = new AbstractMedia() {
            @Override
            public int getFine() {
                return 0;
            }

            @Override
            public int getMaxLoan() {
                return 7;
            }

        };
        video.setName("The Princess Bride");
        library = new Library(new HashMap<Integer, AbstractMedia>());
        library.addToLibrary(book1);
        library.addToLibrary(audioBook);
        library.addToLibrary(magazine);
        library.addToLibrary(video);
        library.addToLibrary(book2);
        for (Map.Entry<Integer, AbstractMedia> entry : library.getBookSet().entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("========");
        Lender yossi = new Lender("yossi");

        // example of catching multiple exceptions
        try {
            Date yesterday = getDateWithSimpleFormat("22/08/2017");
            yossi.checkoutMedia(1, library);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, AbstractMedia> entry : library.getBookSet().entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("========");
        yossi.checkoutMedia(2, library);
        try {
            yossi.returnMedia(2,library);
            yossi.checkoutMedia(11, library);
        } catch (Exception ex) {
            ex.printStackTrace();

            // pre Java 7
            if (ex instanceof LibraryException) {

            }
            if (ex instanceof ParseException) {

            }
            // offer user a book
        }
        System.out.println("========");

        Library library1 = new Library();
        AbstractMedia[] medias = new AbstractMedia[0];
        try {
            medias = new AbstractMedia[]{
                    new Book("book1", "publisher1", getDateWithSimpleFormat("21/08/2017")),
                    new AudioBook("Lord of the Rings", "Knopf", getDateWithCalendar("01/01/1933"), "Sean Connery", 999),
                    new Magazine("Rolling Stone", "publisher", getDateWithCalendar("01/08/2017"), "555"),
                    new Book(book1.getName(), book1.getPublisher(), book1.getPublicationDate()),
                    new Book(book1),
                    new AbstractMedia() {
                        @Override
                        public int getFine() {
                            return 0;
                        }

                        @Override
                        public int getMaxLoan() {
                            return 7;
                        }

                    }
            };
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (AbstractMedia media : medias) {
            library1.addToLibrary(media);
        }
        for (Map.Entry<Integer, AbstractMedia> entry : library1.getBookSet().entrySet()) {
            System.out.println(entry.getValue());
        }


    }

    /**
     * @param dateStr date in the format of dd/MM/yyyy
     * @return
     */
    public static Date getDateWithCalendar(String dateStr) {
        String[] strs = dateStr.split("/");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.valueOf(strs[2]));
        calendar.set(Calendar.MONTH, Integer.valueOf(strs[1]) - 1);
        calendar.set(Calendar.DATE, Integer.valueOf(strs[0]));
        return calendar.getTime();
    }

    public static Date getDateWithSimpleFormat(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(dateStr.length() != 10)
            throw new IllegalArgumentException("Date string must be exactly 10 characters");
        return dateFormat.parse(dateStr);
    }
}
