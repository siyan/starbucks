package com.sywood.starbucks.ben.Waterloo.Waterloo2000;

import java.util.Scanner;

/**
 * Created by Striker on 2016-11-11.
 */
public class ccc00s1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int quarters = input.nextInt();
        int machine1 = input.nextInt();
        int machine2 = input.nextInt();
        int machine3 = input.nextInt();
        int turn;

        for (turn = 0; quarters > 0; quarters--, turn++) {
            if(turn %3 == 0){
                machine1++;
                if(machine1 == 35) {
                    quarters += 30;
                    machine1 = 0;
                }
            }else if (turn%3 == 1){
                machine2++;
                if(machine2 == 100){
                    quarters += 60;
                    machine2 = 0;
                }
            }else{
                machine3++;
                if(machine3 == 10){
                    quarters += 9;
                    machine3 = 0;
                }
            }
        }
        System.out.printf("Martha plays %d times before going broke.\n", turn);
    }
}
