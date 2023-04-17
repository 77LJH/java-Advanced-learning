package edu.gdut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌,15","赵敏,16","周芷若,17","张三丰,18","张翠山,19","张三,20");

        Student[] students1 = list.stream().map(s -> new Student(s.split(",")[0], Integer.parseInt(s.split(",")[1]))).toArray(Student[]::new);
        System.out.println(Arrays.toString(students1));
        System.out.println("=====================================");

        //引用构造方法,需要在Student类中重载构造方法,否则会报错
        //引用数组构造方法，流中的元素类型必须与数组元素类型一致，所以先用map转换一下
        Student[] students2 = list.stream().map(Student::new).toArray(Student[]::new);
        System.out.println(Arrays.toString(students2));
        System.out.println("=====================================");

        ArrayList<Student> list1 = new ArrayList<>();
        Collections.addAll(list1,students1);
        //使用类名引用成员方法
        //格式：类名::成员方法名
        //抽象方法的形参详解
        //第一个形参：被引用方法的调用者，在stream流中，就是当前元素，决定了可以用哪个类的方法
        //第二个形参到最后一个形参：跟被引用方法的参数保持一致，如果没有，就说明被引用方法必须是无参的成员方法
        String[] strings = list1.stream().map(Student::getName).filter(new TestDemo1()::method).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
        System.out.println("=====================================");

        String[] strings1 = list1.stream().map(new TestDemo1()::method1).toArray(String[]::new);
        System.out.println(Arrays.toString(strings1));
    }

    public boolean method(String s){
        return s.startsWith("张") && s.length()==3;
    }

    public String method1(Student s){
        return s.getName()+"-"+s.getAge();
    }
}
