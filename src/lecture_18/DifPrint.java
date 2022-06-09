package lecture_18;

import java.util.concurrent.locks.Lock;

public class DifPrint {

    private Lock lock;

    public DifPrint(Lock lock) {
        this.lock = lock;
    }

    void print() {
        lock.lock();
        try {
            Thread.sleep(100);
            System.out.println("1");
            Thread.sleep(100);
            System.out.println("2");
            Thread.sleep(100);
            System.out.println("3");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }
}
