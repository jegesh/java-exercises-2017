package il.co.electriccollege.library;

import il.co.electriccollege.library.irena.lender.Lender;
import il.co.electriccollege.library.irena.media.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) {

        AudioBook ab = new AudioBook();
        ab.setDuration(20);
        ab.setNarrator("paul");
        ab.setName("Pinokkio");
        ab.setPublisher("Tolstoy");
        System.out.println(ab.getBookId());

        Media bb = new Book("Chippolino", "Radary", new Date(1970,2,12));
        Media ab1 = new AudioBook("Buratino","Tolstoy", new Date(1900, 01, 01), "Fill", 137 );
        Media mm = new Magazine("Vogue", "Vogue", new Date(2017, 02, 02), "27-12-22");

        Library lib = new Library();
        lib.addToLibrary(bb);
        lib.addToLibrary(ab1);
        lib.addToLibrary(mm);
        lib.addToLibrary(ab);


        Lender ron = new Lender("Ron");
        Lender hron = new Lender("Hron");
        ron.checkoutMedia(5,lib);
        hron.checkoutMedia(0,lib);
        ron.checkoutMedia(1,lib);
        ron.checkoutMedia(0,lib);

        System.out.println("Ron have a book :" + ron);
        ron.returnMedia(1, lib);
        System.out.println("Ron havn't a book :" + ron);
        System.out.println("HRon have a book :" + hron);
        System.out.println("-------library----------");
        for(Map.Entry<Integer, Media> media: lib.getLibrary().entrySet()){
            System.out.println(media.getKey() + " - " + media.getValue());
        }

    }
}
