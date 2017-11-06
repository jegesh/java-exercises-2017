package electric.college.multithreading.publisher;

public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        (new Thread(new Consumer(messenger))).start();
        (new Thread(new Producer(messenger))).start();
    }
}
