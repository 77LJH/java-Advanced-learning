package edu.gdut.treemap04;

import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * @author Luffy
 */
public class TreeMap3 {
    public static void main(String[] args) {
        //如果题目中没有要求对结果进行排序，默认使用hashmao
        //如果题目中要求对结果进行排序，使用treemao
        String str="aababcabcdabcde";
        TreeMap<Character,Integer> tm =new TreeMap<Character, Integer>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(tm.containsKey(ch)){
                tm.put(ch,tm.get(ch)+1);
            }else {
                tm.put(ch,1);
            }
        }
        tm.forEach((key,value)->{
            System.out.println(key+" = "+value);
        });

        StringBuilder sb=new StringBuilder();
        tm.forEach((key,value)->{
            sb.append(key).append("(").append(value).append(")");
        });
        System.out.println(sb.toString());

        StringJoiner sj=new StringJoiner("","","");
        tm.forEach((key,value)->{
            sj.add(key+"").add("(").add(value+"").add(")");
        });
        System.out.println(sj.toString());
    }
}
