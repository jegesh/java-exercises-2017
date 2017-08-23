package il.co.electriccollege.library.library;

import il.co.electriccollege.library.media.AbstractMedia;

public class Lender {
    private String name;
    private AbstractMedia currentMedia;

    //constructors
   //// rgrttrytr
    public Lender(String name) {
        this.name = name;
    }

    //get&set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractMedia getCurrentMedia() {
        return currentMedia;
    }

    public void setCurrentMedia(AbstractMedia currentMedia) {
        this.currentMedia = currentMedia;
    }

    //methods
    public void checkoutMedia(int mediaId, Library library) {
        if(currentMedia == null)
            currentMedia = library.checkoutMedia(mediaId);
        else System.out.println("Warning: you already have something checked out");
    }

    public void returnMedia(Library library) {
        library.returnMedia(currentMedia.getId());
        currentMedia = null;
    }


}
