package edu.gdut;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo3 {
    public static void main(String[] args) {
        //public boolean createNewFile() 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        //public boolean mkdir() 创建由此File表示的目录。
        //public boolean mkdirs() 创建由此File表示的目录，包括任何必需但不存在的父目录。
        //public boolean delete() 删除由此File表示的文件或目录，如果是目录，必须是空目录才能删除

        //public File[] listFiles() 返回一个抽象路径名数组，这些路径名表示此File表示的目录中的文件。
        //当调用者File表示的目录不存在时，返回null
        //当调用者File表示的是文件，返回null
        //当调用者File表示的是空目录，返回空数组
        //public String[] list() 返回一个字符串数组，这些字符串指定此File表示的目录中的所有文件和目录，包括隐藏文件。

        File file1 = new File("D:\\Java_project\\java-Advanced learning\\myfile");
        File[] files = file1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        System.out.println("=====================================");

        //public static File[] listRoots() 返回一个抽象路径名数组，表示系统中的所有根目录。
        File[] file2=File.listRoots();
        for (File file : file2) {
            System.out.println(file);
        }
        System.out.println("=====================================");

        //list()方法返回该目录下的所有文件和文件夹的名称，不包含子目录下的内容
        String[] str=file1.list();
        for (String string : str) {
            System.out.println(string);
        }
        System.out.println("=====================================");

        //list(FilenameFilter filter)方法返回该目录下的所有文件和文件夹的名称，不包含子目录下的内容
        String[] list1 = file1.list(new FilenameFilter() {
            //参数dir表示当前目录，参数name表示当前目录下的文件或文件夹名称
            //返回true表示接受，返回false表示拒绝
            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                File file = new File(dir, name);
                return file.isFile() && name.endsWith(".txt");
            }
        });
        for (String string : list1) {
            System.out.println(string);
        }
        System.out.println("=====================================");
        String[] list2 = file1.list((dir, name) -> {
            File file = new File(dir, name);
            return file.isFile() && name.endsWith(".txt");
        });
        for (String string : list2) {
            System.out.println(string);
        }
        System.out.println("=====================================");
        String[] list3 = file1.list((dir, name) -> new File(dir, name).isFile() && name.endsWith(".txt"));
        for (String string : list3) {
            System.out.println(string);
        }
        System.out.println("=====================================");
    }
}
