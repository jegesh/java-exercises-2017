package il.co.electriccollege.library.yossi;


import il.co.electriccollege.library.Main;
import il.co.electriccollege.library.yossi.sql.dao.*;
import il.co.electriccollege.library.yossi.sql.DatabaseConnector;
import il.co.electriccollege.library.yossi.sql.dal.MediaDal;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/23/17.
 */
public class DbMain {

    public static void main(String[] args) {
        // retrieval
        MediaDal mediaDal = new MediaDal(new DatabaseConnector());
        AbstractMedia returnedMedia = mediaDal.getById(2);
       System.out.println(returnedMedia);

        // Add to library
       /* Book b = new Book("The Dibbuk111", "Random House", Main.getDateWithCalendar("09/09/1998"));
        b.setType(MediaType.BOOK);
        AudioBook a = new AudioBook("The Dibbuk212", "Random House", Main.getDateWithCalendar("02/10/2000"), "NARR", 10);
        a.setType(MediaType.AUDIOBOOK);
        Magazine m = new Magazine("The Dibbuk3", "Random House", Main.getDateWithCalendar("19/08/2008"),"10/2000");
        m.setType(MediaType.MAGAZINE);
        boolean added = mediaDal.addMediaToLibrary(a);
        mediaDal.addMediaToLibrary(m);
        mediaDal.addMediaToLibrary(b);
        System.out.println("Was book added to library? " + added);

        //mediaDal.removeMedia(b(12));
        System.out.println("Was book removed from library? "); */

        ArrayList<AbstractMedia> typeList = new ArrayList<>();
        System.out.println("\n");
        System.out.println("BY MEDIA");
        System.out.println("===================");
        typeList= mediaDal.getByMediaType(MediaType.MAGAZINE);
        for (AbstractMedia curr: typeList)
              {
                  System.out.println("Current Element: " + curr.toString());
        }


        ArrayList<AbstractMedia> nameList = new ArrayList<>();
        System.out.println("\n");
        System.out.println("BY NAME");
        System.out.println("===================");
        nameList= mediaDal.getByName("The Dibbuk212");
        for (AbstractMedia curr: nameList)
        {
            System.out.println("Current Element: " + curr.toString());
        }
    }



}
