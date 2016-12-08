package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ccc15j5 {
    private static int memo[][];

    static int solve(int n, int k){
        if(n < k)
            return 0;
        if(k == 1 || k == n)
            return 1;

        if(memo[n][k] != -1) return memo[n][k];
        return memo[n][k] = solve(n-k, k) +  solve(n-1, k-1);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int k = Integer.parseInt(input.readLine());
        memo = new int[n+1][k+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(i < j) memo[i][j] = 0;
                else if(j == 1 || j == i)
                    memo[i][j] = 1;
                else memo[i][j] = memo[i-j][j] + memo[i-1][j-1];
            }
        }

        System.out.println(memo[n][k]);

    }
}
