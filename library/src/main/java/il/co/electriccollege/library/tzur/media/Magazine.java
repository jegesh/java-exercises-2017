package il.co.electriccollege.library.tzur.media;

import java.util.Date;

public class Magazine extends AbstractMedia {
    private String issueNo;

    //constractors
    public Magazine(String name, String publisher, Date publicationDate, String issueNo) {
        super(name, publisher, publicationDate);
        this.issueNo = issueNo;
    }


    //implement methods
    public int getFine() {
        // TODO: 21/08/2017
        return 0;
    }

    public int getMaxLoan() {
        // TODO: 21/08/2017
        return 14;
    }
}
