package il.co.electriccollege.library;

import il.co.electriccollege.library.media.AbstractMedia;
import il.co.electriccollege.library.media.magazine;

import java.util.ArrayList;

/**
 * Created by yaakov on 8/20/17.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<AbstractMedia> list = new ArrayList<>();
        magazine mmm = new magazine (9001,"mmm1","pub1",11.1.1911, "8/106");
        list.add(mmm);

        System.out.println("List member 0: " + mmm.toString()+"\n");

        for(AbstractMedia s: list){
            System.out.println(s);


        }
}
