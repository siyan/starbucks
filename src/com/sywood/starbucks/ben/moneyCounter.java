package com.sywood.starbucks.ben;

import java.util.Scanner;
import java.util.Stack;

public class moneyCounter {
        public static void main(String[] args) {
            Stack entries = new Stack();
            int tot = 0;
            boolean exit = false;
            while (!exit) {
                Scanner userInput = new Scanner(System.in);
                int bossNum;
                System.out.print("Enter the value of the profits of the next client, type -1 to exit: ");
                bossNum = userInput.nextInt();
                if (bossNum < 0){
                    exit = true;
                }
                else if (bossNum == 0){
                    entries.pop();
                }
                else{
                    entries.push(bossNum);
                }

            }
            while (!entries.empty()){
                tot += (Integer)entries.pop();
            }
            System.out.print("The total profit is: " + tot);
        }
}