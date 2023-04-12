package edu.gdut.collections;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Luffy
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //添加十个好听的中文名字
        Collections.addAll(list, "张三", "李四", "王五", "赵六", "孙七", "周八", "吴九", "郑十", "钱十一", "孙十二");

        //打乱list集合的顺序
        Collections.shuffle(list);
        System.out.println(list);

        //打乱list集合的顺序
        Random random = new Random();
        while(true) {
            int index = random.nextInt(list.size());
            System.out.println(list.get(index));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
