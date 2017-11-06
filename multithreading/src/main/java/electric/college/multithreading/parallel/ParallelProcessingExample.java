package electric.college.multithreading.parallel;

import java.io.File;

public class ParallelProcessingExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Please be patient while we process your pictures...");
        ParallelWorkerThread thread1 = new ParallelWorkerThread(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-3.jpg"));
        ParallelWorkerThread thread2 = new ParallelWorkerThread(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-2.jpg"));
        ParallelWorkerThread thread3 = new ParallelWorkerThread(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-1.jpg"));
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
//        thread1.join();
//        System.out.println("after join1");
//        thread2.join();
//        System.out.println("after join2");
//        thread3.join();
//        System.out.println("after join3");

        System.out.println("All done");
    }
}
