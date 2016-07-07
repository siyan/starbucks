package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;

public class reverse {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0")){
            int n = Integer.parseInt(line);
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                board[i] = input.readLine().toCharArray();
            }
            for (char[] row : board){
                int count = 0;
                String toPrint = "";
                for (char col : row){
                    if (col == 'X'){
                        count++;
                    }else if (col == '.' && count > 0){
                        toPrint += count + " ";
                        count = 0;
                    }
                }
                if (count > 0){
                    toPrint += count;
                }
                if (!toPrint.equals("")) {
                    System.out.println(toPrint.trim());
                }else{
                    System.out.println(0);
                }
            }
            for (int col = 0; col < n; col++){
                String toPrint = "";
                int count = 0;
                for(int row = 0; row < n; row++){
                    if (board[row][col] == 'X'){
                        count++;
                    }else if (board[row][col] == '.' && count > 0){
                        toPrint += count + " ";
                        count = 0;
                    }
                }
                if (count > 0){
                    toPrint += count;
                }
                if (!toPrint.equals("")) {
                    System.out.println(toPrint.trim());
                }else{
                    System.out.println(0);
                }
            }
            line = input.readLine();
        }
    }
}
