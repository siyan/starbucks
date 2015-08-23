package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/23.
 */
public class AllStar {
    public static String AllStar(String star,int sub){
        if(sub==0){
            return star.substring(0,1)+AllStar(star,sub+1);
        }else {
            if (sub == star.length()) {
                return star.substring(star.length(), star.length());
            } else {
                return "*" +star.substring(sub,sub+1)+ AllStar(star, sub + 1);
            }
        }
    }
    public static void main(String[] args){
        String allStar = new String("hello");
        String Star = AllStar(allStar,0);
        System.out.println(Star);

    }
}
