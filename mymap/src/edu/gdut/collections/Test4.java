package edu.gdut.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Luffy
 */
public class Test4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //每次进入文件，指针都会从头开始
        try {
            //fileReader是字符流，只能读取文本文件，不能读取图片、视频、音频等文件
            FileReader fileReader = new FileReader("D:\\Java_project\\java-Advanced learning\\mymap\\src\\edu\\gdut\\collections\\name.txt");
            //FileReader fileReader = new FileReader("D:\\test.txt");
            //2.读取数据
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                   list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        StringBuilder sb=new StringBuilder();


        Random random = new Random();
        for(int i=0;i<20;i++){
            System.out.println("第"+(i+1)+"次随机点名");
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
            System.out.println("index="+index+"     抽中的学生是"+list.get(index));
            sb.append(list.get(index)).append("  ");

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
        System.out.println(sb);
    }
}
