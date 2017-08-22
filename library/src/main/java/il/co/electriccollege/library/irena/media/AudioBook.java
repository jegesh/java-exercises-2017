package il.co.electriccollege.library.irena.media;

import java.util.Date;

/**
 * Created by IrKha on 21.08.2017.
 */
public class AudioBook extends Book {
    private String narrator;
    private int duration;

    public AudioBook(){
        super();
    }
    public AudioBook(String name, String publisher, Date publicationDate, String narrator, int duration){
        super(name, publisher, publicationDate);
        this.duration = duration;
        this.narrator = narrator;
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

    @Override
    public String toString() {
        return "AudioBook{" +
                super.toString()+
                "narrator='" + narrator + '\'' +
                ", duration=" + duration +
                '}';
    }
}
