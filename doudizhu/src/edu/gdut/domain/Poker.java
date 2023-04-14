package edu.gdut.domain;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel{
    //属性
    //1.牌的名字 格式：数字-数字
    private String name;

    //2.牌显示正面还是反面
    private boolean isUp;

    //3.是否可以被点击
    private boolean canClick=false; //默认是不可以被点击的

    //4.当前的状态，表示当前的牌是否已经被点击
    //如果是被点击的，此时再次点击就会执行下落操作
    //如果是未被点击的，此时被点击就会执行弹起操作
    private boolean isClicked=false; //默认是未被点击的

    //显示正面
    public void showUp(){
        this.setIcon(new ImageIcon("doudizhu\\image\\poker\\"+name+".png"));
        this.isUp=true;
    }

    //显示反面
    public void showDown(){
        this.setIcon(new ImageIcon("doudizhu\\image\\poker\\rear.png"));
        this.isUp=false;
    }

    public Poker(String name, boolean isUp) {
        this.name = name;
        this.isUp = isUp;

        if(isUp){
            //给牌设置为正面
            showUp();
            this.canClick=true;
        }else{
            //给牌设置为反面
            showDown();
        }
        //设置大小
        this.setSize(71,96);
        //把牌显示在界面上
        this.setVisible(true);
        //添加监听
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果当前牌可以被点击
                if(canClick){
                    //如果当前牌是未被点击的
                    if(!isClicked){
                        //弹起
                        setLocation(getX(),getY()-20);
                        isClicked=true;
                    }else{
                        //下落
                        setLocation(getX(),getY()+20);
                        isClicked=false;
                    }
                }
            }
        });
    }

    /**
     * 获取
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return isUp
     */
    public boolean isIsUp() {
        return isUp;
    }

    /**
     * 设置
     * @param isUp
     */
    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return isClicked
     */
    public boolean isIsClicked() {
        return isClicked;
    }

    /**
     * 设置
     * @param isClicked
     */
    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    @Override
    public String toString() {
        return "Poker{name = " + name + ", isUp = " + isUp + ", canClick = " + canClick + ", isClicked = " + isClicked + "}";
    }
}
