package il.co.electriccollege.library.yossi;

import il.co.electriccollege.library.yossi.lender.Lender;
import il.co.electriccollege.library.yossi.media.AbstractMedia;
import il.co.electriccollege.library.yossi.media.Audiobook;
import il.co.electriccollege.library.yossi.media.Book;
import il.co.electriccollege.library.yossi.media.Magazine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        ArrayList<AbstractMedia> list = new ArrayList<>();
        DateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date D = dataFormat.parse("21/08/2017");
        Magazine mmm = new Magazine(9001, "mmm1", "pub1", new Date(1911, 1, 11), "8/106");
        list.add(mmm);
        Audiobook aaa = new Audiobook(8001, "aaa1", "pub2", D, "nnn1", 4);
        list.add(aaa);
        Book bbb = new Book(1001, "aaa1", "pub2", D);
        list.add(bbb);

        System.out.println("List member 0: " + mmm.toString());
        System.out.println("List member 1: " + aaa.toString());
        System.out.println("List member 2: " + bbb.toString() + "\n");

        for (AbstractMedia s : list) {
            System.out.println(s);
        }


    }
}
