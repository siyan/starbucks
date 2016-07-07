package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;
import java.util.Arrays;

public class whiteboard {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line = input.readLine().split(" ");
        int h = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        int n = Integer.parseInt(line[2]);
        int minMoves = -1;
        int maxMoves = -1;

        byte[][] board = new byte[h][w]; //next for loop finds the target board
        for (int i = 0; i < h; i++) {
            String data = input.readLine();
            for (int j = 0; j < w; j++) {
                char curr = data.charAt(j);
                if (curr == '.'){
                    board[i][j] = 0;
                }else{
                    board[i][j] = 1;
                }
            }
        }
        int currR = h-1;
        int currC = 0;
        byte[][] profMoves = new byte[h][w]; //this one draws the prof's board, and if it's ever equal,
        for (int i = 0; i < n; i++) {
            String[] directions = input.readLine().split(" ");
            int moves = Integer.parseInt(directions[1]);
            if (directions[0].equals("up")){
                for (int j = 0; j < moves; j++) {

                }
            }
        }
    }
}
