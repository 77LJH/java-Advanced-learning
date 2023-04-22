package edu.gdut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //字符输入流FileReader
        //读取方式：
        //1.一个一个字符读取   read() 返回值是int类型，如果读到文件末尾，返回-1
        //2.一个一个字符数组读取  read(char[] c) 返回值是int类型，表示读取到的有效字符个数，如果读取到文件末尾，返回-1

        FileReader fr = new FileReader("myoi\\test.txt");
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();

        FileReader fr2 = new FileReader("myoi\\test.txt");
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fr2.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        fr2.close();
    }
}
