package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StreamDemo1 {
    public static void main(String[] args) {
        /*
        * 创建集合添加元素，完成一下需求：
        * 1.把所有姓张的人的名字存储到一个新的集合中
        * 2.把所有姓张的人的名字存储到一个新的集合中，并且长度为3
        * 3.遍历
        * */
        //人名有：张无忌，张三丰，赵敏，周芷若，张强
        //创建集合
        List<String> list = new ArrayList<>();
        //添加元素
        Collections.addAll(list, "张无忌", "张三丰", "赵敏", "周芷若", "张强");

        //stream流的使用方法：
        //1.先得到stream流对象
        //   1.1  单列集合对象.stream()   Collection中的默认方法：collection.stream()   Map（无法直接使用）中的默认方法：map.entrySet().stream()
        //   1.2  数组对象.stream()   Arrays中的静态方法：Arrays.stream(数组对象)
        //   1.3  Stream.of(元素1，元素2，元素3)  Stream中的静态方法：Stream.of(元素1，元素2，元素3...)  需要同种数据类型

        //2.利用API对stream流对象进行各种操作
        //  中间操作：filter，map，limit，skip，sorted，distinct
        //  终结操作：forEach，count，max，min，findFirst，findAny

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        //用&&连接两个过滤条件，效率更高
        list.stream().filter(s -> s.startsWith("张") && s.length() == 3).forEach(s -> System.out.println(s));

//        //1.把所有姓张的人的名字存储到一个新的集合中
//        List<String> list1 = new ArrayList<>();
//        list.forEach(s -> {
//            if (s.startsWith("张")) {
//                list1.add(s);
//            }
//        });
//
//
//
//        //2.把所有姓张的人的名字存储到一个新的集合中，并且长度为3
//        List<String> list2 = new ArrayList<>();
//        list1.forEach(s -> {
//            if (s.startsWith("张") && s.length() == 3) {
//                list2.add(s);
//            }
//        });
//
//        //3.遍历
//        for (String s : list2) {
//            System.out.println(s);
//        }
    }
}
