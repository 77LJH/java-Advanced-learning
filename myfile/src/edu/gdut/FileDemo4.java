package edu.gdut;

import java.io.File;
import java.io.FileFilter;

public class FileDemo4 {
    public static void main(String[] args) {
        File file1 = new File("D:\\Java_project\\java-Advanced learning\\myfile");
        File[] files = file1.listFiles();
        for (File file : files) {
            if(file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file);
            }
        }
        System.out.println("=====================================");

        //调用listFiles方法，FileNameFilter接口的实现类对象
        File[] files1 = file1.listFiles((dir, name) -> {
            File file = new File(dir, name);
            return file.isFile() && name.endsWith(".txt");
        });
        for (File file : files1) {
            System.out.println(file);
        }
        System.out.println("=====================================");

        //调用listFiles方法，FileFilter接口的实现类对象
        File[] files2 = file1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
        for (File file : files2) {
            System.out.println(file);
        }
        System.out.println("=====================================");
    }
}
