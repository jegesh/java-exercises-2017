package media;

import java.util.Date;

public class Book extends AbstractMedia {

    //constractors
    public Book(Date checkOutDate, String name, int id, MediaSrtatus status, String publisher, Date publicationDate, String issueNo) {
        super(checkOutDate, name, id, status, publisher, publicationDate);
    }

    public Book(){

    }

    //implement methods
    public int getFine() {
        return 0;
    }

    public int getMaxLoan() {
        return 0;
    }
}
