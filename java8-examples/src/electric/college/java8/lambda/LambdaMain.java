package electric.college.java8.lambda;

public class LambdaMain {

    public static void main(String[] args) {
        // java 7
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a long and cumbersome anonymous class");
            }
        };

        // java 8
        Runnable r8 = () -> System.out.println("I am a cool lambda expression");

        r.run();
        r8.run();

        Nameable nameable = () -> "Jason Bourne";

        // example of multi-line implementation
        Rhymeable rh = (w1, w2) -> {
          System.out.println("word 1: " + w1);
          System.out.println("word 2: " + w2);
          return w1.equals(w2)
                  || w1.substring(w1.length() - 3).equals(w2.substring(w2.length() - 3));
        };

        Rhymeable rhymeable =
                (word1, word2) -> word1.equals(word2)
                        || word1.substring(word1.length() - 3).equals(word2.substring(word2.length() - 3));
    }
}
