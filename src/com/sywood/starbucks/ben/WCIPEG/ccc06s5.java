package com.sywood.starbucks.ben.WCIPEG;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ccc06s5 {
    static byte[][] cells;
    private static int generation(int a, int b, int c){
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = input.readLine().split(" ");
        int m = Integer.parseInt(numbers[0]);
        int n = Integer.parseInt(numbers[1]);
        cells = new byte[m][n];
        int a = Integer.parseInt(numbers[2]);
        int b = Integer.parseInt(numbers[3]);
        int c = Integer.parseInt(numbers[4]);
        for (int i = 0; i < a; i++) {
            String process = input.readLine();
            for (int j = 0; j < b; j++) {
                if (process.charAt(j) == '.'){
                    cells[i][j] = 0;
                }else{
                    cells[i][j] = 1;
                }
            }
        }
    }
}
