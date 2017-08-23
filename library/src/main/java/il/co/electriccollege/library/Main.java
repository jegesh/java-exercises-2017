package il.co.electriccollege.library;


import il.co.electriccollege.library.library.Lender;
import il.co.electriccollege.library.library.Library;
import il.co.electriccollege.library.media.AbstractMedia;
import il.co.electriccollege.library.media.AudioBook;
import il.co.electriccollege.library.media.Book;
import il.co.electriccollege.library.media.Magazine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) throws ParseException, CloneNotSupportedException {

        Book book1 = new Book("book1", "publisher1",getDateWithSimpleFormat("21/08/2017"));
        AudioBook audioBook = new AudioBook("Lord of the Rings", "Knopf", getDateWithCalendar("01/01/1933") ,"Sean Connery", 999);
        Magazine magazine = new Magazine("Rolling Stone", "publisher", getDateWithCalendar("01/08/2017"), "555");
        Book book2 = new Book(book1.getName(), book1.getPublisher(), book1.getPublicationDate());
        Book book3 = new Book(book1);
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
        Library library = new Library(new HashMap<Integer, AbstractMedia>());
        library.addToLibrary(book1);
        library.addToLibrary(audioBook);
        library.addToLibrary(magazine);
        library.addToLibrary(video);
        library.addToLibrary(book2);
        library.addToLibrary(book3);
        for(Map.Entry<Integer, AbstractMedia> entry: library.getBookSet().entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("========");
        Lender yossi = new Lender("yossi");
        yossi.checkoutMedia(1, library);
        for(Map.Entry<Integer, AbstractMedia> entry: library.getBookSet().entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("========");
        yossi.checkoutMedia(2, library);
        yossi.returnMedia(library);
        yossi.checkoutMedia(11, library);
        System.out.println("========");

        Library library1 = new Library();
        AbstractMedia[] medias = new AbstractMedia[]{
            new Book("book1", "publisher1",getDateWithSimpleFormat("21/08/2017")),
            new AudioBook("Lord of the Rings", "Knopf", getDateWithCalendar("01/01/1933") ,"Sean Connery", 999),
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
        for(AbstractMedia media: medias){
            library1.addToLibrary(media);
        }
        for(Map.Entry<Integer, AbstractMedia> entry: library1.getBookSet().entrySet()){
            System.out.println(entry.getValue());
        }
    }

    /**
     *
     * @param dateStr date in the format of dd/MM/yyyy
     * @return
     */
    public static Date getDateWithCalendar(String dateStr){
        String[] strs = dateStr.split("/");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, Integer.valueOf(strs[2]));
        calendar.set(Calendar.MONTH, Integer.valueOf(strs[1]) - 1);
        calendar.set(Calendar.DATE, Integer.valueOf(strs[0]));
        return calendar.getTime();
    }

    public static Date getDateWithSimpleFormat(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse("21/08/2017");
    }
}
