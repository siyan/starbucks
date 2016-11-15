package com.sywood.starbucks.ben.Waterloo.Waterloo2000;

import java.util.*;

/**
 * Created by Ben on 2016-11-13.
 */
public class ccc00s4 {
    private static int N, target;
    private static int[] coins;
    private static int[][] memo;

    private static int min(int a, int b){
        return a > b ? b : a;
    }
    private static int coinChange(int val, int steps){
        if(val == target)
             return steps;
        else if(val > target)
            return Integer.MAX_VALUE;
        if(memo[val][steps] != -1)
            return memo[val][steps];
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            best = min(best, coinChange(val+coins[i], steps+1));
        }
        return memo[val][steps] = best;
    }

    public static void main(String[] args)throws Exception{
        Scanner input = new Scanner(System.in);
        target = input.nextInt();
        N = input.nextInt();
        coins = new int[N];
        memo = new int[target][600];
        for(int[] row : memo)
            Arrays.fill(row, -1);
        for(int i = 0; i < N; i++)
            coins[i] = input.nextInt();
        int change = coinChange(0, 0);
        if(change == Integer.MAX_VALUE)
            System.out.println("Roberta acknowledges defeat.");
        else {
            if(change == 1)
                System.out.println("Roberta wins in 1 stroke.");
            else
                System.out.println("Roberta wins in " + change + " strokes.");
        }
    }

}
