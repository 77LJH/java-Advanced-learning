package edu.gdut.linkedhashmap03;

import java.util.LinkedHashMap;

/**
 * @author Luffy
 */
public class LinkedHashMap01 {
    public static void main(String[] args) {
        // LinkedHashMap是HashMap的子类
        // LinkedHashMap是有序的，存储和取出的顺序一致
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("001", "张三");
        linkedHashMap.put("002", "李四");
        linkedHashMap.put("003", "王五");
        linkedHashMap.put("004", "赵六");

        System.out.println(linkedHashMap);
    }
}
