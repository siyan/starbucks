package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/23.
 */
public class AllStar {
    public static String AllStar(int length){
        if(length%2==0) {
            return "*"+AllStar(length-1);
        }else{
            return null;
        }
    }
    public static void main(String[] args){
        String allStar = new String("hello");
        int strLength = allStar.length()*2-1;
        String Star = AllStar(strLength);

    }
}                  //Unfinished yet
