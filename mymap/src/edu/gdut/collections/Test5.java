package edu.gdut.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
//        String str = "茹定、李中冰、黄文隆、谢彦文、傅智翔、洪振霞、刘姿婷、荣姿康、吕致盈、方一强、\n" +
//                "黎芸贵、郑伊雯、雷进宝、吴美隆、吴心真、王美珠、郭芳天、李雅惠、陈文婷、曹敏侑、\n" +
//                "王依婷、陈婉璇、吴美玉、蔡依婷、郑昌梦、林家纶、黄丽昆、李育泉、黄芸欢、吴韵如、\n" +
//                "李肇芬、卢木仲、李成白、方兆玉、刘翊惠、丁汉臻、吴佳瑞、舒绿珮、周白芷、张姿妤、\n" +
//                "张虹伦、周琼玟、倪怡芳、郭贵妃、杨佩芳、黄文旺、黄盛玫、郑丽青、许智云、张孟涵、\n" +
//                "李小爱、王恩龙、朱政廷、邓诗涵、陈政倩、吴俊伯、阮馨学、翁惠珠、吴思翰、林佩玲、\n" +
//                "邓海来、陈翊依、李建智、武淑芬、金雅琪、赖怡宜、黄育霖、张仪湖、王俊民、张诗刚、\n" +
//                "林慧颖、沈俊君、陈淑妤、李姿伶、高咏钰、黄彦宜、周孟儒、潘欣臻、李祯韵、叶洁启";
//
//        String[] names = str.split("、");
//        ArrayList<String> list = new ArrayList<>();
//        for (String name : names) {
//            list.add(name);
//        }
//        System.out.println(list);


//        ArrayList<String> list = new ArrayList<>();
//        Collections.addAll(list, "张吉惟", "林国瑞", "江奕云", "刘柏宏", "阮建安");
//        ArrayList<Double> pList2 = new ArrayList<>();
//        for(int i=1;i<=list.size();i++) {
//            pList2.add(i*1.0/list.size());
//        }
//        System.out.println("初始权重");
//        System.out.println(pList2);

//        Random random = new Random();
//        for(int i=0;i<2;i++){
//            System.out.println("\n第"+(i+1)+"次抽奖");
//            //随机选中一个学生
//            //int index = random.nextInt(list.size());
//            int index=1;
//            System.out.println("index="+index);
//            //学生i的概率权重为p=pList.get(i)-pList.get(i-1)   i=0时，概率权重为pList.get(0)
//            //当学生i被抽中后，其他学生的权重变化加 delta=pList2.get(i)*0.5/(list.size()-1)
//            double delta=pList2.get(i)*0.5/(list.size()-1);
//            System.out.println("delta="+delta);
//            for(int j=0;j<index;j++) {
//                pList2.set(j, pList2.get(j)+(j+1)*delta);
//            }
//            pList2.set(index, pList2.get(index-1)+delta*(list.size()-1));
//            for(int j=list.size()-2;j>index;j--) {
//                pList2.set(j, pList2.get(j)-(list.size()-2-j+1)*delta);
//            }
//            System.out.println(pList2);
//            for(int j=0;j<list.size();j++) {
//                if(j==0) {
//                    System.out.print(pList2.get(j)+"   ");
//                } else {
//                    //取消最后的换行符
//                    System.out.print(pList2.get(j)-pList2.get(j-1)+"   ");
//                }
//            }
//        }

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张吉惟", "林国瑞", "江奕云", "刘柏宏", "阮建安");

        //初始化权重数组
        ArrayList<Double> weightList2 = new ArrayList<>();
        double weight = 1.0/list.size();
        for(int i=1;i<=list.size();i++) {
            weightList2.add(weight);
        }

        //概率分布
        ArrayList<Double> pList = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            pList.add((i+1)*weight);
        }

        //抽奖
        Random random = new Random();
        for(int i=0;i<2;i++){
            System.out.println("第"+(i+1)+"次抽奖");
            System.out.println("原先的权重");
            System.out.println(weightList2);
            System.out.println("原先的概率分布");
            System.out.println(pList);

            double rd = Math.random();
            System.out.println("rd="+rd);
            //随机选中一个学生
            int index=0;
            for(int j=0;j<weightList2.size();j++){
                if(pList.get(j)>rd){
                    index=j;
                    break;
                }
            }
            System.out.println("index="+index);

            //其他的学生的权重变化加 pList2.get(i)*0.5/(list.size()-1)
            double delta=weightList2.get(index)*0.5/(list.size()-1);
            System.out.println("delta="+delta);
            for(int j=0;j<weightList2.size();j++) {
                if(j!=index){
                    weightList2.set(j, weightList2.get(j)+delta);
                }
            }
            weightList2.set(index, weightList2.get(index)/2);
            System.out.println("更新后的权重");

            System.out.println(weightList2);
            //更新概率分布
            for(int j=0;j<list.size();j++) {
                if(j==0) {
                    pList.set(j, weightList2.get(j));
                } else {
                    //取消最后的换行符
                    pList.set(j, pList.get(j-1)+weightList2.get(j));
                }
            }
            System.out.println("更新后的概率分布");
            System.out.println(pList+"\n");
        }
    }
}
