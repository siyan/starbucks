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
        if (whole == ""){
            return 0;
        }
        return 1;
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
    public static void main(String[] args){
        System.out.print(allStar("hello"));
    }
}
