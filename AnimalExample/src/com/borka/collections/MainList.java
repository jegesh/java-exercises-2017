package com.borka.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Comp14 on 05/09/2017.
 */
public class MainList {

    public static void main(String[] args) {

    ArrayList<String> fullList = new ArrayList<String>();
        fullList.add("dog");
        fullList.add("table");
        fullList.add("cat");
        fullList.add("armchair");
        fullList.add("dog");
        fullList.add("seat");
        fullList.add("cat");

     ArrayList<String> animalList = new ArrayList<>();
        animalList.add("cat");
        animalList.add("dog");

     deleteDoubles(fullList, animalList);
//        Collections.sort(fullList);
//        System.out.println(fullList);

    }


    public static void deleteDoubles(ArrayList<String> list1, ArrayList<String> list2) {

        System.out.println("Start: " + list1.toString());

        ///////////Example 1 . remove once by foreach ///////
//        for (String curr: list2 ) {
//
//                        System.out.println("lis2 " +curr);
//                        for (String innerCurr: list1) {
//                            System.out.println("list1 " +innerCurr);
//                            if (curr.equals(innerCurr)) {
//                                System.out.println("Bingo");
//                                list1.remove(innerCurr);
//                                break;
//                }
//            }
//        }

//        Iterator<String> iterator =list1.iterator();
//             while

//        for(int i=0;i<fullList.size() && i<animalList.size();i++){
//            if(fullList.get(i).equals(animalList.get(i))) {
//                fullList.remove(fullList.get(i));
//            }
//        }
  //      System.out.println("Start: " + list1.toString());

        for (int i = 0; i < list2.size(); i++) {

            System.out.println("External : " + list1.get(i) + " vs " + (list2.get(i)) );
            if (list1.contains(list2.get(i)))
            {
                System.out.println(list1.get(i) + " vs " + (list2.get(i)) );
               list1.remove(list2.get(i));
               i--;
            }

            System.out.println(list1.toString());
            System.out.println(list2.toString());
        }


        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }

}
