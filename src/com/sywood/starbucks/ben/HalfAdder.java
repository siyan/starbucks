package com.sywood.starbucks.ben;

/**
 * Created by Striker on 2016-09-30.
 */
public class HalfAdder {
    private static int a;
    private static int b;
    private static String add(int currentBit, int a1, int b1, int carry){
        if (currentBit > Integer.bitCount(a)) {
            return String.valueOf(carry);
        }else{
            currentBit++;
            return add(currentBit, (a>>currentBit)&1,(b>>currentBit)&1, ((a1&b1)|((a1^b1)&carry))) + String.valueOf((a1^b1)^carry);
        }
    }

    public static void main(String[] args){
        a = 5;
        b = 6;
        System.out.println(add(0, a&1, b&1, 0));
    }

}
