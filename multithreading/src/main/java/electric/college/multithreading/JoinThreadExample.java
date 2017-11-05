package electric.college.multithreading;

public class JoinThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread countingThread = new CountingThread();
        countingThread.setDaemon(true);
        countingThread.start();

        countingThread.join();
        System.out.println("end");

    }
}
