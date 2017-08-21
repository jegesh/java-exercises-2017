package il.co.electriccollege.library.media;

import java.util.Date;

public class audiobook extends AbstractMedia{

    private String narrator;
    private int duration;

    public audiobook(int id, String name, String publisher, Date publicationDate, String narrator, int duration) {
        super(id, name, publisher, publicationDate);
        this.narrator = narrator;
        this.duration = duration;
    }
}
