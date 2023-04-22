package edu.gdut;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("myoi\\test.txt", true);
        fw.write("\n98哈哈哈wewew");
        fw.write(100);
        char[] chars = {99, 100, 101, 102, 103};
        fw.write(chars);
        fw.write(chars, 1, 3);
        fw.close();
    }
}
