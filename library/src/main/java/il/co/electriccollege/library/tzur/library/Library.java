package il.co.electriccollege.library.tzur.library;

import il.co.electriccollege.library.tzur.media.AbstractMedia;

import java.util.HashMap;

public class Library {
    HashMap<Integer,AbstractMedia> bookSet = new HashMap<>();

    //constractors

    public Library(HashMap<Integer, AbstractMedia> bookSet) {
        this.bookSet = bookSet;
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
        // TODO: 21/08/2017
    }

}
