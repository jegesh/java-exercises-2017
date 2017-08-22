package il.co.electriccollege.library.tzur.library;

import il.co.electriccollege.library.tzur.media.AbstractMedia;
import il.co.electriccollege.library.tzur.media.Book;
import il.co.electriccollege.library.tzur.media.Magazine;
import il.co.electriccollege.library.tzur.media.MediaStatus;

import java.util.HashMap;

public class Library {
    private HashMap<Integer,AbstractMedia> bookSet = new HashMap<>();

    //constructors

    public Library(HashMap<Integer, AbstractMedia> bookSet) {
        this.bookSet = bookSet;
    }

    public Library(){
        bookSet = new HashMap<>();
    }


    //get&set


    //methods
    public void checkoutMedia(int id) {
        // TODO: 21/08/2017
    }

    public void returnMedia(int id) {
        // TODO: 21/08/2017
    }

    public void addToLibrary(AbstractMedia media) {
        if(media instanceof Book || media instanceof Magazine){
            bookSet.put(media.getId(), media);
            media.setStatus(MediaStatus.AVAILABLE);
            return;
        }
        System.out.println("Warning: unknown media type");
    }

    public HashMap<Integer,AbstractMedia> getBookSet(){
        return bookSet;
    }

}
