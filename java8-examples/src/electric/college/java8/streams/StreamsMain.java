package electric.college.java8.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {

    public static void main(String[] args) throws IOException {

        // stream from collection
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f");
        Stream<String> stream = strings.stream().parallel();
        List<String> descendingLetters = stream.sorted(
                (a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        System.out.println("descending letters: " + descendingLetters);

        System.out.println("======================");
        // stream from array
        String[] strArray = new String[]{"a1", "b1", "c1"};
        Stream<String> stream2 = Arrays.stream(strArray);
        String longString = stream2.reduce((x,y) -> x+y).get();
        System.out.println("Reduced example: " + longString);
        System.out.println("====================");

        // stream from file
        Stream stream3 = Files.lines(Paths.get("java8-examples.iml"));

        // create the array on the fly
        Stream<String> stream4 = Stream.of("James", "Bond", "Jason", "Bourne", "Jonathan", "Berkowitz");
        stream4 = stream4.map(s -> s.substring(0,2));

        // mapping with integers
        Integer[] ints = new Integer[]{1,2,3,4,5};
        Stream<Integer> intStream = Stream.of(ints);
        Stream<Double> doubStream = intStream.map(n -> 1.5*n);

        // speed test for parallel processing
        long startTime = System.currentTimeMillis();
        List<String> condensedLines = Files.lines(Paths.get("sample.txt"))
                .filter(n -> n.length() > 100)
                .map(n -> Base64.getEncoder().encode(n.getBytes()).toString())
                .collect(Collectors.toList());
        System.out.printf("Serial processing took %s milliseconds", System.currentTimeMillis() - startTime);

        System.out.println("");
        startTime = System.currentTimeMillis();
        List<String> condensedLines2 = Files.lines(Paths.get("sample.txt")).parallel()
                .filter(n -> n.length() > 100)
                .map(n -> Base64.getEncoder().encode(n.getBytes()).toString())
                .collect(Collectors.toList());
        System.out.printf("Parallel processing took %s milliseconds", System.currentTimeMillis() - startTime);

        //reduce example
        Integer[] intArr = new Integer[]{1,2,3,4,5};
        Stream<Integer> intStream2 = Stream.of(intArr);
        int result = intStream2.reduce(1, (x,y) -> x*y);
        System.out.println("Reduce result: " + result);

//        Stream.iterate()Stream.of(1).flatMap(n -> new);
    }
}
