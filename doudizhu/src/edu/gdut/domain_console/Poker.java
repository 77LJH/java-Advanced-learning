package edu.gdut.domain_console;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Luffy
 */
public class Poker implements Comparable<Poker> {
    //花色
    private String suit;
    //牌面点数
    private String rank;

    public Poker() {
    }

    public Poker(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * 获取
     * @return suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * 设置
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * 获取
     * @return rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * 设置
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Poker{suit = " + suit + ", rank = " + rank + "}";
    }

    @Override
    public int compareTo(Poker o) {
        //定义牌面大小
        String[] rankvalue = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","blackJoker","redJoker"};
        String[] suitvalue = {"♦", "♣", "♥", "♠"};
        ArrayList<String> rankList = new ArrayList<>();
        ArrayList<String> suitList = new ArrayList<>();
        Collections.addAll(rankList, rankvalue);
        Collections.addAll(suitList, suitvalue);

        int res=rankList.indexOf(this.rank)-rankList.indexOf(o.rank);
        res=res==0?suitList.indexOf(this.suit)-suitList.indexOf(o.suit):res;
        //比较花色：♦ ♣ ♥ ♠，怎么比较花色呢？？？
        return res;
    }
}
