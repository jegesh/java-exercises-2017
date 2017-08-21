package media;

import java.util.Date;

public class Magazine extends AbstractMedia {
    private String issueNo;

    //constractors
    public Magazine(Date checkOutDate, String name, int id, MediaSrtatus status, String publisher, Date publicationDate, String issueNo) {
        super(checkOutDate, name, id, status, publisher, publicationDate);
        this.issueNo = issueNo;
    }

    public Magazine(){

    }

    //implement methods
    public int getFine() {
        return 0;
    }

    public int getMaxLoan() {
        return 0;
    }
}
