package edu.gdut;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //GB（初期）->GBK（包含了台日韩的汉字，以及英文字符），两个字节表示一个汉字，高位字节在前，低位字节在后，且高字节的最高位为1
        //ASCII码（欧美英文字符）：一个字节，一个字节的存储，一个字节的读取
        //Unicode码（包含了全球所有的字符）----（采取UTF-8编码规则，unicode transfer fomat）----》英文一个字符一个字节，中文三个字节

        //为什么会乱码？
        //1.因为字节流读取的时候，是按照字节来读取的，而不是按照字符来读取的
        //所以如果读取的时候，字节流读取的字节不是一个完整的汉字字符，那么就会出现乱码
        //2.解码和编码的方法不一样
        //解决办法：
        // 1.不要用字节流读取文本文件，用字符流读取文本文件
        // 2.解码和编码使用同一个码表，同一个编码规则


        //JAVA中的编码方法：
        // 1.字符串-->字节数组：getBytes() 使用平台默认的字符集
        // 2.字符串-->字节数组：getBytes(String charsetName) 使用指定的字符集

        String str = "ai你哟";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        //JAVA中的解码方法：
        // 1.字节数组-->字符串：new String(byte[] bytes) 使用平台默认的字符集
        // 2.字节数组-->字符串：new String(byte[] bytes,String charsetName) 使用指定的字符集

        String str2 = new String(bytes);
        System.out.println(str2);

        String str3 = new String(bytes2,"GBK");
        System.out.println(str3);
    }
}
