package electric.college.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBookMain {

    public static void main(String[] args) {
        List<PhoneBookEntry> entries = new ArrayList<>();
        entries.add(new PhoneBookEntry("Yossi Bahluly", "05655554"));
        entries.add(new PhoneBookEntry("Bossi Bahluly", "05655554"));
        entries.add(new PhoneBookEntry("Aossi Bahaluly", "05655554"));
        entries.add(new PhoneBookEntry("Zossi Bahluly", "05655554"));
        entries.add(new PhoneBookEntry("Yossi Cahluly", "05655554"));
        entries.add(new PhoneBookEntry("Yossi Dahluly", "05655554"));
        entries.add(new PhoneBookEntry("Yossi Gahluly", "05655554"));
        entries.add(new PhoneBookEntry("Zossi Aahluly", "05655556"));
        entries.add(new PhoneBookEntry("Zossi Aahluly", "05655554"));
        entries.add(new PhoneBookEntry("Zossi Aahluly", "05655555"));

        Stream<PhoneBookEntry> stream1 = entries.stream();

        // get first letters of all entries
        Stream<Character> allFirstLetters  = stream1.map(x -> x.getName().toLowerCase().charAt(0));
        Stream<Character> sortedFirstLetters = allFirstLetters.sorted(Comparator.naturalOrder());

        // first letters - one of each only
        Stream<Character> distinctFirstLetters  = sortedFirstLetters.distinct();

        // return as list
        List<Character> firstLettersList = distinctFirstLetters.collect(Collectors.toList());
        System.out.println(firstLettersList);

        HashMap<Character, List<PhoneBookEntry>> phoneBook = new HashMap<>();
        // now get list of names starting with each letter
        for(char c: firstLettersList){
            Stream<PhoneBookEntry> stream2 = entries.stream();

            // get entries that start with the given first letter
            Stream<PhoneBookEntry> singleLetterEntries =
                    stream2.filter(x -> x.getName().toLowerCase().charAt(0) == c);

            // sort by full name
            Stream<PhoneBookEntry> sortedEntryList =
                    singleLetterEntries.sorted(Comparator.comparing(PhoneBookEntry::getName));

            //Stream<PhoneBookEntry> sortedEntryList =
            //        singleLetterEntries.sorted((x,y) -> x.getName().compareTo(y.getName()));

            // get as list
            List<PhoneBookEntry> sortedList = sortedEntryList.collect(Collectors.toList());
            phoneBook.put(c, sortedList);
        }
        System.out.println(phoneBook);
        System.out.println();

        HashMap<Character, List<PhoneBookEntry>> phoneBook2 = new HashMap<>();
        // same as above, all in one line
        for(char c: firstLettersList){
            phoneBook2.put(c,
                    entries.stream()
                            .filter(x -> x.getName().toLowerCase().charAt(0) == c)
                            .sorted(Comparator.comparing(PhoneBookEntry::getName))
                            .collect(Collectors.toList())
            );
        }
        System.out.println(phoneBook2);

    }
}




