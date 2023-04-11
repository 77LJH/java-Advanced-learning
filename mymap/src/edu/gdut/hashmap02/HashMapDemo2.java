package edu.gdut.hashmap02;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Luffy
 */
public class HashMapDemo2 {
    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('B', 0);
        map.put('C', 0);
        map.put('D', 0);

        for(int i=0;i<80;i++){
            Random random = new Random();
            int i1 = random.nextInt(4);
            switch (i1){
                case 0 -> {
                    map.put('A', map.get('A')+1);
                    break;
                }
                case 1 ->{
                    map.put('B', map.get('B')+1);
                    break;
                }
                case 2->{
                    map.put('C', map.get('C')+1);
                    break;
                }
                case 3->{
                    map.put('D', map.get('D')+1);
                    break;
                }
                default -> {
                    break;
                }
            }
        }

        // 遍历map,统计最多的选项
        int max = 0;
        char maxKey = ' ';
        for (Character key : map.keySet()) {
            System.out.println(key+" = "+map.get(key));
            int value = map.get(key);
            if(value > max){
                max = value;
                maxKey = key;
            }
        }
        System.out.println("最多的选项是："+maxKey+"，共有"+max+"票");
    }
}
