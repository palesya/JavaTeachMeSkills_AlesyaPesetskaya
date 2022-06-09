package homework_18.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Container extends Thread {

    private List<Object> objectList;
    private Lock lock;

    enum ACTION {
        ADD_ACTION,
        REMOVE_ACTION
    }

    public Container(List<Object> objectList, Lock lock) {
        this.objectList = objectList;
        this.lock = lock;
    }

    public void saveRemoveObject(Object object, ACTION action) {
        lock.lock();
        try {
            System.out.println("Save/remove message before sleep");
            Thread.sleep(1000);
            System.out.println("Save/remove Message after sleep");
            if (action == ACTION.ADD_ACTION) {
                objectList.add(object);
                System.out.println("Object is added");
            } else if (action == ACTION.REMOVE_ACTION) {
                long found = findObject(object);
                if (found > 0) {
                    objectList.remove(object);
                    System.out.println("Object is removed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }


    public long findObject(Object object) {
        lock.lock();
        long found = 0;
        try {
            System.out.println("Search message before sleep");
            Thread.sleep(1000);
            System.out.println("Search message after sleep");
            found = objectList.stream()
                    .filter(el -> el.equals(object)).count();
            if (found > 0) {
                System.out.println("Object is found.");
            } else {
                System.out.println("Object is not found.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return found;
    }

}
