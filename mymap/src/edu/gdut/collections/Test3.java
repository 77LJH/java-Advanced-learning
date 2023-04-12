package edu.gdut.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Luffy
 */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张吉惟", "林国瑞", "江奕云", "刘柏宏", "阮建安",
                "夏志豪", "雷进宝", "刘姿婷", "王美珠", "李雅惠");

        Random random = new Random();
        int times=list.size();
        for(int i=0;i< times;i++) {
            int index = random.nextInt(list.size());
            String name = list.remove(index);
            System.out.println(name);
        }
    }
}
