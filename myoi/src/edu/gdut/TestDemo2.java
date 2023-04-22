package edu.gdut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDemo2 {
    public static void main(String[] args) throws IOException {
        //十进制：100异或10=110 110异或10=100

        //加密文件
        FileInputStream fis=new FileInputStream("myoi/img.png");
        //file.getName()获取文件名
        FileOutputStream fos =new FileOutputStream("myoi/imgtemp.png");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            // 在这里对数据进行加密处理
            for (int i = 0; i < length; i++) {
                buffer[i] = (byte) (buffer[i] ^ 2);
            }
            fos.write(buffer, 0, length);
        }
        //解密文件
        fos.close();
        fis.close();
    }
}
