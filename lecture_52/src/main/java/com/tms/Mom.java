package main.java.com.tms;

public class Mom {

    private String str;
    private Child child = new Child();
    private static Integer integer;
    private ChildStatic childStatic = new ChildStatic();

    private final Integer i = 12;

    public void main() {
        child.print();
        childStatic.printStatic();
    }

    public class Child {
        public void print() {
            System.out.println("i'm in"+str);
        }
    }

    public static class ChildStatic {
        public void printStatic() {
            System.out.println("i'm in static"+integer);
        }
    }

    public static class Hello{
        public void print(){
            System.out.println("hello");
        }

    }


}
