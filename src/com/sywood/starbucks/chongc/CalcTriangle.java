package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/23.
 */

public class CalcTriangle {


    public static int CalcTriangle(int n){
        if(n==1) {
            return 1;
        }else{
            return n+CalcTriangle(n-1);
        }
    }


    public static void main(String[] args){
        int n =6;
        int sum = CalcTriangle(n);
        System.out.println(sum);


    }

}
