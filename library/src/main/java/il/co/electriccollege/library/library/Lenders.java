package il.co.electriccollege.library.library;

import il.co.electriccollege.library.media.AbstractMedia;

public class Lenders {
    private String name;
    private AbstractMedia media;

    //constractors

    public Lenders(String name, AbstractMedia media) {
        this.name = name;
        this.media = media;
    }

    //get&set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractMedia getMedia() {
        return media;
    }

    public void setMedia(AbstractMedia media) {
        this.media = media;
    }

    //methods
    public void checkoutMedia(int mediaId, Library library) {

    }

    public void returnMedia(int mediaId, Library library) {

    }


}
