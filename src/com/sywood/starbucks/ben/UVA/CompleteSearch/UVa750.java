package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UVa750 {
    private static int[] row = new int[8];
    private static int a;
    private static int b;
    private static int numSolutions = 0;
    private static boolean canQueen(int r, int col){
        //prev mean previous column.
        for (int prevCol = 0; prevCol < col; prevCol++){
            if (row[prevCol] == r || Math.abs(row[prevCol]-r) == Math.abs(prevCol-col)){
                return false;
            }
        }return true;
    }

    private static void backtrack(int col){
        if (col == 8 && row[b] == a){
            System.out.printf("%2d     %d", ++numSolutions, row[0] + 1);
            for (int i = 1; i < 8; i++)System.out.printf(" %d", row[i]+1);
            System.out.print("\n");
        }
        for (int r = 0; r < 8; r++){
            if (canQueen(r, col)){
                row[col] = r;
                backtrack(col+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] pos = input.readLine().split(" ");
        System.out.print("SOLN     COLUMN\n" +
                         " #     1 2 3 4 5 6 7 8\n\n");
        a = Integer.parseInt(pos[0])-1;
        b = Integer.parseInt(pos[1])-1;
        row[b] = a;
        backtrack(0);
    }
}
