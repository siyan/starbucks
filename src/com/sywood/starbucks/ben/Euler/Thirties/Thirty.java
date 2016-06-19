package com.sywood.starbucks.ben.Euler.Thirties;

public class Thirty {
    private static boolean isPower(int number){
        String digits = String.valueOf(number);
        double sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(digits.charAt(i)));
            sum += Math.pow(temp, 5);
        }
        return sum == number;
    }

    public static void main(String[] args){
        int sum = 0;
        for (int i = 2; i < Math.pow(10, 6); i++) {
            if (isPower(i)){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
