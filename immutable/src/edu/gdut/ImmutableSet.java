package edu.gdut;

import java.util.Iterator;
import java.util.Set;

public class ImmutableSet {
    public static void main(String[] args) {
        // 1. Set.of()方法创建的Set是不可变的,如果传入了相同的值,则会抛出异常，一定要保证元素的唯一性

        Set<String> set = Set.of("a", "b", "c");

        for(String s : set) {
            System.out.println(s);
        }
        System.out.println("--------");

        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------");

        set.forEach(s -> System.out.println(s));
        System.out.println("--------");

        try{
            set.add("d");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" add");
        }

        try{
            set.remove("a");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" remove");
        }
    }
}
