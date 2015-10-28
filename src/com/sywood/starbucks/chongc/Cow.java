package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/10/23.
 */
import java.util.Scanner;
public class Cow {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(C(str));

    }



    public static int C(String str){
        if(str.length()<3){
            return 0;
        }else{
            if(str.substring(0,1).equalsIgnoreCase("C")){
                return O(str.substring(1))+C(str.substring(1));
            }else{
                return C(str.substring(1));
            }
        }
    }

    public static int O(String str){
        if(str.length()<2) {
            return 0;
        }else{
            if (str.substring(0,1).equalsIgnoreCase("O")) {
                return W(str.substring(1))+O(str.substring(1));
            }else{
                return O(str.substring(1));
            }
        }
    }

    public static int W(String str){
        if(str.length()<1){
            return 0;
        }else{
            if(str.substring(0,1).equalsIgnoreCase("W")){
                return 1+W(str.substring(1));
            }else{
                return W(str.substring(1));
            }
        }

    }
}
