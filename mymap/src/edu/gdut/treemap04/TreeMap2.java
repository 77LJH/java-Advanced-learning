package edu.gdut.treemap04;

import java.util.TreeMap;

/**
 * @author Luffy
 */
public class TreeMap2 {
    public static void main(String[] args) {
        // 键：学生对象
        // 值： 籍贯
        //按年龄升序，其次名字，都一样的默认为一个人

        TreeMap<Student,String> tm=new TreeMap<>();

        tm.put(new Student("luffy", 18), "beijing");
        tm.put(new Student("nami", 22), "shenzhen");
        tm.put(new Student("chopper", 22), "wuhan");
        tm.put(new Student("sanji", 20), "guangzhou");
        tm.put(new Student("robin", 23), "xian");
        tm.put(new Student("zoro", 20), "shanghai");

        System.out.println(tm);
        tm.forEach((key,value)->{
            System.out.println(key+" = "+value);
        });

    }
}
