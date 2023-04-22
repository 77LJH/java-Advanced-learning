package edu.gdut;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        //文本文件里有2-1-9-4-7-8
        //对文本文件进行排序
        //1.读取文本文件里的内容
        //2.将读取到的内容按照-进行分割
        //3.将分割后的内容进行排序
        //4.将排序后的内容写入到文本文件里

        //1.读取文本文件里的内容
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader("myoi/num.txt");
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }
        fr.close();

        //2.将读取到的内容按照-进行分割
        String[] str = sb.toString().split("-");
        Integer[] list = Stream.of(sb.toString().split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        //4.将排序后的内容写到stringBuilder里
        StringJoiner sj = new StringJoiner("-");
        for (Integer integer : list) {
            sj.add(integer.toString());
        }

        //5.将排序后的内容写入到文本文件里
        FileWriter fw = new FileWriter("myoi/num.txt");
        fw.write(sj.toString());
        fw.close();
    }
}
