package edu.gdut;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo5 {
    public static void main(String[] args) {
        //collect 把流中的元素收集到集合List,Set,Map
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,  "周芷若-女-18", "赵敏-女-17", "张无忌-男-16", "张三丰-男-100", "张强-男-20","赵敏-女-17");

        //需求：把男性的名字存储到一个list集合中
        List<String> collect=list2.stream().filter(s-> "男".equals(s.split("-")[1])).collect(Collectors.toList());
        System.out.println(collect);

        //需求：把女性的名字存储到一个set集合中，可以去重
        Set<String> collect1=list2.stream().filter(s-> "女".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(collect1);

        //需求：把男性的名字存储到一个map集合中，key是名字，value是年龄
        Map<String, Integer> collect2 = list2.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(collect2);

        //需求：把女性的名字存储到一个map集合中，key是名字，value是年龄
        // 如果有重复的key，会抛出异常，可以使用重载方法，第三个参数是一个函数式接口，可以自定义处理重复的key
        //第三个参数是怎么处理重复的key的：如果有重复的key，会把第一个key对应的value覆盖掉，保留第二个key对应的value
        //Map<String, Integer> collect3 = list2.stream().filter(s -> "女".equals(s.split("-")[1])).collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        Map<String, Integer> collect4 = list2.stream().filter(s -> "女".equals(s.split("-")[1])).collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2]),(s1,s2)->s2));
        System.out.println(collect4);

        //方法重载（overload）
        //方法的重载是指一个类中可以定义有相同的名字，但参数不同的多个方法。调用时，会根据不同的参数表选择对应的方法。
        //两同三不同：
        //——同一个类，同一个方法名。
        //——不同：参数列表不同。（类型，个数，顺序不同）
        //只有返回值不同不构成方法重载。
        //只有形参的名称不同，不构成方法重载。
        //与普通方法一样，构造函数也可以重载。

        //什么是匿名内部类
        //匿名内部类是一个没有名字的类，是一个类的子类或者实现类
        //匿名内部类的格式：new 父类或者接口(){重写方法}
        //匿名内部类的应用场景：当一个类只需要使用一次的时候，可以使用匿名内部类

        //什么是函数式接口：接口中只有一个抽象方法的接口
        //什么是lambda表达式：是一个匿名函数，可以理解为是一个没有名字的方法
        //lambda表达式的格式：(参数列表)->{方法体}
        //lambda表达式的参数列表：可以有多个参数，也可以没有参数，如果有多个参数，参数之间用逗号隔开
        //lambda表达式的方法体：可以有多条语句，也可以只有一条语句，如果只有一条语句，可以省略大括号
        //lambda表达式的返回值：如果方法体中只有一条语句，那么这条语句的返回值就是lambda表达式的返回值
        //lambda表达式的参数类型：可以省略参数类型，如果省略参数类型，那么编译器会根据上下文推断出参数类型


    }
}
