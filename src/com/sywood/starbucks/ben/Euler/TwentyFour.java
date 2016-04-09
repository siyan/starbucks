package com.sywood.starbucks.ben.Euler;

import java.util.ArrayList;

public class TwentyFour {
    static ArrayList<String> digits = new ArrayList<>();
    private static void generate(){
        digits.add("0");
        digits.add("1");
        digits.add("2");
        digits.add("3");
        digits.add("4");
        digits.add("5");
        digits.add("6");
        digits.add("7");
        digits.add("8");
        digits.add("9");
    }

    private static int factorial(int num){
        int ret = 1;
        for (int i = 2; i <= num; i++) {
            ret = ret*i;
        }
        return ret;
    }
    private static void find(int index){
        int start = 9;
        //System.out.println(factorial(9));
        String ret = "";
        while (start >= 0){
            int temp = Math.floorDiv(index, factorial(start));
            System.out.println(temp + ", " + digits.get(temp));
            ret += digits.get(temp);
            digits.remove(temp);
            index -= factorial(start)*temp;
            start--;
        }
        System.out.println(ret);
    }

    public static void main(String[] args){
        generate();
        find(999999);
    }
}
