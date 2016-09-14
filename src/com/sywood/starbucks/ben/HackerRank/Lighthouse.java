package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-13.
 */
public class Lighthouse {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        boolean[][] matrix = new boolean[n][n];
        boolean good = false;

        for (int i = 0; i < n; i++) {
            char[] data = input.readLine().toCharArray();
            for (int j = 0; j < n; j++)
                good |= (matrix[i][j] = data[j] == '*');
        }

        if (good){
            int best = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    //i, j is the starting point
                    if(matrix[row][col]){
                        boolean[][] visited = new boolean[n][n];
                        int currBest = 0;
                        for(int radius = 0; radius <= n/2; radius++){
                            boolean worked = true;
                            for(int i = 0; i <= radius; i++){
                                for(int j = 0; j + i <= radius; j++){
                                    if (!visited[i][j] && matrix[i][j]){
                                        visited[i][j] = true;
                                    }else if (!matrix[i][j]){
                                        worked = false;
                                        i = n;
                                        break;
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }else{
            System.out.println(0);
        }
    }
}
