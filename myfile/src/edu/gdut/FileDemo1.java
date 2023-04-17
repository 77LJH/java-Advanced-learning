package edu.gdut;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        /*
        File对象表示路径，可以是文件，也可以是文件夹，路径可以存在也可以不存在

        * public File(string pathname) 通过将给定路径名字符串转换为抽象路径名来创建新的 File 实例。
        * public File(string parent, string child) 从父路径名字符串和子路径名字符串创建新的 File 实例。
        * public File(File parent, string child) 从父抽象路径名和子路径名字符串创建新的 File 实例。
        * */

        //D:\Java_project\java-Advanced learning\myfile\test.txt
        File f1 = new File("D:\\Java_project\\java-Advanced learning\\myfile\\test.txt");
        System.out.println(f1);

        //D:\Java_project\java-Advanced learning\myfile\test.txt
        File f2 = new File("D:\\Java_project\\java-Advanced learning\\myfile", "test.txt");
        System.out.println(f2);

        //D:\Java_project\java-Advanced learning\myfile\test.txt
        File f3 = new File("D:\\Java_project\\java-Advanced learning\\myfile");
        File f4 = new File(f3, "test.txt");
        System.out.println(f4);
    }
}
