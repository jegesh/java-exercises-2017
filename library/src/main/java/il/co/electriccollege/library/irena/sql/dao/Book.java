package il.co.electriccollege.library.irena.sql.dao;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by IrKha on 21.08.2017.
 */
public class Book extends AbstractMedia {

    public Book(){
        super();
    }
    public Book(String name, String publisher, LocalDate publicationDate){
        super(name, publisher, publicationDate);
    }
    @Override
    public int getFine() {
        return 0;
    }

    @Override
    public int getMaxLoan() {
        return 0;
    }

    @Override
    public String toString() {
        return "Book{"+
                super.toString()+
                "}";
    }
}
