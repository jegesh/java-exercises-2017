package electric.college.multithreading;

public class CountingThread extends Thread {

    @Override
    public void run() {
        for(int i = 0;;i++){
            try {
                sleep(1000);
                System.out.println("CountingThread says: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            if(i > 9)
                return;
        }
    }
}
