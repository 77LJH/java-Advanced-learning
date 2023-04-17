package edu.gdut;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImmutableMap2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        //添加11个元素，以<a,aa>为例
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");
        map.put("e", "ee");
        map.put("f", "ff");
        map.put("g", "gg");
        map.put("h", "hh");
        map.put("i", "ii");
        map.put("j", "jj");
        map.put("k", "kk");

        Set<Map.Entry<String,String>> set = map.entrySet();

        //0的意思是从第0个元素开始，set.toArray(new Map.Entry[0])的意思是把set转换成Map.Entry类型的数组
        //toArray方法在底层会比较set的长度和数组的长度，如果set的长度大于数组的长度，就会创建一个新的数组,否则直接使用数组
        //这里set长度为11，数组长度为0，所以会创建一个长度为11的数组
        //int[] a=new int[0];
        //不可变的Map
        Map<String, String> map2 = Map.ofEntries(set.toArray(new Map.Entry[0]));
        System.out.println(map2);
        try {
            map2.put("l", "ll");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" put");
        }

        Map<String, String> map3 = Map.copyOf(map);
        System.out.println(map3);
        try {
            map3.put("l", "ll");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e+" put");
        }
    }
}
