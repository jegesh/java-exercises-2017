package media;

import java.util.Date;

public class AudioBook extends Book {
    String narrator;
    int duration;

    public AudioBook(String narrator, int duration) {
        this.narrator = narrator;
        this.duration = duration;
    }


    public AudioBook(Date checkOutDate, String name, int id, MediaSrtatus status, String publisher, Date publicationDate, String issueNo, String narrator, int duration) {
        super(checkOutDate, name, id, status, publisher, publicationDate, issueNo);
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
