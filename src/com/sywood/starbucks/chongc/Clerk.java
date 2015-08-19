package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
public class Clerk {
    public static void main(String[] args){
        int[] account={1,1,0,5,2,3,0,0,0,5,3,6};
        int v=0;
        int zc=0;
        for(int i=account.length-1;i>=0;i--){
            if(account[i]==0){
                zc=zc+1;
            }else{
                if(zc!=0){
                    zc=zc-1;
                    continue;
                }
            }
            v=v+account[i];
        }
        System.out.println(v);
    }
}

