package electric.college.multithreading.publisher;

import java.util.Random;

public class Consumer implements Runnable {
    private Messenger messenger;

    public Consumer(Messenger messenger) {
        this.messenger = messenger;
    }

    public void run() {
        Random random = new Random();
        for (String message = messenger.take();
             ! message.equals("DONE");
             message = messenger.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}