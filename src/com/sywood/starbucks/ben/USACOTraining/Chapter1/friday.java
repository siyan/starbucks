package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;

/**
 ID: benbli
 LANG: JAVA
 TASK: friday
 */
public class friday {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("friday.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int N = Integer.parseInt(input.readLine());
        int year = 1900;
        int startDay = 1;
        int[] frequency = new int[7];
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while(year < (1900+N)){
            if(year%100 == 0 && year%400 == 0 || year % 4 == 0 && year%100 != 0){
                months[1] = 29;
            }
            for (int i = 0; i < 12; i++) {
                startDay += 13;
                startDay %= 7;
                frequency[startDay]++;
                startDay += months[i]-13;
                startDay %=7;
            }

            months[1] = 28;
            year++;
        }
        String ret = "";
        for (int i = 0; i < 7; i++) {
            ret += frequency[i] + " ";
        }
        printer.println(ret.trim());
        printer.close();
    }
}
