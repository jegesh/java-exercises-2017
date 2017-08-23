package il.co.electriccollege.library.yossi.sql.dao;

import java.util.Date;

public class AudioBook extends Book {
    String narrator;
    int duration;

    //constractors

    public AudioBook(String name, String publisher, Date publicationDate, String narrator, int duration) {
        super(name, publisher, publicationDate);
        this.narrator = narrator;
        this.duration = duration;
    }

    //get&set

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
