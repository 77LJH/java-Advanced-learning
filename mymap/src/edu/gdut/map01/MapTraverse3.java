package edu.gdut.map01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luffy
 */
public class MapTraverse3 {
    public static void main(String[] args) {
        // Map集合的遍历----lambda表达式

        // 创建集合对象
        Map<String,String> map=new HashMap<>();

        // V put(K key, V value)：添加元素
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        map.put("004","赵六");

        //底层原理
        //利用entrySet()方法，将Map集合中的映射关系转换为Set集合
        map.forEach((key, value) -> System.out.println(key+" = "+value));
    }
}
