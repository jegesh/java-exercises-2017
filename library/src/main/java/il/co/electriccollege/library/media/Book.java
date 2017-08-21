package il.co.electriccollege.library.media;

import java.util.Date;

public class Book extends AbstractMedia {

    //constractors
    public Book(Date checkOutDate, String name,  MediaSrtatus status, String publisher, Date publicationDate, String issueNo) {
        super(checkOutDate, name, status, publisher, publicationDate);
    }


    //implement methods
    public int getFine() {
        // TODO: 21/08/2017
        return 0;
    }

    public int getMaxLoan() {
        // TODO: 21/08/2017
        return 0;
    }
}
