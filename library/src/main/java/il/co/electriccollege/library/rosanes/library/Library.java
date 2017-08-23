package il.co.electriccollege.library.rosanes.library;

import il.co.electriccollege.library.rosanes.media.AbstractMedia;
import il.co.electriccollege.library.rosanes.media.Book;
import il.co.electriccollege.library.rosanes.media.Magazine;
import il.co.electriccollege.library.rosanes.media.MediaStatus;

import java.util.HashMap;

public class Library {
    private HashMap<Integer,AbstractMedia> bookSet = new HashMap<Integer, AbstractMedia>();

    //constructors

    public Library(HashMap<Integer, AbstractMedia> bookSet) {
        this.bookSet = bookSet;
    }

    public Library(){
        bookSet = new HashMap<Integer, AbstractMedia>();
    }


    //get&set


    //methods
    public AbstractMedia checkoutMedia(int mediaId) {

        AbstractMedia media = bookSet.get(mediaId);
        if(media != null && media.getStatus().equals(MediaStatus.AVAILABLE)){
            media.setStatus(MediaStatus.LOANED);
            return media;
        }
        System.out.println("Warning: unknown media id");
        return null;
    }

    public void returnMedia(int id) {
        AbstractMedia media = bookSet.get(id);
        if(media != null)
            media.setStatus(MediaStatus.AVAILABLE);
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
