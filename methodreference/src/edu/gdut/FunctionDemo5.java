package edu.gdut;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class FunctionDemo5 {
    public static void main(String[] args) {
        //引用数组的构造方法
        //数据类型[]::new
        //int[]::new

        //数组的类型必须跟流中的元素类型一致

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);

        Integer[] integers = list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(integers));

        Integer[] integers1 = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers1));


        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"张三丰","张翠山","张无忌","赵敏","周芷若","张三");

        String[] strings = list1.stream().filter(s -> s.startsWith("张")).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));


    }
}
