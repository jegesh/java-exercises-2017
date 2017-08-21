package il.co.electriccollege.library.irena.lender;

import il.co.electriccollege.library.irena.media.*;

/**
 * Created by IrKha on 21.08.2017.
 */
public class Lender {
    private String name;
    private Media currentMedia;

    public Lender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Media getCurrentMedia() {
        return currentMedia;
    }

    public void setCurrentMedia(Media currentMedia) {
        this.currentMedia = currentMedia;
    }

    public void checkoutMedia(int id, Library lib) {
        if(getCurrentMedia() == null) {
            Media toCheck = lib.checkoutMedia(id);
            if (toCheck != null) {
                setCurrentMedia(toCheck);
            }
        }
    }
    public void returnMedia(int id, Library library){
        if(getCurrentMedia() != null){
            if(library.returnMedia(id)) {
              setCurrentMedia(null);
            }
        }
    }

    @Override
    public String toString() {
        return "Lender{" +
                "name='" + name + '\'' +
                ", currentMedia=" + currentMedia +
                '}';
    }
}
