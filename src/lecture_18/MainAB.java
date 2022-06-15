package lecture_18;

import java.lang.management.ManagementFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainAB {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        DifPrint difPrint = new DifPrint(lock);
        Thread thread1 = new Thread(difPrint::print);
        thread1.start();

        Thread thread2 = new Thread(difPrint::print);
        thread2.start();
        ManagementFactory.getPlatformMBeanServer();

//        BlockService blockService=new BlockService(new A(),new B());
//        Thread thread1 = new Thread(blockService::inc,"inc");
//        Thread thread2=new Thread(blockService::decr,"decr");

    }
}
