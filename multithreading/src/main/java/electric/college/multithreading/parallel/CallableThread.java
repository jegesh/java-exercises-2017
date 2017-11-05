package electric.college.multithreading.parallel;

import java.util.concurrent.Callable;

public class CallableThread extends Thread {
    private Callable callable;
    private Object result;

    public CallableThread(Callable callable){
        this.callable = callable;
    }

    public Object getResult(){
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
    }
}
