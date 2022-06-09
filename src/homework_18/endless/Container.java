package homework_18.endless;

import java.util.Arrays;
import java.util.List;

import static homework_18.endless.Container.ACTION.ADD_ACTION;
import static homework_18.endless.Container.ACTION.REMOVE_ACTION;

public class Container extends Thread {

    private List<Object> objectList;

    enum ACTION {
        ADD_ACTION,
        REMOVE_ACTION
    }

    public Container(List<Object> objectList) {
        this.objectList = objectList;
    }

    public synchronized void saveRemoveObject(Object object, ACTION action) {
        try {
            System.out.println("Save/remove message before sleep");
            Thread.sleep(1000);
            System.out.println("Save/remove Message after sleep");
            if (action == ADD_ACTION) {
                objectList.add(object);
                System.out.println("Object is added");
            } else if (action == REMOVE_ACTION) {
                long found = findObject(object);
                if (found > 0) {
                    objectList.remove(object);
                    System.out.println("Object is removed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized long findObject(Object object) {
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
        return found;
    }


    @Override
    public void run() {
        super.run();
    }

    @Override
    public String toString() {
        return "Container{" +
                "objectList=" + Arrays.toString(objectList.toArray()) +
                '}';
    }
}
