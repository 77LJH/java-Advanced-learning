package edu.gdut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //字节输出流FileOutputStream

        //1.创建字节输出流对象
        //  细节：1.创建字节输出流对象时，如果文件不存在，会自动创建，但要保证父目录存在
        //       2.参数是一个字符串表示的文件路径或者是File对象
        //       3.创建字节输出流对象时，如果文件存在，可以在构造方法中传入true，表示在文件末尾追加
        //       4.创建字节输出流对象时，如果文件存在，可以在构造方法中传入false，表示覆盖，默认就是false
        //2.写入数据
        //  细节：1.写入数据时，如果参数是整数，那实际上写到本地文件中的是该整数对应的ASCII码字符
        //       2.写入数据时，如果文件存在，可以在构造方法中传入true，表示在文件末尾追加
        //       3.写入数据时，如果文件存在，可以在构造方法中传入false，表示覆盖，默认就是false
        //3.关闭流，释放资源
        FileOutputStream fos=new FileOutputStream("myoi\\test.txt",true);
        //写入一个字符串
        fos.write("\n97嘿嘿嘿".getBytes());
        //写入一个字节
        fos.write(97);
        //写入一个字节数组
        byte[] bytes={98,99,100,101,102,103};
        fos.write(bytes);
        //写入一个字节数组的一部分，参数1：字节数组，参数2：从哪个索引开始，参数3：写几个
        fos.write(bytes,1,3);
        //关闭流,释放资源
        fos.close();

    }
}
