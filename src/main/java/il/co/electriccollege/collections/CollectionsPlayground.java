package il.co.electriccollege.collections;



        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Map;
        import java.util.Map.Entry;


public class CollectionsPlayground {


    public static void main(String[] args) {
        System.out.println("Start *List* collection");
        ArrayList <ArrayList<String>>mainList = new ArrayList<>();
        ArrayList<String> list1= new ArrayList<>();
        list1.add("hello1");
        list1.add("world1");
        ArrayList<String> list2= new ArrayList<>();
        list2.add("hello2");
        list2.add("world2");
        ArrayList<String> list3= new ArrayList<>();
        list3.add("hello3");
        list3.add("world3");

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

//    ArrayList <String> stringList = new ArrayList<>();
//        mainList.add("hello");
//        mainList.add("world");

//        // the values of the list are accessible by index
//        System.out.println("List member 0: " + stringList.get(0));
//        System.out.println("List member 1: " + stringList.get(1));

        // this is how we iterate over the whole list
        for(ArrayList<String> s: mainList){

            System.out.println("External list element: "+ s.toString());

            for (String curr: s ) {

                System.out.println("Inner element: "+ curr.toString());
            }
            System.out.println("");
        }
        // ------------------------------------------------------------------------
        System.out.println("");
        System.out.println("Start *Set* collection");
        HashSet<ArrayList<String>> mainSet = new HashSet<>();
        ArrayList<String> listA1= new ArrayList<>();
        listA1.add("hello1");
        listA1.add("world1");
        ArrayList<String> listA2= new ArrayList<>();
        listA2.add("hello2");
        listA2.add("world2");
        ArrayList<String> listA3= new ArrayList<>();
        listA3.add("hello3");

       mainSet.add(listA1);
       mainSet.add(listA2);
       mainSet.add(listA3);
        // set members are not accessible individually, only by iterating through the set
        for(ArrayList<String> s: mainSet){
            System.out.println("Ext member: " + s.toString());

            for (String curr : s) {

            	 System.out.println("Internal member: " + curr);
			}
        }

     // ----------------------------------------------
        System.out.println("");
        System.out.println("Start *Map* collection");

        HashMap<String,HashMap<String,String>> mainHashMap = new HashMap<>();
        HashMap<String, String> stringMap1 = new HashMap<String, String>();
        stringMap1.put("city", "Hadera");
        stringMap1.put("street", "HaShalom");
        HashMap<String, String> stringMap2 = new HashMap<String, String>();
        stringMap2.put("city2", "Hadera2");
        stringMap2.put("street2", "HaShalom2");
        HashMap<String, String> stringMap3 = new HashMap<String, String>();
        stringMap3.put("city3", "Hadera3");
        stringMap3.put("street3", "HaShalom3");

        mainHashMap.put("Hash1", stringMap1);
        mainHashMap.put("Hash2", stringMap2);
        mainHashMap.put("Hash3", stringMap3);

//        // map members are accessible by key
//        System.out.println("key: city; value: " + stringMap.get("city"));
//        System.out.println("key: street; value: " + stringMap.get("street"));

        // iteration over a map is possible by getting the entry set
        for(Map.Entry<String, HashMap<String,String>> extCurr: mainHashMap.entrySet()){
            System.out.println(extCurr);

            for(Map.Entry<String, String> curr: extCurr.getValue().entrySet())
            {
            	System.out.println("key " + curr.getKey() + "  value " + curr.getValue());
            }
      System.out.println("");
        }

    }
}