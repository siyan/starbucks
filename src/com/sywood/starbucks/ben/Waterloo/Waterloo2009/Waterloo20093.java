package com.sywood.starbucks.ben.Waterloo.Waterloo2009;
import java.util.Scanner;

public class Waterloo20093 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int time = input.nextInt();
        System.out.println(time + " in Ottawa");
        time -= 300;
        if (time < 0){
            time += 2400;
        }
        System.out.println(time + " in Victoria");
        time += 100;
        if (time >= 2400){
            time -=2400;
        }
        System.out.println(time + " in Edmonton");
        time += 100;
        if (time >= 2400){
            time -=2400;
        }
        System.out.println(time + " in Winnipeg");
        time += 100;
        if (time >= 2400){
            time -=2400;
        }
        System.out.println(time + " in Toronto");
        time += 130;
        if (time >= 2400){
            time -=2400;
        }
        System.out.println(time + " in St. John's");
    }
}
