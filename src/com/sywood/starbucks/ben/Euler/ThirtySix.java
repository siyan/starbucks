package com.sywood.starbucks.ben.Euler;

public class ThirtySix {

    private static boolean isPal(int num){
        String reverse = "";
        String toUse = String.valueOf(num);
        for (int i = toUse.length()-1; i >= 0; i--) {
            reverse += toUse.charAt(i);
        }
        boolean pal = reverse.equals(toUse);
        toUse = String.valueOf(Integer.toBinaryString(num));
        reverse = "";
        for (int i = toUse.length()-1; i >= 0; i--) {
            reverse += toUse.charAt(i);
        }
        return toUse.equals(reverse)&& pal;
    }


    public static void main(String[] args){
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPal(i)){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
