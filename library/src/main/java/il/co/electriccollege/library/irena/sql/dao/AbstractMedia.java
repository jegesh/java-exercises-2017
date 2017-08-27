package il.co.electriccollege.library.irena.sql.dao;

import il.co.electriccollege.library.irena.media.MediaStatus;

import java.util.Date;

/**
 * Created by IrKha on 21.08.2017.
 */
public abstract class AbstractMedia {
    String name;
    String publisher;
    Date publicationDate;
   // private static int id = 0;
    private int bookId;
    Date checkedOutDate;

    il.co.electriccollege.library.irena.media.MediaStatus status;

    public AbstractMedia(){
        //this.id++;
    }
    public AbstractMedia(String name, String publisher, Date publicationDate){
      //  this.bookId = id;
       // this.id++;
        this.name = name;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
    public AbstractMedia(int bookId, String name, String publisher, Date publicationDate){
          this.bookId = bookId;
        // this.id++;
        this.name = name;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public void setBookId(int id){
        this.bookId = id;
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

    public il.co.electriccollege.library.irena.media.MediaStatus getStatus() {
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
