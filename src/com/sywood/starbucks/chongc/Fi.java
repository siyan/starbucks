package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
public class Fi {
    public static int Fii(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }else{
            return Fii(n-1)+Fii(n-2);
        }
    }
    public static void main(String[] args){
        int n=8;
        int fi =Fii(n);
        System.out.println(fi);
    }
}
