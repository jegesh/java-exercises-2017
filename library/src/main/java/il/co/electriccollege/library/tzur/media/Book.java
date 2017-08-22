package il.co.electriccollege.library.tzur.media;

import java.util.Date;

public class Book extends AbstractMedia {

    //constractors
    public Book(String name, String publisher, Date publicationDate) {
        super(name, publisher, publicationDate);
    }

    //implement methods
    public int getFine() {
        // TODO: 21/08/2017
        return 0;
    }

    public int getMaxLoan() {
        // TODO: 21/08/2017
        return 21;
    }
}
