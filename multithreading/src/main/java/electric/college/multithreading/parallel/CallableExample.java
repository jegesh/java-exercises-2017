package electric.college.multithreading.parallel;

import java.io.File;

public class CallableExample {


    public static void main(String[] args) throws InterruptedException {
        // this example doesn't run concurrently
        System.out.println("Please be patient while we process your pictures...");
        ParallelProcessingCallable callable1 = new ParallelProcessingCallable(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-1.jpg"));
        ParallelProcessingCallable callable2 = new ParallelProcessingCallable(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-2.jpg"));
        ParallelProcessingCallable callable3 = new ParallelProcessingCallable(new File("/Users/yaakov/Desktop/photos/bar mitzvah/binaymin-bar-mitzvah-3.jpg"));

        CallableThread workerThread1 = new CallableThread(callable1);
        CallableThread workerThread2 = new CallableThread(callable2);
        CallableThread workerThread3 = new CallableThread(callable3);
        workerThread1.run();
        workerThread2.run();
        workerThread3.run();
//        workerThread1.join();
//        workerThread2.join();
//        workerThread3.join();
        Object result1 = workerThread1.getResult();
    }
}
