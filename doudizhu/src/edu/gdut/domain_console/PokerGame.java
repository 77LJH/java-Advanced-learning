package edu.gdut.domain_console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Luffy
 */
public class PokerGame {
    //牌盒
    public static ArrayList<Poker> pokerList = new ArrayList<>();
    //底牌，玩家手牌，电脑1手牌，电脑2手牌
    public static HashMap<String,ArrayList<Poker>> hashMap = new HashMap<>();

    //静态代码块：类加载时执行，且只执行一次
    static {
        /* 花色：♦ ♣ ♥ ♠ 小到大
        * 牌面：3 4 5 6 7 8 9 10 J Q K A 2 blackJoker redJoker*/
        //准备牌
        preparePoker(pokerList);
        System.out.println("欢迎来到斗地主游戏！");
    }

    public PokerGame(String[] args) {
        //洗牌
        Collections.shuffle(pokerList);

        //发牌,发给三个人：玩家，电脑1，电脑2
        deliverPoker(pokerList,hashMap);

        //排序
        hashMap.forEach((key,value)->{
            //把牌排序，注意牌已经在Poker类中实现了Comparable接口
            Collections.sort(value);
        });

        //看牌
        lookPokers();
    }

    private static void lookPokers() {
        hashMap.forEach((key,value)->{
            System.out.println(key+"的牌是：");
            for(Poker poker:value){
                System.out.print(poker.getSuit()+poker.getRank()+" ");
            }
            System.out.println("\n");
        });
    }

    //准备牌
    private static void preparePoker(ArrayList<Poker> pokerList) {
        for(int i=2;i<=10;i++){
            addPoker(pokerList,i+"");
        }
        addPoker(pokerList,"J");
        addPoker(pokerList,"Q");
        addPoker(pokerList,"K");
        addPoker(pokerList,"A");
        pokerList.add(new Poker("","blackJoker"));
        pokerList.add(new Poker("","redJoker"));
    }

    //加牌
    public static void addPoker(ArrayList<Poker> pokerList,String rank){
        pokerList.add(new Poker("♠",rank));
        pokerList.add(new Poker("♥",rank));
        pokerList.add(new Poker("♣",rank));
        pokerList.add(new Poker("♦",rank));
    }

    //发牌
    public static void deliverPoker(ArrayList<Poker> pokerList, HashMap<String,ArrayList<Poker>> hashMap){
        //将牌分成四份：3张底牌，玩家手牌，电脑1手牌，电脑2手牌
        ArrayList<Poker> bottomPoker = new ArrayList<>();
        ArrayList<Poker> player = new ArrayList<>();
        ArrayList<Poker> computer1 = new ArrayList<>();
        ArrayList<Poker> computer2 = new ArrayList<>();

        //将底牌放入底牌列表中
        Collections.addAll(bottomPoker, pokerList.get(0), pokerList.get(1), pokerList.get(2));

        //将剩余牌发给三个人
        for(int i=3;i<pokerList.size();){
            player.add(pokerList.get(i++));
            computer1.add(pokerList.get(i++));
            computer2.add(pokerList.get(i++));
        }

        //将三个人的牌放入hashMap中
        hashMap.put("bottomPoker",bottomPoker);
        hashMap.put("player",player);
        hashMap.put("computer1",computer1);
        hashMap.put("computer2",computer2);
    }
}
