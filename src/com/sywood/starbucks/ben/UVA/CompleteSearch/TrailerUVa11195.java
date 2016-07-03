package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
/* from the competitive programming boock, chapter 3? not at chapter 8, so it won't finish the UVa question just yet.
 */

public class TrailerUVa11195 {
    private static boolean[] rows;
    private static boolean[] lDiag;
    private static boolean[] rDiag;
    private static String[][] board;


    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null){
            int n = Integer.parseInt(line);
            board = new String[8][];
            for (int i = 0; i < n; i++) {
                board[i] = input.readLine().split(" ");
            }
        }
    }
}
