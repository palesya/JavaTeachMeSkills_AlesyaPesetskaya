package Lecture_7.Examples;

import Lecture_7.Implementation.Duck;
import Lecture_7.Implementation.Plane;
import Lecture_7.Implementation.Rocket;

import java.util.Scanner;

import static Lecture_7.Examples.BookGenre.NOVEL;

public class Main {
    public static void main(String[] args) {
        Book newBook=new Book("Fight club","Chack Palanic",NOVEL);
        System.out.printf("Book '%s' has the genre %s, and it's author is %s\n",newBook.getName(),newBook.getGenre().toString().toLowerCase(),newBook.getAuthor());
   switch (newBook.getGenre()){
       case NOVEL:
           System.out.println("This is novel.");
           break;
       case SCIENCE:
           System.out.println("This is science.");
           break;
       case FAIRY_TAILS:
           System.out.println("This is fairy-tail.");
           break;
       case FANTASY:
           System.out.println("This is fantasy.");
           break;
   }
        BookGenre[] types= BookGenre.values();
        for (BookGenre book: types) {
            System.out.println(book);
        }
        System.out.println(newBook.getGenre().getDescription());

        Flyable flyable=new Duck();
        flyable.fly();

        Flyable flyable1=new Plane();
        flyable1.fly();

        Scanner scanner=new Scanner(System.in);
                String flyer= scanner.nextLine();
        switch (flyer){
            case"D":
                flyable=new Duck();
                break;
            case"P":
                flyable=new Plane();
                break;
            default:
                flyable=new Rocket();
        }
        flyable.fly();

        Duck duck = new Duck();
        duck.makeSomeNoise();

        Noisable noisable = new Rocket();
        noisable.makeSomeNoise();

        InnerClass innerClass=new InnerClass();
        innerClass.test();
    }
    public static class InnerClass implements InnerInterface{
        int a;
        int b;

        @Override
        public void test() {
            System.out.println(a+b);
        }
    }
    public interface InnerInterface {
        void test();
    }
}