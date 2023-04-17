package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张国荣,50", "周杰,45", "吴凡,40", "王宝强,35", "吴京,30" ,"易烊千玺,25");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "孙俪,30", "唐艺昕,25", "杨梅婷,30", "杨萱萱,35", "蔡少芬,30" ,"李嘉欣,25");

        //男演员只要名字为3个字的前两个
        List<String> list3 = list1.stream()
                .filter(s -> s.split(",")[0].length()==3)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("男演员只要名字为3个字的前两个: "+list3);

        //女演员只要姓杨的，并且不要第一个
        List<String> list4 = list2.stream()
                .filter(s-> s.split(",")[0].startsWith("杨"))
                .skip(1)
                .collect(Collectors.toList());
        System.out.println("女演员只要姓杨的，并且不要第一个: "+list4);

        //把两个集合中的演员姓名合并到一个集合中
        Stream<String> stream1 = list3. stream().map(s -> s.split(",")[0]);
        Stream<String> stream2 = list4. stream().map(s -> s.split(",")[0]);
        List<String> list5 = Stream.concat(stream1, stream2).collect(Collectors.toList());
        System.out.println("把上面两个集合中的演员姓名合并到一个集合中: "+list5);

        //把上一步操作后的元素进行合并，姓名和年龄拼接到一起
        Stream<Person> stream3 = list3.stream().map(s -> {
            String[] split = s.split(",");
            return new Person(split[0], Integer.parseInt(split[1]));
        });
        Stream<Person> stream4=list4.stream().map(s -> {
            String[] split = s.split(",");
            return new Person(split[0], Integer.parseInt(split[1]));
        });
        List<Person> list8 = Stream.concat(stream3, stream4).collect(Collectors.toList());
        System.out.println("把上一步操作后的元素进行合并，姓名和年龄拼接到一起: "+list8);
    }
}
