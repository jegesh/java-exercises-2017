package il.co.electriccollege.library.media;

import java.util.Date;

public class Magazine extends AbstractMedia {
    private String issueNo;

    //constractors
    public Magazine(Date checkOutDate, String name, int id, MediaSrtatus status, String publisher, Date publicationDate, String issueNo) {
        super(checkOutDate, name, id, status, publisher, publicationDate);
        this.issueNo = issueNo;
    }


    //implement methods
    public int getFine() {
        // TODO: 21/08/2017
        return 0;
    }

    public int getMaxLoan() {
        // TODO: 21/08/2017
        return 0;
    }
}
