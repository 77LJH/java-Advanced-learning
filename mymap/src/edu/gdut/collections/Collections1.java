package edu.gdut.collections;

import java.util.ArrayList;
import java.util.Collections;

public class Collections1 {
    public static void main(String[] args) {
        //Collections是集合工具类，它的方法有：
        //public static <T> boolean addAll(Collection<T> c,T... elements)：批量往集合中添加一些元素
        //public static void shuffle(List<?> list)：打乱list集合的顺序
        //public static <T> void sort(List<T> list)：将集合中的元素按照默认规则排序
        //public static <T> int binarySearch(List<?> list,T key)：二分查找法
        //public static <T> T max(Collection<?> coll)：最大值
        //public static void reverse(List<?> list)：反转
        //public static void swap(List<?> list,int i,int j)：交换两个索引位置的元素
        //public static <T> void fill(List<? super T> list,T obj)：用指定的元素填充集合中的所有元素
        //public static <T> boolean replaceAll(List<T> list,T oldVal,T newVal)：用新值替换集合中所有的旧值
        //public static <T> void copy
        ArrayList<String> list=new ArrayList<>();

        //批量添加，只能给单列集合使用
        Collections.addAll(list,"abc","ada","dada","adad","ada");
        System.out.println(list);

        //打乱list集合的顺序
        Collections.shuffle(list);
        System.out.println(list);
    }
}
