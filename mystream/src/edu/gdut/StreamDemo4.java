package edu.gdut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        //Stream流的终结操作
        //forEach 遍历
        //count 计算个数
        //toArray 把流中的元素存储到数组中
        //collect 把流中的元素收集到集合中
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张三丰", "赵敏", "周芷若", "张强");

        //forEach 遍历
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        //count 计算个数
        long count = list.stream().filter(s -> s.startsWith("张") && s.length() == 3).count();
        System.out.println(count);

        //toArray 把流中的元素存储到数组中
        Object[] objects = list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).toArray();
        System.out.println(Arrays.toString(objects));
        //toArray(IntFunction<A[]> generator) 传递一个IntFunction接口的实现类
        //IntFunction接口中的方法是R apply(int value) 传递一个int类型的参数，创建一个指定类型的数组
        //toArray方法会把流中的元素存储到数组中
        String[] strings1 = list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) { //value是数组的长度
                return new String[value]; //创建一个长度为value的String数组
            }
        });
        System.out.println(Arrays.toString(strings1));
        String[] strings = list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
        String[] strings2 = list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .toArray(value -> new String[value]);
        System.out.println(Arrays.toString(strings2));

        //collect 把流中的元素收集到集合中
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).collect(Collectors.toList());


    }
}
