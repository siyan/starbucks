package com.sywood.starbucks.ben.Euler.TenToNineteen;

public class Nineteen {
    public static void main(String[] args){
        int numSundays = 0;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayNum = 1;
        for (int month : months) {
            for (int i = 1; i <= month; i++) {
                dayNum++;
                if (dayNum == 7) {
                    dayNum = 0;
                }
            }
        }
        int year = 1901;
        while(year < 2001) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                months[1] = 29;
            } else {
                months[1] = 28;
            }
            for (int month : months) {
                for (int i = 1; i <= month; i++) {
                    dayNum++;
                    if (dayNum > 6) {
                        dayNum = 0;
                        if (i == 1){
                            numSundays++;
                        }
                    }
                }
            }

            year++;
        }
        System.out.println(numSundays);
    }
}
