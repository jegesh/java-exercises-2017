package il.co.electriccollege.library.irena.lender;

import il.co.electriccollege.library.irena.media.*;

/**
 * Created by IrKha on 21.08.2017.
 */
public class Lender {
    private String name;
    private AbstractMedia currentAbstractMedia;

    public Lender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractMedia getCurrentAbstractMedia() {
        return currentAbstractMedia;
    }

    public void setCurrentAbstractMedia(AbstractMedia currentAbstractMedia) {
        this.currentAbstractMedia = currentAbstractMedia;
    }

    public void checkoutMedia(int id, Library lib) {
        if(getCurrentAbstractMedia() == null) {
            AbstractMedia toCheck = lib.checkoutMedia(id);
            if (toCheck != null) {
                setCurrentAbstractMedia(toCheck);
            }
        }
    }
    public void returnMedia(int id, Library library){
        if(getCurrentAbstractMedia() != null){
            if(library.returnMedia(id)) {
              setCurrentAbstractMedia(null);
            }
        }
    }

    @Override
    public String toString() {
        return "Lender{" +
                "name='" + name + '\'' +
                ", currentAbstractMedia=" + currentAbstractMedia +
                '}';
    }
}
