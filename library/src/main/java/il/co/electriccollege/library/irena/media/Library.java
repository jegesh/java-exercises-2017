package il.co.electriccollege.library.irena.media;

import java.util.Date;
import java.util.HashMap;
/**
 * Created by IrKha on 21.08.2017.
 */
public class Library {

    private static HashMap<Integer, Media> library = new HashMap<>();

    public HashMap<Integer, Media> getLibrary() {
        return library;
    }

    public void addToLibrary(Media media){
        media.setStatus(MediaStatus.AVAILABLE);
        library.put(media.getBookId(), media);
    }

    public boolean returnMedia(int id){
        Media m = library.get(id);
        if(m != null){
           m.setStatus(MediaStatus.AVAILABLE);
           m.setCheckedOutDate(null);
           return true;
        }
        return false;
    }
    public Media checkoutMedia(int id){
        Media res = library.get(id);
        if(res != null && res.getStatus() != MediaStatus.LOANED){
            if(res.getStatus() != MediaStatus.LOANED){
                res.setStatus(MediaStatus.LOANED);
                res.setCheckedOutDate(new Date());
                return res;
            }
        }
        return null;
    }
}
