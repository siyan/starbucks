package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa10102 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null && !line.equals("")){
            int M = Integer.parseInt(line);
            int[][] grid = new int[M][M];
            int count1 = 0, count3 = 0; //counts the number of 1s and twos in a given input
            int[][] num1 = new int[M*M][2]; // position of all tiles that have the value 1
            int[][] num3 = new int[M*M][2]; // position of all tiles that have the value 3

            for (int i = 0; i < M; i++) { //this loop sets the grid and counts all of the numbers, etc.
                String row = input.readLine();
                for (int j = 0; j < row.length(); j++) {
                    grid[i][j] = row.charAt(j) - 48;
                    if (grid[i][j] == 1){
                        num1[count1][0] = i; num1[count1][1] = j;
                        count1++;
                    }else if (grid[i][j] == 3){
                        num3[count3][0] = i; num3[count3][1] = j;
                        count3++;
                    }
                }
            }

            int min = -1; // this stores the Manhattan distance from each value 1 tile to value 3 tile, storing only the maximum value
            for (int i = 0; i < count1; i++){
                int[] coord1 = num1[i];
                int tempMin = Integer.MAX_VALUE;
                for(int j = 0; j < count3; j++){ // this loop finds the minimum Manhattan distance from tile 1 to tile 3
                    int[] coord3 = num3[j];
                    int manDist = Math.abs(coord1[0]-coord3[1])+Math.abs(coord1[1]-coord3[0]);
                    if (tempMin > manDist){
                        tempMin = manDist;
                    }
                }
                if (tempMin > min){
                    min = tempMin;
                }
            }
            System.out.println(min);
            line = input.readLine();
        }
    }
}
