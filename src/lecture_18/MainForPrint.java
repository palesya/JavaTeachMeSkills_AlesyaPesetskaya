package lecture_18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainForPrint {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        DifPrint difPrint1 = new DifPrint(lock);
        DifPrint difPrint2 = new DifPrint(lock);

        MyThreadForPrint thread1 = new MyThreadForPrint(difPrint1);
        MyThreadForPrint thread2 = new MyThreadForPrint(difPrint1);
        MyThreadForPrint thread3 = new MyThreadForPrint(difPrint2);

        thread1.setDaemon(true);
        thread2.setDaemon(true);

        System.out.println("end");

//        difPrint1.print();
//        difPrint2.print();

        thread1.start();
        thread2.start();
        thread3.start();

        //thread3.join();

    }
}
