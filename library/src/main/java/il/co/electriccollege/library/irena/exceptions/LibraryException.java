package il.co.electriccollege.library.irena.exceptions;


/**
 * Created by yaakov on 8/22/17.
 */
public class LibraryException extends Exception {

    @Override
    public String getMessage() {
        return "This book is currently unavailable";
    }
}
