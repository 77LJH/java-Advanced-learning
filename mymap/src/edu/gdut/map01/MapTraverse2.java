package edu.gdut.map01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Luffy
 */
public class MapTraverse2 {
    public static void main(String[] args) {
        // Map集合的遍历----键值对

        // 创建集合对象
        Map<String,String> map=new HashMap<>();

        // V put(K key, V value)：添加元素
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        map.put("004","赵六");

        //通过一个方法获取所有的键值对对象，返回一个set集合
        Set<Map.Entry<String,String>> entries=map.entrySet();

        Iterator<Map.Entry<String,String>> it=entries.iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry=it.next();
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" = "+value);
        }
        System.out.println("--------");

        for(Map.Entry<String,String> entry : entries){
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" = "+value);
        }
        System.out.println("--------");

        entries.forEach(entry -> {
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" = "+value);
        });
        System.out.println("--------");
    }
}
