package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class FunctionDemo2 {
    public static void main(String[] args) {
        //引用处需要时函数式接口
        //被引用的方法需要已经存在，且满足当前的要求
        //函数式接口中的抽象方法的参数列表与返回值类型与引用的方法的参数列表与返回值类型一致

        //引用成员方法：
        // 实例对象::成员方法
        //1.其他类：其他类对象::方法名
        //2.本类：this::方法名  引用处不能是静态方法
        //3.父类：super::方法名  引用处不能是静态方法

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","赵敏","周芷若","张三丰","张翠山","张三");

        list.stream().filter(s->s.startsWith("张") && s.length()==3).forEach(System.out::println);
        System.out.println("=====================================");

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length()==3;
            }
        }).forEach(System.out::println);
        System.out.println("=====================================");

        list.stream().filter(new FunctionDemo2()::method).forEach(System.out::println);
        System.out.println("=====================================");
    }

    public boolean method(String s){
        return s.startsWith("张") && s.length()==3;
    }
}
