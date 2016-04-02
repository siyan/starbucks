package com.sywood.starbucks.ben.Euler;

public class Nineteen {
    public static void main(String[] args){
        int numSundays = 1;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 1900;
        int dayPassed = 1;
        while(year < 2001){
            for (int month:months){
                if (year % 4 == 0 && year%100 != Math.floorDiv(year, 10) || year%400 == 0 && year%100 == Math.floorDiv(year, 10)){
                    months[1] = 29;
                }else{
                    months[1] = 28;
                }
                for (int i = 1; i < month; i++) {
                    if ((dayPassed-6) % 4 == 0){
                        numSundays++;
                    }
                    dayPassed++;
                }
            }
            year++;
        }
        System.out.println(numSundays);
    }
}
