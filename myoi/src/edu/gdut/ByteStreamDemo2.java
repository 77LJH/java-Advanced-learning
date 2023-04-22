package edu.gdut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //字节输入流FileInputStream
        //读取方式：
        //1.读取一个字节  read()  返回值是int类型，如果读取到文件末尾，返回-1
        //2.读取一个字节数组  read(byte[] b)  返回值是int类型，表示读取到的有效字节个数，如果读取到文件末尾，返回-1

        FileInputStream fis =new FileInputStream("myoi\\test.txt");
        //读取一个字节
        int b=fis.read();
        System.out.println(b);
        System.out.println((char)b);
        //读取一个字节数组
        byte[] bytes=new byte[1024];
        int len=fis.read(bytes);
        System.out.println(new String(bytes,0,len ));
        //关闭流，释放资源
        fis.close();

        System.out.println("=====================================");
        FileInputStream fis2 =new FileInputStream("myoi\\test.txt");
        int b2;
        while((b2=fis2.read())!=-1){
            System.out.print((char)b2);
        }
        fis2.close();

        //GB（初期）->GBK（包含了台日韩的汉字，以及英文字符），两个字节表示一个汉字，高位字节在前，低位字节在后，且高字节的最高位为1
        //ASCII码（欧美英文字符）：一个字节，一个字节的存储，一个字节的读取
        //Unicode码（包含了全球所有的字符）----（采取UTF-8编码规则，unicode transfer fomat）----》英文一个字符一个字节，中文三个字节

        //为什么会乱码？
        //1.因为字节流读取的时候，是按照字节来读取的，而不是按照字符来读取的
        //所以如果读取的时候，字节流读取的字节不是一个完整的字符，那么就会出现乱码
        //2.解码和编码的方法不一样
        //解决办法：
        // 1.不要用字节流读取文本文件，用字符流读取文本文件
        // 2.解码和编码使用同一个码表，同一个编码规则
    }
}
