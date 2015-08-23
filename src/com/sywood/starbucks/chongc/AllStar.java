package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/23.
 */
public class AllStar {
    public static String AllStar(int lenth){
        if(lenth%2==0) {
            return "*";
        }else{
            return null;
        }
    }
    public static void main(String[] args){
        String allStar = new String("hello");
        int strLenth = allStar.length()*2-1;
        String Star = AllStar(strLenth);

    }
}                  //Unfinished yet
