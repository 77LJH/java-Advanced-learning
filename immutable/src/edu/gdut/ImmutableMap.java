package edu.gdut;

import java.util.Map;

public class ImmutableMap {
    public static void main(String[] args) {
        // 1. Map.of()方法创建的Map是不可变的,如果传入了相同的key,则会抛出异常，一定要保证key的唯一性
        //map里的参数数量是有限的，最多只能有10个，如果超过10个，就会抛出异常
        //如果需要创建更多的元素，可以使用Map.ofEntries()方法


        //2.如果需要创建更多的元素,Map.copyOf()方法可以将一个Map转换为不可变的Map,它的底层实现是调用Map.ofEntries()方法

        Map<String, String> map = Map.of("a", "aa", "b", "bb", "c", "cc");

        for(String s : map.keySet()) {
            System.out.println(s);
        }
        System.out.println("--------");

        for(String s : map.values()) {
            System.out.println(s);
        }
        System.out.println("--------");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("--------");

        map.forEach((k, v) -> System.out.println(k + " " + v));

        try{
            map.put("d", "put");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" put");
        }

        try{
            map.remove("a");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" remove");
        }
    }
}
