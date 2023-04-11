package edu.gdut.map01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Luffy
 */
public class MapTraverse1 {
    public static void main(String[] args) {
        // Map集合的遍历----键找值

        // 创建集合对象
        Map<String,String> map=new HashMap<>();

        // V put(K key, V value)：添加元素
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        map.put("004","赵六");

        //获取所有的键,存储到一个单列Set集合中
        Set<String> keys = map.keySet();

        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = map.get(key);
            System.out.println(key+" = "+value);
        }
        System.out.println("--------");

        keys.forEach(key -> {
            String value = map.get(key);
            System.out.println(key+" = "+value);
        });
        System.out.println("--------");

        for(String key : keys){
            String value = map.get(key);
            System.out.println(key+" = "+value);
        }
        System.out.println("--------");
    }
}
