package com.sywood.starbucks.ben;

/**
 * Created by Striker on 2015-08-22.
 */
public class Recursive1 {
    public static int triangle(int num){
        if (num == 0){
            return 0;
        } else if (num == 1){
            return 1;
        }
        return num+triangle(num-1);
    }
    public static int stringCounter(String whole, String sub){

            int subLen = sub.length();

            if( whole == null || whole.length() == 0 || sub == null) {
                return 0;
            }
            else if ( sub.equalsIgnoreCase( whole.substring( 0, subLen) )) {
                return 1 + stringCounter( whole.substring(subLen), sub );
            }
            else {
                return stringCounter(whole.substring(1), sub );
            }
        }
    public static String allStar(String ret) {
        if (ret.length() == 0) {
            return "";
        }else if (ret.length() == 1){
            return ret;
        }else{
            return ret.substring(0, 1) + "*" + allStar(ret.substring(1));
        }
    }
    public static boolean strCopies(String whole, String sub, int num){
        return stringCounter(whole, sub) == num;
    }
    public static int sumDigits(int num){
        if (num < 10){
            return 0;
        } else{
            return num%10 + sumDigits(num-num%10);
        }
    }
    public static void main(String[] args){
        System.out.print(strCopies("catcowcat", "cat", 2));
    }
}
