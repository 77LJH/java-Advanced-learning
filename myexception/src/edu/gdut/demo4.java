package edu.gdut;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        //抛出：throw，告诉调用者，我这里出现了问题，你来处理
        //捕获：catch，用于调用处，捕获异常，不让程序终止
        while (true){
            try{
                test();
                break;
            }catch (NumberFormatException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void test(){
        System.out.println("请输入女朋友的名字");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.length() > 3 && name.length() <10){
            throw new NumberFormatException(name+"名字长度不合适");
        }
        System.out.println("请输入女朋友的年龄");
        String agestr=sc.nextLine();
        //判断是否为全数字
        if (!agestr.matches("\\d+")){
            throw new NumberFormatException(agestr+"年龄必须是数字");
        }
        int age = Integer.parseInt(agestr);
        if (age < 18 || age > 30){
            throw new NumberFormatException(age+"年龄不合适");
        }
    }
}
