package edu.gdut;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        //public boolean delete() 删除由此File表示的文件或目录，如果是目录，必须是空目录才能删除
        //创建文件
        File file = new File("D:\\Java_project\\java-Advanced learning\\myfile\\a.txt");
        file.createNewFile();

        File file1 = new File("D:\\Java_project\\java-Advanced learning\\myfile");
        File[] files1 = file1.listFiles(f -> f.isFile() && f.getName().endsWith(".txt"));
        for (File file2 : files1) {
            System.out.println(file2);
        }
        System.out.println("=====================================");

//        File[] files = file.listFiles(f -> f.isFile() && f.getName().endsWith(".pdf"));
//        for (File file2 : files) {
//            System.out.println(file2);
//        }
//        System.out.println("=====================================");

        //统计文件夹中文件的个数
        HashMap<String,Integer> map = new HashMap<>();
        count(file1,map);
        map.forEach((k,v)-> System.out.println(k+"="+v));
        System.out.println("=====================================");
    }

    //统计
    public static void count(File file, HashMap<String,Integer> map) {
        //递归结束条件
        File [] files = file.listFiles();
        //如果调用者是要有权限才能进入的文件夹时，files为null
        if(files == null) {
            return;
        }
        for(File file2:files) {
            if(file2.isFile()){
                String fileTypeName = file2.getName().split("\\.")[1];
                if(map.containsKey(fileTypeName)) {
                    map.put(fileTypeName, map.get(fileTypeName)+1);
                }else {
                    map.put(fileTypeName, 1);
                }
            }else{
                count(file2,map);
            }
        }
    }

    public static void deleteAll(File file){
        //递归结束条件
        File [] files = file.listFiles();
        //如果调用者是要有权限才能进入的文件夹时，files为null
        if(files == null) {
            return;
        }
        for(File file2:files) {
            if(file2.isDirectory()) {
                deleteAll(file2);
            }else {
                file2.delete();
            }
        }
        file.delete();
    }

    private static void findAllTxtFile() {
        File[] files=File.listRoots();
        for(File file2:files) {
            findtxtFile(file2);
        }
    }

    public static void findtxtFile(File file) {
        //递归结束条件
        File [] files = file.listFiles();
        //如果调用者是要有权限才能进入的文件夹时，files为null
        if(files == null) {
            return;
        }
        for(File file2:files) {
            if(file2.isFile()){
                if(file2.getName().endsWith(".txt")) {
                    System.out.println(file2);
                }
            }else{
                findtxtFile(file2);
            }
        }
    }
}
