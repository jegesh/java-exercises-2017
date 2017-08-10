package il.co.electriccollege.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yaakov on 8/1/17.
 */
public class CollectionsPlayground {

    public static void main(String[] args) {
        System.out.println("Start list collection");
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("hello");
        stringList.add("world");

        // the values of the list are accessible by index
        System.out.println("List member 0: " + stringList.get(0));
        System.out.println("List member 1: " + stringList.get(1));

        // this is how we iterate over the whole list
        for(String s: stringList){
            System.out.println(s);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Start set collection");
        HashSet<String> stringSet = new HashSet<String>();
        stringSet.add("electric");
        stringSet.add("college");

        // set members are not accessible individually, only by iterating through the set
        for(String s: stringSet){
            System.out.println("Set member: " + s);
        }

        System.out.println("");
        System.out.println("Start map collection");
        HashMap<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("city", "Hadera");
        stringMap.put("street", "HaShalom");

        // map members are accessible by key
        System.out.println("key: city; value: " + stringMap.get("city"));
        System.out.println("key: street; value: " + stringMap.get("street"));

        // iteration over a map is possible by getting the entry set
        for(Map.Entry<String, String> entry: stringMap.entrySet()){
            System.out.println(entry);
        }

    }
}
