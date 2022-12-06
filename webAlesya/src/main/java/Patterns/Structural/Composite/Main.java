package Patterns.Structural.Composite;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Item item1 =new Item(100,"Bread");
        Item item2 =new Item(200,"Milk");
        Item item3 =new Item(300,"Chocolate");
        Item item4 =new Item(400,"Sausages");

        Box box1 = new Box(Arrays.asList(item3, item4));
        Box box2 =new Box(List.of(item2, box1));
        Box box3 =new Box(Arrays.asList(item1, box2));
        System.out.println(box3.countPrice());

    }
}
