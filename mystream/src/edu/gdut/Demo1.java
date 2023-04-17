package edu.gdut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        //定义一个集合，存储多个整数，筛选出偶数，存储到新集合中
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> ovenList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(ovenList);

        //定义一个集合，存储多个字符串，筛选出年龄大于24的人，存储到新集合中
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "zhangsan,29", "lisi,24", "wangwu,23", "zhaoliu,22", "tianqi,27");
        Map<String, Integer> collect1 = list2.stream()
                //过滤出年龄大于24的人
                .filter(s -> Integer.parseInt(s.split(",")[1]) > 24)
                //将过滤后的结果转换为map集合
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1]), (s1, s2) -> s2));
        System.out.println(collect1);
    }
}
