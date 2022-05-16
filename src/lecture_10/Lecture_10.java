package lecture_10;

public class Lecture_10 {
    public static void main(String[] args) {

        String string1 = "Hello!";
        String string2 = new String("Hello again!");
        String string3 = String.valueOf("Hello once again!");
        string1 = string1 + " " + string2;
        String string4 = string1 + " " + string2 + " " + string3;
        String result = string1.concat(string3);
        String result1 = String.join(" ", string2, string4);
        System.out.println(string1);
        System.out.println(string4);
        System.out.println(result);
        System.out.println(result1);

        Integer value = 10;
        System.out.println(string1 + value + value);
        System.out.println(string1.charAt(4));
        char[] chars = string2.toCharArray();
        chars[2] = 'Y';
        String newText = new String(chars);
        System.out.println(newText);
        System.out.println(string4.indexOf("ag"));
        System.out.println(string4.lastIndexOf("ag"));
        System.out.println(string3.replace("ll", "!!"));
        System.out.println(string1.toLowerCase());
        System.out.println(string1.toUpperCase());
        String[] str = string1.split("o");
        for (String el : str) {
            System.out.println(el);
        }
        String spaces = "     ";
        System.out.println(spaces.isEmpty());
        System.out.println(string3.substring(2, 6));
        System.out.println("Are strings equal: " + string1.equals(string2));
        String text1 = "AAA";
        String text2 = "Aaa";
        System.out.println("Are strings equal: " + text1.equals(text2));
        String text3 = "a";
        String text4 = "AAAAAAAAAAA";
        System.out.println(text3.compareTo(text4));
        System.out.println(text4.endsWith("a"));

        StringBuilder builder = new StringBuilder("Hello")
                .append(1)
                .append("test")
                .insert(5, "oops")
                .reverse();
        String s = builder.toString();
        System.out.println(s);

        int num = 5;
        int res = factorial(num);
        System.out.println(res);
        int fib = fibonachi(5);
        System.out.println(fib);
    }

    public static int factorial(int num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }

    public static int fibonachi(int num) {
        if (num < 2) {
            return 1;
        } else {
            return fibonachi(num - 1) + fibonachi(num - 2);
        }
    }
}
