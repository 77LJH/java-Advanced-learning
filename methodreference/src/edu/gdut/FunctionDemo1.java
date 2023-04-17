package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo1 {
    public static void main(String[] args) {
        //方法引用：
        //引用处需要时函数式接口
        //被引用的方法需要已经存在，且满足当前的要求
        //函数式接口中的抽象方法的参数列表与返回值类型与引用的方法的参数列表与返回值类型一致

        //引用类中的静态方法
        //类名::静态方法名
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        ArrayList<Integer> list1 = new ArrayList<>();
        list.forEach(s-> list1.add(Integer.parseInt(s)));
        System.out.println(list1);

        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }
}
