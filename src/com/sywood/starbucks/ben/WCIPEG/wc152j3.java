package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;
import java.util.ArrayList;

public class wc152j3 {
    private static boolean locate(int[] trooper, int[] ewok){
        boolean ret = false;
        int x = Math.abs(trooper[0]-ewok[0]);
        int y = Math.abs(trooper[1]-ewok[1]);
        if (Math.sqrt(Math.pow(x, 2)+Math.pow(y,2)) < trooper[2]){
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
        }for (int[] ewok : ewoks){
            boolean found = false;
            for (int[] trooper : troopers){
                if (locate(trooper, ewok) & !found){
                    danger++;
                    System.out.println(trooper[0] + ", " + trooper[1] + ", " + trooper[2] + ", " + ewok[0] + " " + ewok[1]);
                    found = true;
                }
            }
        }
        System.out.print(danger);
    }
}
