package homework_18.endless;

import homework_18.AbstractContainer;

import java.util.Arrays;
import java.util.List;

public class Container extends AbstractContainer {

    public Container(List<Object> objectList) {
        super(objectList);
    }

    public synchronized void saveRemoveObject(Object object, ACTION action) {
        saveRemoveLogic(object, action);
    }

    public synchronized void findObject(Object object) {
        findObjectLogic(object);
    }

    @Override
    public String toString() {
        return "Container{" +
                "objectList=" + Arrays.toString(objectList.toArray()) +
                '}';
    }
}
