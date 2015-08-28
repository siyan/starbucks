package com.sywood.starbucks.ben;

import java.lang.reflect.Array;

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
            return num;
        } else{
            return num%10 + sumDigits(num/10);
        }
    }
    public static int countPairs(String str){
        if( str == null || str.length() <= 2) {
            return 0;
        }
        if (str.charAt(0) == str.charAt(2)) {
            return 1 + countPairs(str.substring(2));
        }else{
            return countPairs(str.substring(2));
        }
    }

    public static String stringClean(String inp) {
        if ( inp == null || inp.length() < 2) {
            return inp;
        }else if (inp.charAt(0) == inp.charAt(1)){
            return stringClean(inp.substring(1));
        }else{
            return inp.substring(0, 1) + stringClean(inp.substring(1));
        }
    }

    public static String noX(String inp){
        if (inp == null || inp == "x" || inp.equals("")){
            return "";
        } else if (inp.charAt(0) == 'x'){
            return noX(inp.substring(1));
        } else{
            return inp.charAt(0) + noX(inp.substring(1));
        }
    }

    public static boolean array6(int[] arr, int start){
        if (arr.length == 0 || arr.length == start-1){
            return false;
        } else if (arr[start] == 6){
            return true;
        }else{
            return array6(arr, start+1);
        }
    }

    public static void main(String[] args){
        System.out.println(sumDigits(126));
        System.out.println(allStar("Hello"));
        System.out.println(stringClean("Hello"));
        System.out.println(noX("xaxa"));
        int[] b = {1, 6, 4};
        System.out.println(array6(b, 0));
    }
}
