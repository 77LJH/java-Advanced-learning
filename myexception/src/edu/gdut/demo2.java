package edu.gdut;

public class demo2 {
    public static void main(String[] args) {
        //try...catch...finally 一般用在调用处
        int[] arr = null;
        try {
            int max = getMax(arr);
            System.out.println(max);
        }catch (NullPointerException e){
            System.out.println("空指针异常");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
            e.printStackTrace();
        }
        System.out.println("看看我能不能执行");
    }
    public static int getMax(int[] arr){
        //在方法中抛出异常：throw和throws
        //throw：手动抛出异常
        //throws：声明异常
        if (arr == null){
            throw new NullPointerException("空指针异常");
        }
        if (arr.length == 0){
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        int max = 0;
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
