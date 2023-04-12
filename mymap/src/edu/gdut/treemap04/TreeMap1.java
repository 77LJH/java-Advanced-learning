package edu.gdut.treemap04;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Luffy
 */
public class TreeMap1 {
    public static void main(String[] args) {
        //treemap跟treeset一样，也是基于红黑树实现的
        //可对key进行排序，默认从小到大
        //代码书写两种排序规则
        //1.自然排序，key必须实现Comparable接口
        //2.比较器排序，创建集合的时候传入比较器对象

        TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1表示当前要添加的元素
                //o2表示已经红黑树已经存在的元素
                return o2-o1;
            }
        });

        map.put(12, "aaa");
        map.put(131, "baaa");
        map.put(4, "ac");
        map.put(3, "d");

        System.out.println(map);
    }
}
