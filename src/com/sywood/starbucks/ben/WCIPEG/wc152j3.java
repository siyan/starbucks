package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;
import java.util.ArrayList;

public class wc152j3 {
    private static boolean locate(int[] trooper, int[] ewok){
        boolean ret = false;
        if (Math.sqrt(Math.abs(trooper[0]-ewok[0])+Math.abs(trooper[1]-ewok[1])) < trooper[2]){
            ret = true;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int S = input.nextInt();
        int E = input.nextInt();
        int R = input.nextInt();
        int danger = 0;
        ArrayList<int[]> troopers = new ArrayList<>();
        ArrayList<int[]> ewoks = new ArrayList<>();
        for (int i = 0; i < S; i++){
            troopers.add(new int[]{input.nextInt(), input.nextInt(), input.nextInt()});
        }for (int i = 0; i < E; i++){
            ewoks.add(new int[]{input.nextInt(), input.nextInt()});
        }for (int[] trooper : troopers){
            boolean found = false;
            for (int[] ewok : ewoks){
                if (locate(trooper, ewok) & !found){
                    danger++;
                    found = true;
                }
            }
        }
        System.out.print(danger);
    }
}
