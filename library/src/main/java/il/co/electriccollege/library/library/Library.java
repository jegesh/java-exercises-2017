package il.co.electriccollege.library.library;

import il.co.electriccollege.library.exceptions.LibraryException;
import il.co.electriccollege.library.media.AbstractMedia;
import il.co.electriccollege.library.media.Book;
import il.co.electriccollege.library.media.Magazine;
import il.co.electriccollege.library.media.MediaStatus;

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
    public AbstractMedia checkoutMedia(int mediaId) throws LibraryException {

        AbstractMedia media = bookSet.get(mediaId);
        if(media.getStatus().equals(MediaStatus.AVAILABLE)){
            media.setStatus(MediaStatus.LOANED);
            return media;
        }else{
            throw new LibraryException();
        }
    }

    public void returnMedia(int id) {
        AbstractMedia media = bookSet.get(id);
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
