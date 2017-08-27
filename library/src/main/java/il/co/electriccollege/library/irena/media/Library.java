package il.co.electriccollege.library.irena.media;

import java.util.Date;
import java.util.HashMap;
/**
 * Created by IrKha on 21.08.2017.
 */
public class Library {

    private static HashMap<Integer, AbstractMedia> library = new HashMap<Integer, AbstractMedia>();

    public HashMap<Integer, AbstractMedia> getLibrary() {
        return library;
    }

    public void addToLibrary(AbstractMedia abstractMedia){
        abstractMedia.setStatus(MediaStatus.AVAILABLE);
        library.put(abstractMedia.getBookId(), abstractMedia);
    }

    public boolean returnMedia(int id){
        AbstractMedia m = library.get(id);
        if(m != null){
           m.setStatus(MediaStatus.AVAILABLE);
           m.setCheckedOutDate(null);
           return true;
        }
        return false;
    }
    public AbstractMedia checkoutMedia(int id){
        AbstractMedia res = library.get(id);
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
