package il.co.electriccollege.library.media;

import java.util.Date;

public class Book extends AbstractMedia {

    //constructors
    public Book(String name, String publisher, Date publicationDate) {
        super(name, publisher, publicationDate);
    }

    public Book(Book originalBook){
        super(originalBook.getName(), originalBook.getPublisher(), originalBook.getPublicationDate());
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

    @Override
    public Book clone() throws CloneNotSupportedException {
        return new Book(getName(), getPublisher(), getPublicationDate());
    }
}
