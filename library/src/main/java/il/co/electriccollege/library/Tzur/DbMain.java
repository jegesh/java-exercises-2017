package il.co.electriccollege.library.Tzur;

import il.co.electriccollege.library.Tzur.sql.DatabaseConnector;
import il.co.electriccollege.library.Tzur.sql.dal.MediaDal;

/**
 * Created by yaakov on 8/23/17.
 */
public class DbMain {

    public static void main(String[] args) {
        // retrieval
        MediaDal mediaDal = new MediaDal(new DatabaseConnector());
//        AbstractMedia returnedMedia = mediaDal.getById(2);
//        System.out.println(returnedMedia);

//        // Add to library
//        Book b = new Book("The Dibbuk", "Random House", Main.getDateWithCalendar("09/09/1980"));
//        b.setType(MediaType.BOOK);
//        boolean added = mediaDal.addMediaToLibrary(b);
//        System.out.println("Was book added to library? " + added);
//
//        AudioBook a = new AudioBook("TzurTest", "Random House", Main.getDateWithCalendar("09/09/1980"),"tzur",200);
//        a.setType(MediaType.AUDIOBOOK);   
//        mediaDal.addMediaToLibrary(a);
//
//        Magazine m = new Magazine("TzurTest", "Random House", Main.getDateWithCalendar("09/09/1980"),"magazineIssue");
//        m.setType(MediaType.MAGAZINE);
//        mediaDal.addMediaToLibrary(m);
//
//        AbstractMedia abDel=new Book();
//        abDel.setId(1);
//        mediaDal.removeMedia(abDel);

//        ArrayList <AbstractMedia> al=mediaDal.getByMediaType(MediaType.MAGAZINE);
//        for (AbstractMedia d : al){
//            System.out.println(d);
//        ArrayList<AbstractMedia> al = mediaDal.getByName("TzurTest");
//        for (AbstractMedia d : al) {
//            System.out.println(d);
//        }
        System.out.println(mediaDal.checkoutMedia(1));
//        mediaDal.returnMedia(2);
    }
}
