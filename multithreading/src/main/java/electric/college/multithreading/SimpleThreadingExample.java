package electric.college.multithreading;

public class SimpleThreadingExample {

    public static void main(String[] args) throws InterruptedException {
        Thread countingThread = new CountingThread();
        countingThread.setDaemon(true);
        countingThread.start();

        Thread.sleep(4000);
        while (!countingThread.isInterrupted())
            countingThread.interrupt();
        Thread.sleep(1500);
        System.out.println("end");

    }
}
