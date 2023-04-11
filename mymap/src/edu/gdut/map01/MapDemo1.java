package edu.gdut.map01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luffy
 */
public class MapDemo1 {
    public static void main(String[] args) {
        //Map集合的特点：
        //1. Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）
        //2. Map集合中的元素，key和value的数据类型可以相同，也可以不同
        //3. Map集合中的元素，key是不允许重复的，value是可以重复的
        //Mao是接口，不能直接创建对象使用，需要使用它的实现类

        /*
        *   V put(K key, V value)：添加元素,如果键重复，值覆盖，返回被覆盖的值
        *   V remove(Object key)：根据键删除键值对元素,返回被删除元素的值
        *   void clear()：移除所有的键值对,集合变成空集合
        *   boolean containsKey(Object key)：判断集合是否包含指定的键
        *   boolean containsValue(Object value)：判断集合是否包含指定的值
        *   boolean isEmpty()：判断集合是否为空
        *   int size()：返回集合中的键值对的对数
        * */

        // 创建集合对象
        Map<String,String> map=new HashMap<>();

        // V put(K key, V value)：添加元素
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        String value1=map.put("004","赵六");
        System.out.println(value1);
        System.out.println(map);
        // 键重复，值覆盖
        String value2 = map.put("004","田七");
        System.out.println(value2);
        System.out.println(map);

        // V remove(Object key)：根据键删除键值对元素,返回被删除元素的值
        String result = map.remove("002");
        System.out.println(result);
        System.out.println(map);

        // boolean containsKey(Object key)：判断集合是否包含指定的键
        System.out.println(map.containsKey("001"));

        // boolean containsValue(Object value)：判断集合是否包含指定的值
        System.out.println(map.containsValue("张三"));

        // boolean isEmpty()：判断集合是否为空
        System.out.println(map.isEmpty());

        // int size()：返回集合中的键值对的对数
        System.out.println(map.size());

        // void clear()：移除所有的键值对
        map.clear();
        System.out.println(map);
    }
}
