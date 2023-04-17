package edu.gdut;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo2 {
    public static void main(String[] args) throws ParseException {
        //常见的成员方法：
        //public boolean isDirectory() 判断是否是文件夹
        //public boolean isFile() 判断是否是文件
        //public boolean exists() 判断是否存在
        //public long length() 返回由此File表示的文件的长度（字节数）,无法获取目录的大小
        //public String getAbsolutePath() 返回此File的绝对路径名字符串
        //public String getPath() 将此File转换为路径名字符串
        //public String getName() 返回由此File表示的文件或目录的名称，文件带后缀或者文件夹的名字
        //public long lastModified() 返回由此File表示的文件最后一次被修改的时间，毫秒值

        File f1 = new File("D:\\Java_project\\java-Advanced learning\\myfile\\src\\edu\\gdut\\FileDemo1.java");
        System.out.println("isFile: " + f1.isFile());
        System.out.println("isDirectory: " + f1.isDirectory());
        System.out.println("exists: " + f1.exists());

        System.out.println("=====================================");

        File f2 = new File("D:\\Java_project\\java-Advanced learning\\myfile");
        System.out.println("isFile: " + f2.isFile());
        System.out.println("isDirectory: " + f2.isDirectory());
        System.out.println("exists: " + f2.exists());
        System.out.println("=====================================");

        File f3 = new File("D:\\Java_project\\java-Advanced learning\\myfile\\src\\edu\\gdut\\FileDemo1.java");
        Long length = f3.lastModified();
        //改为年月日的格式：
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(length));
        System.out.println(date);

    }
}
