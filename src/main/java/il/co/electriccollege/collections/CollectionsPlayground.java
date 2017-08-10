package il.co.electriccollege.collections;

import java.util.*;

public class CollectionsPlayground {
    private static final int NUM_NUM = 100;

    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();

        /**
         * ArrayList
         */
        ArrayList<ArrayList<String>> als = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < NUM_NUM; i++) {
            if (i % 2 == 0) {
                al.add("al: " + i + " Hello");
                al1.add("al1: " + i + " Hello");
                al2.add("al2: " + i + " Hello");
            } else {
                al.add("al: " + i + " world");
                al1.add("al1: " + i + " world");
                al2.add("al2: " + i + " world");
            }
        }
        als.add(al);
        als.add(al1);
        als.add(al2);

        /**
         * arrayList printing
         */
        System.out.println("---ArrayList 1----");
        for(ArrayList<String> a : als){
            for(String s : a){
                System.out.print("\t |"+s+"\t |");
            }
            System.out.println();
        }
        System.out.println("--------ArrayList 2-------");
        for(ArrayList<String> a : als){
            System.out.println(a);
        }
        /**
         * HashSet
         */
        System.out.println("--------Hashset---------");
        HashSet<ArrayList<String>> hs = new HashSet<ArrayList<String>>(als);
        ArrayList newal = new ArrayList();
        newal.add("new string");

        hs.add(newal);
        hs.add(al1);

        /**
         * printing HashSet
         */
        for(ArrayList<String> a : hs){
            System.out.println(a);
        }

        /**
         * HashMap
         */
        HashMap<String , String> hmelectric = new HashMap<String , String>();

        hmelectric.put("city","hadera");
        hmelectric.put("rehov","shalom");
        hmelectric.put("phone","054525521");
        hmelectric.put("name","electric");

        HashMap<String,String> hmmaof =  new HashMap<String , String>();
        hmmaof.put("city","hadera");
        hmmaof.put("rehov","david");
        hmmaof.put("phone","02544412");
        hmmaof.put("name","mihlelet maof");

        HashMap<String,String> hmtelran = new HashMap<String , String>();
        hmtelran.put("city","rehovot");
        hmtelran.put("rehov","menahem plaut");
        hmtelran.put("phone","055552255");
        hmtelran.put("name","tel-ran");


        HashMap<String,HashMap<String,String>> ktovot = new HashMap<String,HashMap<String,String>>();
        ktovot.put("electric", hmelectric);
        ktovot.put("maof",hmmaof);
        ktovot.put("tel ran",hmtelran);
        ktovot.put("maof", hmtelran);
        /**
         * printing HashMap
         */
        System.out.println("-------hashmap-------");
        for(Map.Entry<String, HashMap<String,String>> entry : ktovot.entrySet()){
            System.out.println(entry);
        }
    }
}
