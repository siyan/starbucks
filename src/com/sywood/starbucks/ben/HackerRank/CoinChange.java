package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Striker on 2016-09-07.
 */
public class CoinChange {
    private static int N, target;
    private static int[] coins = new int[]{1, 5, 10, 25, 50};

    private static long coinChange(){
        long[][] memo = new long[target+1][coins.length];

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < coins.length; j++){
                if (i == 0)
                    memo[i][j] = 1;
                else if (j == 0)
                    if (i % coins[j] == 0)
                        memo[i][j] = 1;
                    else
                        memo[i][j] = 0;
                else if( coins[j] > i)
                    memo[i][j] = memo[i][j-1];
                else
                    memo[i][j] = memo[i - coins[j]][j] + memo[i][j-1];
            }
        }
        return memo[target][coins.length-1];
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        target = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(coinChange());
    }
}
