package il.co.electriccollege.library.irena.media;

import java.util.Date;

/**
 * Created by IrKha on 21.08.2017.
 */
public class Magazine extends Media {
    private String issueNum;
    public Magazine(){
        super();
    }
    public Magazine(String name, String publisher, Date publicationDate, String issueNum){
        super(name, publisher, publicationDate);
        this.issueNum = issueNum;
    }

    public String getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(String issueNum) {
        this.issueNum = issueNum;
    }

    @Override
    public int getFine() {
        return 0;
    }

    @Override
    public int getMaxLoan() {
        return 0;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString()+
                "issueNum='" + issueNum + '\'' +
                '}';
    }
}
