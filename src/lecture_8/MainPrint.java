package lecture_8;

import lecture_8.Implementation.Book;
import lecture_8.Implementation.Magazine;

public class MainPrint {
    public static void main(String[] args) {
        Printable book=new Book("War and peace");
        Printable magazine =new Magazine("Elle");
        Printable book1=new Book("Anna Karenina");
        Printable magazine1 =new Magazine("Men");
        Printable[] array={book,magazine,book1,magazine1};
        for (Printable el:array) {
            el.print();
        }
        System.out.println("-----BOOKS-----");
        Book.printBooks(array);
        System.out.println("-----MAGAZINES------");
        Magazine.printMagazines(array);
    }
}
