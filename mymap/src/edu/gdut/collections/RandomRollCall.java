package edu.gdut.collections;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Luffy
 */
public class RandomRollCall extends JFrame{
    JLabel goB=new JLabel();
    JLabel name=new JLabel();
    //名字列表
    ArrayList<String> list = new ArrayList<>();
    //初始化权重列表
    ArrayList<Double> weightList2 = new ArrayList<>();
    //概率分布
    ArrayList<Double> pList = new ArrayList<>();

    public RandomRollCall(){
        //初始化随机点名器，包括权重和概率分布
        initRandomGenerate();

        //直接把登录界面显示出来
        initJFrame();

        //在这个页面中添加内容
        initView();

        //设置可见，建议放在最后
        this.setVisible(true);
    }

    private void initView() {
        //添加Go
        goB.setText("Go");
        //位置与宽高
        goB.setBounds(420, 250, 100, 100);
        //添加到界面上
        this.getContentPane().add(goB);

        //添加name
        name.setText("");
        //位置与宽高
        name.setBounds(380, 150, 200, 100);
        //添加到界面上
        this.getContentPane().add(name);

        ImageIcon image = new ImageIcon("D:\\Java_project\\java-Advanced learning\\mymap\\src\\edu\\gdut\\collections\\img.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, 356, 408);
        this.getContentPane().add(label);
    }

    private void initJFrame() {
        this.setTitle("随机点名器");
        this.setSize(530,450);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭按钮，这个是关闭整个程序
        //DO_NOTHING_ON_CLOSE：点击关闭但不做任何操作 0
        //HIDE_ON_CLOSE：点击关闭隐藏界面 1 默认
        //DISPOSE_ON_CLOSE：点击关闭释放资源 2 ，如果你有很多界面，只有当你关闭最后一个界面时才会关闭虚拟机 如果你的界面有很多资源，比如数据库连接，网络连接，文件连接，那么这个选项就很有用
        //EXIT_ON_CLOSE：点击关闭退出程序 3 ，只要关掉一个界面，整个程序就会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体的布局管理器，取消默认的居中布置，改为绝对布局，只有取消了默认的居中布局，才能设置组件的xy位置
        this.setLayout(null);

        //给goB添加鼠标监听事件
        goB.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                name.setText("幸运儿是： "+RandomGenerate.generateRandomName(list,weightList2,pList));
            }
        });

    }

    //初始化随机点名器，包括权重和概率分布
    public void initRandomGenerate(){
        //读取文件里的名字
        RandomGenerate.readfile(list);

        //初始化权重数组
        double weight = 1.0/list.size();
        for(int i=1;i<=list.size();i++) {
            weightList2.add(weight);
        }

        //概率分布
        for(int i=0;i<list.size();i++) {
            pList.add((i+1)*weight);
        }
    }
}
