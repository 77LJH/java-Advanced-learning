package edu.gdut.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Luffy
 */
public class Test2 {
    public static void main(String[] args) {

        ArrayList<String> boylist = new ArrayList<>();
        ArrayList<String> girlist = new ArrayList<>();
        //男女概率为7:3
        Collections.addAll(boylist, "张吉惟", "林国瑞", "江奕云", "刘柏宏", "阮建安", "夏志豪", "雷进宝");
        Collections.addAll(girlist, "刘姿婷", "王美珠", "李雅惠");

        //打乱list集合的顺序
        Random random = new Random();
        while(true) {
            int index=random.nextInt(10);
            //男
            if(index<7) {
                int boyindex = random.nextInt(boylist.size());
                System.out.println(boylist.get(boyindex)+ "(男)");
            }else {//女
                int girlindex = random.nextInt(girlist.size());
                System.out.println(girlist.get(girlindex)+ "(女)");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
