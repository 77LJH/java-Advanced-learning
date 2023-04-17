package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo3 {
    public static void main(String[] args) {
        //引用构造方法
        //类名::new
        //引用处需要时函数式接口
        //被引用的方法需要已经存在，且满足当前的要求
        //函数式接口中的抽象方法的参数列表与返回值类型与引用的方法的参数列表与返回值类型一致

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌,15","赵敏,16","周芷若,17","张三丰,18","张翠山,19","张三,20");

        List<Student> collect3 = list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                return new Student(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
            }
        }).collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println("=====================================");

        //lambda表达式
        List<Student> collect1 = list.stream().map(s -> new Student(s.split(",")[0], Integer.parseInt(s.split(",")[1]))).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("=====================================");

        //引用构造方法
        //需要在Student类中重载构造方法
        List<Student> collect2 = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
