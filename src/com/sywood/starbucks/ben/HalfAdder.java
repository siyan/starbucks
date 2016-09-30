package com.sywood.starbucks.ben;

/**
 * Created by Striker on 2016-09-30.
 */
public class HalfAdder {
    private static int a;
    private static int b;
    private static String add(int steps, int a1, int b1, int carry){
        if (steps > Integer.bitCount(a)) {
            return String.valueOf(carry);
        }else{
            steps++;
            return add(steps, (a>>steps)&1,(b>>steps)&1, ((a1&b1)|((a1^b1)&carry))) + String.valueOf((a1^b1)^carry);
        }
    }

    public static void main(String[] args){
        a = 5;
        b = 6;
        System.out.println(add(0, a&1, b&1, 0));
    }

}
