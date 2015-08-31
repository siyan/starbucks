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








    public static boolean strCopies(String str,String sub,int count){

        if(count==0){
            return true;
        }else{
            if(str.length()<sub.length()){
                    return false;     /////not finished yet
            }
        }

        return true; ///written to prevent error


    }














    public static int sumDigits(int num){
        if(num / 10 == 0) {
            return 0;
        }else{
            return num % 10 + sumDigits(num/10);
        }
    }













    public static int countPairs(String str){
        if(str.length()!=0) {
            if (str.substring(0).equalsIgnoreCase(str.substring(2))) {
                return 1 + countPairs(str.substring(1));
            } else {
                return countPairs(str.substring(1));
            }
        }else{
            return 0;
        }
    }




    public static String stringClear(String str){

         return null;
    }                    //
}
