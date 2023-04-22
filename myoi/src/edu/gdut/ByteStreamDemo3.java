package edu.gdut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //字节输入流FileInputStream,字节输出流FileOutputStream,复制文件
        FileInputStream fis = new FileInputStream("myoi\\test.txt");
        FileOutputStream fos = new FileOutputStream("myoi\\src\\copy.txt");
        //得到拷贝的时间
        Time time = new Time(System.currentTimeMillis());
        int a;
        while((a=fis.read())!=-1){
            //速度慢，写的是二进制，所以不会出现乱码
            fos.write(a);
        }
        Time time2 = new Time(System.currentTimeMillis());
        //输出时间差
        System.out.println(time2.getTime()-time.getTime());
        fos.close();
        fis.close();

        //使用字节数组
        FileInputStream fis2 = new FileInputStream("myoi\\test.txt");
        FileOutputStream fos2 = new FileOutputStream("myoi\\src\\copy2.txt");
        Time time3 = new Time(System.currentTimeMillis());
        byte[] bytes = new byte[1024];
        int len;
        while((len=fis2.read(bytes))!=-1){
            //速度快，如果是fos.write(bytes),那么会把数组中的空白或者是之前的遗留部分也会被写入
            fos2.write(bytes,0,len);
        }
        Time time4 = new Time(System.currentTimeMillis());
        System.out.println(time4.getTime()-time3.getTime());
    }
}
