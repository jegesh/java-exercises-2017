package il.co.electriccollege.library.sql.dao;

import java.util.Date;

public abstract class AbstractMedia {
    private MediaType type;
    private Date checkOutDate;
    private String name;
    private static int id;
    private int mediaId;
    private MediaStatus status;
    private String publisher;
    private Date publicationDate;

    //abstract methods
    public abstract int getFine();

    /**
     *
     * @return number of days allowed to be lent out
     */
    public abstract int getMaxLoan();


    //constructors
    public AbstractMedia(String name, String publisher, Date publicationDate) {
        this.name = name;
        this.mediaId = id;
        id++;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
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
        return mediaId;
    }


    public void setId ( int id)
    {
        this.mediaId=id;
    }
    public MediaStatus getStatus() {
        return status;
    }

    public void setStatus(MediaStatus status) {
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

    @Override
    public String toString() {
        String print = "Name: %s, id: %s, status: %s";
        return String.format(print, name, mediaId, status);
    }
}
