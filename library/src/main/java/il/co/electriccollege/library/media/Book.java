package il.co.electriccollege.library.media;

import java.util.Date;

public class Book extends AbstractMedia{

    public Book(int id, String name, String publisher, Date publicationDate) {
        super(id, name, publisher, publicationDate);
    }
}
