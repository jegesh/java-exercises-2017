package il.co.electriccollege.library.media;

import java.util.Date;

import static il.co.electriccollege.library.media.MediaStatus.AVAILABLE;

public class AbstractMedia {

    private int id;
    private String name;
    private MediaStatus status;
    private String publisher;
    private Date checkOutDate;
    private Date publicationDate;
    private static int idCounter = 0;


    public AbstractMedia(int id, String name, MediaStatus status, String publisher, Date publicationDate) {
        this.name = name;
        this.id = id;
        this.status = AVAILABLE;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        idCounter++;
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

    public void setId(int id) {
        this.id = id;
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

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "AbstractMedia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", publisher='" + publisher + '\'' +
                ", checkOutDate=" + checkOutDate +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
