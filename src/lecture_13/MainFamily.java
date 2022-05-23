package lecture_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainFamily {
    public static void main(String[] args) {

        Family family1 = new Family("First", null);
        Family family2 = new Family("Ivanovy", Arrays.asList(new Child(6,"Vika")));
        Family family3 = new Family("Pesetskiye", Arrays.asList(new Child(3,"Melaniya"), new Child(8, "Sofiya")));

        List<Family> families = new ArrayList<>();
        families.add(family1);
        families.add(family2);
        families.add(family3);

        Iterator<Family> iterator = families.iterator();
        List<Family> result = new ArrayList<>();

        while (iterator.hasNext()) {
            Family family = iterator.next();
            List<Child> childList = family.getChildList();
            if (childList != null && !childList.isEmpty()) {
                result.add(family);
            }
        }

        System.out.println(result);

        List<Child> children = new ArrayList<>();
        for (Family el : families) {
            List<Child> childList = el.getChildList();
            if (childList == null || childList.isEmpty()) {
                continue;
            }
            for (Child child : childList) {
                if (child.getAge() > 3) {
                    children.add(child);
                }
            }

        }

        System.out.println(children);

        System.out.println(children.contains(new Child(6, "Vika")));

    }
}
