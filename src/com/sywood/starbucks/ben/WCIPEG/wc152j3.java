package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;
import java.util.ArrayList;

public class wc152j3 {
    private static boolean in (ArrayList<Integer> troops, int type){
        for (int troop : troops){
            if (troop == type){
                return true;
            }
        }
        return false;
    }

    private static int locate(int[] trooper, int[] ewok, int R){
        int ret = 0;
        int x = Math.abs(trooper[1]-ewok[0]);
        int y = Math.abs(trooper[2]-ewok[1]);
        if (Math.sqrt(Math.pow(x, 2)+Math.pow(y,2)) < R){
            ret = trooper[0];
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
            ArrayList<Integer> troopType = new ArrayList<>();
            for (int[] trooper : troopers){
                if (!in (troopType, locate(trooper, ewok, R))){
                    if (locate(trooper, ewok, R) != 0) {
                        troopType.add(locate(trooper, ewok, R));
                    }
                }
            }if (troopType.size() > 1){
                danger++;
            }
        }
        System.out.print(danger);
    }
}
