package homework_18.lock;

import homework_18.AbstractContainer;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container extends AbstractContainer {

    private Lock lock = new ReentrantLock();

    public Container(List<Object> objectList) {
        super(objectList);
    }

    public void saveRemoveObject(Object object, ACTION action) {
        lock.lock();
        saveRemoveLogic(object, action);
        lock.unlock();
    }

    public void findObject(Object object) {
        lock.lock();
        findObjectLogic(object);
        lock.unlock();
    }

}
