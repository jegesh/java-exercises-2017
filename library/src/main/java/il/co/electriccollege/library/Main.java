package il.co.electriccollege.library;

import il.co.electriccollege.library.lender.Lender;
import il.co.electriccollege.library.media.AbstractMedia;
import il.co.electriccollege.library.media.audiobook;
import il.co.electriccollege.library.media.book;
import il.co.electriccollege.library.media.magazine;
import java.util.Date;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<AbstractMedia> list = new ArrayList<>();
        magazine mmm = new magazine (9001,"mmm1","pub1",11.1.1911, "8/106");
        list.add(mmm);
        audiobook aaa = new audiobook(8001, "aaa1", "pub2", 22.2.1922, "nnn1", 4);
        list.add(aaa);
        book bbb = new book(1001, "aaa1", "pub2", 22.2.1922);
        list.add(bbb);

        System.out.println("List member 0: " + mmm.toString()+"\n");
        System.out.println("List member 0: " + aaa.toString()+"\n");
        System.out.println("List member 0: " + bbb.toString()+"\n");

        for(AbstractMedia s: list){
            System.out.println(s);
        }

        Lender lll = new Lender("lll1", new AbstractMedia());
}
