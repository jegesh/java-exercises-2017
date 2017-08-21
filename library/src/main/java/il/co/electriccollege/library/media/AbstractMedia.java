package il.co.electriccollege.library.media;

import java.util.Date;

public abstract class AbstractMedia {
    private Date checkOutDate;
    private String name;
    private int id;
    private MediaSrtatus status;
    private String publisher;
    private Date publicationDate;

    //abstract methods
    public abstract int getFine();

    public abstract int getMaxLoan();


    //constractors
    public AbstractMedia(Date checkOutDate, String name,  MediaSrtatus status, String publisher, Date publicationDate) {
        this.checkOutDate = checkOutDate;
        this.name = name;
        this.id = id;
        id++;
        this.status = status;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public AbstractMedia() {
    }

    //get&set
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public MediaSrtatus getStatus() {
        return status;
    }

    public void setStatus(MediaSrtatus status) {
        this.status = status;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
