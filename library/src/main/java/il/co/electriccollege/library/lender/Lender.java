package il.co.electriccollege.library.lender;

import il.co.electriccollege.library.library.Library;
import il.co.electriccollege.library.media.AbstractMedia;

public class Lender {

    public String name;
    public AbstractMedia currentMedia;

    public Lender(String name, AbstractMedia currentMedia) {
        this.name = name;
        this.currentMedia = currentMedia;
    }

    public AbstractMedia checkOutMedia(int a , Library library) {



        return currentMedia;
    }

    public void returnMedia(int a , Library library) {


    }

}
