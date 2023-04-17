package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //Stream流的中间操作
        //1.filter 过滤  过滤掉不符合条件的元素  Stream<T> filter(Predicate<? super T> predicate)
        //2.map 映射  将一个流中的元素映射到另一个流中，转换数据类型  <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        //3.limit 限制  取前几个   Stream<T> limit(long maxSize)
        //4.skip 跳过  跳过前几个  Stream<T> skip(long n)
        //5.sorted 排序  自然排序  Comparable接口  Stream<T> sorted()
        //6.distinct 去重  通过hashCode和equals方法去重  Stream<T> distinct()
        //7.concat 连接  将两个流连接成一个流,尽可能是两种类型相同的流  Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)

        //注意点1：Stream流只能使用一次，使用完毕就会关闭，不能再使用，建议链式编程
        //注意点2：修改strea流中的元素，不会影响原来的集合中的元素

        //1.filter 过滤  过滤掉不符合条件的元素  Stream<T> filter(Predicate<? super T> predicate)
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张三丰", "赵敏", "周芷若", "张强", "赵小面", "赵小花", "张强");

        //好像涉及到函数式方法并用到了匿名写法的都是一次性的，不会再用到的
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //如果返回true，就会把这个元素添加到新的流中
                //如果返回false，就会过滤掉这个元素
                return s.startsWith("张");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("=====================================");
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        System.out.println("=====================================");

        list.stream().skip(2).forEach(s -> System.out.println(s));
        System.out.println("=====================================");
        list.stream().limit(2).forEach(s -> System.out.println(s));
        System.out.println("=====================================");
        list.stream().skip(2).limit(2).forEach(s -> System.out.println(s));
        System.out.println("=====================================");

        list.stream().distinct().forEach(s -> System.out.println(s));
        System.out.println("=====================================");

        Stream.concat(list.stream().filter(s -> s.startsWith("张")), list.stream().filter(s -> s.startsWith("赵"))).forEach(s -> System.out.println(s));
        System.out.println("=====================================");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,  "周芷若-18", "张强-19", "张无忌-15", "赵小面-20", "赵小花-21", "张三丰-16", "赵敏-17", "张强-19");
        list2.stream().map(s -> {
            String[] split = s.split("-");
            return new Person(split[0], Integer.parseInt(split[1]));
        }).distinct().forEach(p -> System.out.println(p));
        // 这里distinct()通过hashCode和equals方法去重，如果Person类中没有重写hashCode和equals方法，去重不起作用，
        // 因为Person类中的hashCode和equals方法是从Object类中继承过来的，Object类中的hashCode和equals方法是比较对象的地址值，所以去重不起作用
    }
}
