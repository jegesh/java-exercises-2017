package il.co.electriccollege.library.hibernate.entitities;

/**
 * Created by yaakov on 8/22/17.
 */
public enum MediaStatus {
    LOANED(1),
    AVAILABLE(2);

    private int numVal;
    MediaStatus(int numVal){
        this.numVal = numVal;
    }

    public int getNumVal(){
        return numVal;
    }
}
