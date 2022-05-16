package lecture_8.Implementation;

import lecture_8.Printable;

public class Book implements Printable {

    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("This is a book "+this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printBooks(Printable[] printable){
        for (Printable el:printable) {
            if(el instanceof Book){
                el.print();
            }
        }
    }
}
