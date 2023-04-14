package edu.gdut.map01;

import java.util.*;

public class Case1 {
    public static void main(String[] args) {
        //键是省份名，值是省份下面5个的城市
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"南京市","扬州市","徐州市","连云港市","南通市");
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"杭州市","宁波市","温州市","嘉兴市","湖州市");
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3,"广州市","深圳市","珠海市","汕头市","佛山市");
        ArrayList<String> list4 = new ArrayList<>();
        Collections.addAll(list4,"成都市","绵阳市","德阳市");

        map.put("江苏省",list1);
        map.put("浙江省",list2);
        map.put("广东省",list3);
        map.put("四川省",list4);

        map.forEach((k,v)->{
            StringJoiner sj = new StringJoiner(", "," "," ");
            for(String s:v) {
                sj.add(s);
            }
            System.out.println(k+":"+sj.toString());
        });
    }
}
