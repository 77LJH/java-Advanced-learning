package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo4 {
    public static void main(String[] args) {
        //拓展
        //使用类名引用成员方法
        //格式：类名::成员方法名
        //范例：String::equals

        //该引用方法的规则：
        //1.需要有函数式接口
        //2.被引用的方法需要已经存在，且满足当前的要求
        //3.被引用方法的形参，需要跟抽象方法的第二个形参到最后一个形参保持一致

        //局限性：
        //1.被引用的方法必须是无参的成员方法
        //跟抽象方法的第一个形参有关，这个形参是被引用方法的调用者，决定了可以用哪个类的方法

        //抽象方法的形参详解
        //第一个形参：被引用方法的调用者，在stream流中，就是当前元素，决定了可以用哪个类的方法
        //第二个形参到最后一个形参：跟被引用方法的参数保持一致，如果没有，就说明被引用方法必须是无参的成员方法

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"aaa","bbb","ccc","ddd","eee","fff");

        List<String> collect1 = list.stream().map(new Function<String, String>() {
            //该抽象方法没有第二个形参，所以被引用的方法必须是无参的成员方法
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
        System.out.println(collect1);

        List<String> collect2 = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect2);

        List<String> collect3 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect3);

    }
}
