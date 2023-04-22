package edu.gdut;

import java.io.*;
import java.lang.annotation.Target;

public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        //代码中使用了相对路径代替了硬编码路径，可以提高代码的可移植性
        File srcFile = new File("myoi\\a");
        File destFile = new File("myoi\\b");
        copyDir(srcFile, destFile);
    }

    public static void copyDir(File srcFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.mkdirs();
        }
        File[] files = srcFile.listFiles();
        if (files==null) {
            return;
        }
        for (File file : files) {
            if(file.isFile()){
                FileInputStream fis=new FileInputStream(file);
                //file.getName()获取文件名
                FileOutputStream fos =new FileOutputStream(destFile+"\\"+file.getName());
                byte[] bytes=new byte[1024];
                int len=0;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }else{
                copyDir(file,new File(destFile+"\\"+file.getName()));
            }
        }
    }


}
