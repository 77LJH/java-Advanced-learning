package edu.gdut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //stream流的使用方法：
        //1.先得到stream流对象
        //   1.1  单列集合对象.stream()   Collection中的默认方法：collection.stream()   Map（无法直接使用）中的默认方法：map.entrySet().stream()
        //   1.2  数组 Arrays中的静态方法：Arrays.stream(数组对象)
        //   1.3  Stream.of(元素1，元素2，元素3)  Stream中的静态方法：Stream.of(元素1，元素2，元素3...)  需要同种数据类型

        //2.利用API对stream流对象进行各种操作
        //  中间操作：filter，map，limit，skip，sorted，distinct
        //  终结操作：forEach，count，max，min，findFirst，findAny

        //1.单列集合对象.stream()
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张三丰", "赵敏", "周芷若", "张强", "赵小面", "赵小花");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        //用&&连接两个过滤条件，效率更高
        list.stream().filter(s -> s.startsWith("张") && s.length() == 3).forEach(s -> System.out.println(s));

        //2.数组对象.stream()
        System.out.println("=====================================");
        String[] arr = {"张无忌", "张三丰", "赵敏", "周芷若", "张强", "赵小面", "赵小花"};
        Arrays.stream(arr).filter(s->s.startsWith("赵") && s.length()==2).forEach(s->System.out.println(s));

        //3.Stream.of(元素1，元素2，元素3)
        System.out.println("=====================================");
        Stream.of("张无忌", "张三丰", "赵敏", "周芷若", "张强", "赵小面", "赵小花").filter(s->s.startsWith("张") && s.length()==2).forEach(s->System.out.println(s));

        //4.Map(不能直接使用)中的默认方法：map.entrySet().stream()
        //注意：方法的形参是一个可变参数，所以可以传入一个数组，也可以传入多个元素
        //但是数组必须是引用数据类型的数组，不能是基本数据类型的数组，如果是基本数据类型的数组，是会把整个数组当成一个元素，可以使用包装类的数组
        System.out.println("=====================================");
        HashMap<String, String> map = new HashMap<>(new HashMap<String, String>() {{
            put("张无忌", "1");
            put("张三丰", "2");
            put("赵敏", "3");
            put("周芷若", "4");
            put("张强", "5");
        }});
        map.entrySet().stream().filter(s->s.getKey().startsWith("周")).forEach(s->System.out.println(s));
    }
}
