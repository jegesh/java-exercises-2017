package il.co.electriccollege.library.irena.media;

import java.util.Date;

/**
 * Created by IrKha on 21.08.2017.
 */
public abstract class AbstractMedia {
    String name;
    String publisher;
    Date publicationDate;
    private static int id = 0;
    private int bookId;
    Date checkedOutDate;
    MediaStatus status;

    public AbstractMedia(){
        this.id++;
    }
    public AbstractMedia(String name, String publisher, Date publicationDate){
        this.bookId = id;
        this.id++;
        this.name = name;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public abstract int getFine();
    public abstract int getMaxLoan();

    public int getBookId(){return bookId;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Date getCheckedOutDate() {
        return checkedOutDate;
    }

    public MediaStatus getStatus() {
        return status;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setCheckedOutDate(Date checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public void setStatus(MediaStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                ", bookId=" + bookId +
                ", checkedOutDate=" + checkedOutDate +
                ", status=" + status +
                '}';
    }
}
