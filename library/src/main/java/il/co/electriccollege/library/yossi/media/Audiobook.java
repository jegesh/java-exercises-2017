package il.co.electriccollege.library.yossi.media;

import java.util.Date;

public class Audiobook extends AbstractMedia{

    private String narrator;
    private int duration;

    public Audiobook(int id, String name, String publisher, Date publicationDate, String narrator, int duration) {
        super(id, name, publisher, publicationDate);
        this.narrator = narrator;
        this.duration = duration;
    }

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
