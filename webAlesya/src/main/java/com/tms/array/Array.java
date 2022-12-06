package com.tms.array;

import java.util.*;

public class Array {

    public static void main(String[] args) {

        Stack<Integer> queue = new Stack<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        Integer peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue);
        Integer poll = queue.pop();
        System.out.println(poll);
        System.out.println(queue);

        String book = "Book";

        Map<String,String> map = new HashMap<>();
        map.put(book,"MyBook");
        map.put("Vine","MyVine");
        map.putIfAbsent("Computer","MyComputer");

        String book1= "Book1";
        map.put(book1,"MyBook");


        System.out.println(map.get("Book"));
        System.out.println(map.getOrDefault("My","No element"));

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> el:entries){
            System.out.println(el);
        }

        Set<String> strings = map.keySet();
        for(String el:strings){
            System.out.println(el);
        }


        Set<Integer> setInteger = new HashSet<>();
        setInteger.add(11);
        setInteger.add(56);
        setInteger.add(87);
        for(Integer el:setInteger){
            System.out.println(el);
        }

        int[][] array = new int[7][8];
        ArrayHelper helper = new ArrayHelper();

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(14);
        list.add(56);

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

        System.out.println(list);

        System.out.println(helper.factorial(3));
        System.out.println(helper.fibonachi(10));

        helper.fillArray(array);
        helper.printArray(array);
        System.out.println(Arrays.deepToString(array));
        int[][] sorted = helper.sortArray(array);
        helper.printArray(sorted);

        int[] oneDimArray={6,5,4,3,2,1};
        helper.sortOneDimArray(oneDimArray);
        System.out.println(Arrays.toString(oneDimArray));
    }






}
