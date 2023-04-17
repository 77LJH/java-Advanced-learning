package edu.gdut;

import java.util.Iterator;
import java.util.List;

public class ImmutableList {
    public static void main(String[] args) {
        // 1. List.of()方法创建的List是不可变的

        List<String> list = List.of("a", "b", "c");

        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("--------");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------");

        list.forEach(s -> System.out.println(s));
        System.out.println("--------");



        try {
            list.add("d");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" add");
        }

        try {
            list.remove(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" remove");
        }
    }
}
