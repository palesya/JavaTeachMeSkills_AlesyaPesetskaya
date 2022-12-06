package preparing;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vase vase = new Vase();

        iFilling filling = el -> System.out.println("This is it "+ el);
        filling.fillWithWater(vase);



        int i=10000;
        Integer integer = Integer.valueOf(i);
        Integer integer1 = Integer.valueOf(i+13);

        int i2 = integer1.compareTo(integer);
        System.out.println(i2);
        Integer ifd = i;
        int i1 = ifd.intValue();
        System.out.println(i1);
        int c = ifd;

        OuterClass oc = new OuterClass();
        oc.someMethod(23,34);


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);



        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.forEach(item -> System.out.println(item));

//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        System.out.println(next);

        Dog dogWithTail = new Dog("Tail", 3);
        Dog.Fly fly = new Dog.Fly();
        fly.sayHello();

        dogWithTail.tail.burke();
        Dog clone = dogWithTail.clone();
        System.out.println(clone.toString());

        Printer print = text -> System.out.println(text);
        print.print("hello");

        int a = 5;
        switch (a) {
            case 0:
                System.out.print("0");
            case 5:
                System.out.print("5");
            case 9:
                System.out.print("9");
            case 10:
                System.out.print("10");
                break;
            default:
                System.out.print("!");
        }


//        char abc = 'd';
//        int in =abc;
//        System.out.println(in);
//
        Dog dog1 = new Dog("OOps") {
            @Override
            public void thisEat() {
                super.thisEat();
                System.out.println("I'm overwritten");
            }
        };
        dog1.my_Method();
        dog1.thisEat();
//
//
//        Dog dog = new Dog("Name");
//        dog.thisEat();
//        dog.superEat();
//        dog.calc();
//        System.out.println(dog instanceof Animal);
//
//        int[] array = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        bubbleSorting(array);
//
//        for (int i=0; ; i++) {
//            if(i == 2){
//                    System.out.println("двойка"+i);
//                    break;
//            } else
//                    System.out.println("не двойка"+i);
//        }
//
//        }
//
//    public static void bubbleSorting(int[] array) {
//        int length = array.length;
//        for (int i = 1; i < length; length--) {
//            for (int k = i; k < length; k++) {
//                int firstEl = array[k - 1];
//                if (array[k - 1] > array[k]) {
//                    array[k - 1] = array[k];
//                    array[k] = firstEl;
//                }
//            }
//            System.out.println(Arrays.toString(array));
//        }
    }
}
