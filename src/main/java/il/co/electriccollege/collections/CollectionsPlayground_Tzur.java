package il.co.electriccollege.collections;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.HashSet;


/**
 * Created by 'Tzur' on 8/1/17.
 */
class exercise_IntroductiontoCollections {
    public static int letter = 65;

    public static void main(String[] args) {
//ArrayList that contains 3 letter
        ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();
        ArrayList<String> al3 = new ArrayList<String>();

        al1.addAll(insert3letter());
        al2.addAll(insert3letter());
        al3.addAll(insert3letter());

        System.out.println(al1.toString() + al2.toString() + al3.toString());


//ArrayList that contains ArrayLists
        ArrayList<ArrayList> alAll = new ArrayList();
        alAll.add(al1);
        alAll.add(al2);
        alAll.add(al3);
        System.out.println(alAll.toString());

//a HashSet that contains ArrayLists
        HashSet<ArrayList<ArrayList>> hsWithAl = new HashSet<ArrayList<ArrayList>>();
        hsWithAl.add(alAll);
        System.out.println(hsWithAl);

//HashMap that contains HashMaps
        HashMap<String, String> hmFirst = new HashMap();

        hmFirst.put(al1.get(0), al1.get(0));
        hmFirst.put(al1.get(1), al1.get(1));
        hmFirst.put(al1.get(2), al1.get(2));
        System.out.println(hmFirst);

        HashMap<String,HashMap> hmSecend= new HashMap();

        hmSecend.put("result",hmFirst);
        System.out.println(hmSecend);

        for(HashMap.Entry<String, HashMap> curr : hmSecend.entrySet()) {

            System.out.println(curr.getValue().containsKey("D"));
//            HashMap<String, String> temp = new HashMap<>();
//            temp.put(curr.getKey("result"));
        }
    }


    //FUNCTIONS
// insert 3 letter by the ABC


    public static ArrayList<String> insert3letter() {

        ArrayList<String> al = new ArrayList<String>();

        al.add("" + (char) letter);
        letter++;
        al.add("" + (char) letter);
        letter++;
        al.add("" + (char) letter);
        letter++;
        return al;
    }
}
