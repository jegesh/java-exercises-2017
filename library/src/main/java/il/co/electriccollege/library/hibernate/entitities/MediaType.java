package il.co.electriccollege.library.hibernate.entitities;

/**
 * Created by yaakov on 8/22/17.
 */
public enum MediaType {
    BOOK(1),
    AUDIOBOOK(2),
    MAGAZINE(3);

    private int numVal;

    MediaType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}
