package edu.gdut.hashmap02;

import java.util.HashMap;

/**
 * @author Luffy
 */
public class HashMapDemo1 {
    public static void main(String[] args) {
        // HashMap是Map接口的一个实现类
        // 特点都是由键决定的：无序，不可重复，无索引
        // 没有特别的方法，直接使用Map接口中的方法
        // HashMap的底层跟HashSet一模一样是哈希表
        // 利用键的hashCode()方法来确定元素的存储位置，如果哈希值相同，就会覆盖原先的值
        // 链表长度大于8且哈希数组的长度大于64时，链表会转换为红黑树
        // 如果键存储的是自定义类型，必须重写hashCode()和equals()方法
        // 如果值存储的是自定义类型，则不需要重写hashCode()和equals()方法



        // 需求：创建一个HashMap集合，键是学生对象，值是籍贯,同年龄同姓名的视为同一个人
        HashMap<Student,String> map=new HashMap<>();

        map.put(new Student("张三",23),"北京");
        map.put(new Student("李四",24),"上海");
        map.put(new Student("王五",25),"广州");
        map.put(new Student("赵六",26),"深圳");
        // 同年龄同姓名的视为同一个人
        map.put(new Student("赵六",26),"赣州");

        map.forEach((key,value) -> System.out.println(key+" = "+value));
    }
}
