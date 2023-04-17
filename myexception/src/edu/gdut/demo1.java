package edu.gdut;

public class demo1 {
    public static void main(String[] args) {
        //如果try中遇到的异常，没有被catch捕获，相当于try ctach白写了，那么程序会终止
        //如果try中遇到多个异常，怎么执行
         int[] arr = {1,2,3};
        try{
            // ArrayIndexOutOfBoundsException
            System.out.println(arr[3]);
            // ArithmeticException
            System.out.println(10/0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
        }catch (Exception e){
            System.out.println("异常");
        }
        System.out.println("over");


        try{
            // ArrayIndexOutOfBoundsException
            System.out.println(arr[3]);
            // ArithmeticException
            System.out.println(10/0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界");
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
            e.printStackTrace();
        }catch (ArithmeticException e){
            System.out.println("算术异常");
        }catch (Exception e){
            System.out.println("异常");
            System.out.println(e.getMessage());
        }
        System.out.println("over");
        System.out.println(
                "如果try中遇到的异常，没有被catch捕获，相当于try ctach白写了，那么程序会终止"
        );
    }
}
