package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class wc152j2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int m = input.nextInt();
        int tot = 0;
        for (int i = 0; i < first; i++){
            int rock = input.nextInt();
            if (rock <= m){
                tot += rock;
            }
        }
        System.out.println(tot);
    }
}
