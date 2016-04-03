package com.sywood.starbucks.ben.Euler;

public class Nineteen {
    public static void main(String[] args){
        int numSundays = 1;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 1901;
        int dayNum = 2;
        while(year < 2001) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && year % 100 == 0) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }
            for (int month : months) {
                for (int i = 1; i <= month; i++) {
                    if (dayNum == 7 && i == 1) {
                        numSundays++;
                        dayNum = 0;
                    }else if (dayNum == 7){
                        dayNum = 0;
                    }
                    dayNum++;
                }
            }

            year++;
        }
        System.out.println(numSundays);
    }
}
