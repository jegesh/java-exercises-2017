package electric.college.multithreading.synchronization;

public class SynchronizedCountingExample {
    public static void main(String[] args) throws InterruptedException {
        final SynchronizedCounter counter = new SynchronizedCounter();
        Thread first = new Thread(new Runnable() {
            int cycles = 0;
            public void run() {
                while(!Thread.interrupted()){
                    counter.increment();
                    cycles++;
                    System.out.println("first thread: " + counter.value());
                }
                System.out.println("first thread: " + counter.value());
                System.out.println("first thread cycles: " + cycles);
            }
        });
        Thread second = new Thread(new Runnable() {
            int cycles = 0;
            public void run() {
                while(!Thread.interrupted()){
                    counter.decrement();
                    cycles++;
                    System.out.println("second thread: " + counter.value());
                }
                System.out.println("second thread: " + counter.value());
                System.out.println("second thread cycles: " + cycles);
            }
        });
        first.start();
        second.start();
        Thread.sleep(5000, 55);
        first.interrupt();
        second.interrupt();
        System.out.println("Main thread: " + counter.value());
    }
}

