package com.sywood.starbucks.ben.Euler;

public class Nineteen {
    public static void main(String[] args){
        int numSundays = 1;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 1900;
        int dayPassed = 360;
        while(year < 2001) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && year % 100 == 0) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }
            if (year != 1900) {
                for (int month : months) {
                    for (int i = 1; i <= month; i++) {
                        if ((dayPassed) % 7 == 0 && i == 1) {
                            numSundays++;
                        }
                        dayPassed++;
                    }
                }
            }
            year++;
        }
        System.out.println(numSundays);
    }
}
