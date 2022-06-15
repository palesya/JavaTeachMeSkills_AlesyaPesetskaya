package homework_18;

import java.util.List;

import static homework_18.AbstractContainer.ACTION.ADD_ACTION;
import static homework_18.AbstractContainer.ACTION.REMOVE_ACTION;

public abstract class AbstractContainer {

    protected List<Object> objectList;

    public AbstractContainer(List<Object> objectList) {
        this.objectList = objectList;
    }

    public enum ACTION {
        ADD_ACTION,
        REMOVE_ACTION
    }

    public void saveRemoveLogic(Object object, ACTION action){
        try {
            System.out.println("Save/remove message before sleep");
            Thread.sleep(1000);
            System.out.println("Save/remove Message after sleep");
            if (action == ADD_ACTION) {
                objectList.add(object);
                System.out.println("Object is added");
            } else if (action == REMOVE_ACTION) {
                long found = findObjectLogic(object);
                if (found > 0) {
                    objectList.remove(object);
                    System.out.println("Object is removed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long findObjectLogic(Object object) {
        long found = 0;
        try {
            System.out.println("Search message before sleep");
            Thread.sleep(1000);
            System.out.println("Search message after sleep");
            found = this.objectList.stream()
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

}
