package com.sywood.starbucks.ben.SIUCFcompetitions.SecondPreCamp;
import java.io.*;

public class scenes {
    private static long count = 0;
    private static void generate(int w, int h, int n, int currIdx, int[] grid){
        if (currIdx == w){
            if (check(grid)){
                count++;
            }
        }else {
            if (n == 0){
                generate(w, h, n, w, grid);
            }
            for (int i = 0; i <= h; i++) {
                if (n - i >= 0) {
                    grid[currIdx] = i;
                    generate(w, h, n - i, currIdx + 1, grid);
                }else{
                    break;
                }
            }
        }
    }

    private static boolean check(int[] thing){
        int first = thing[0];
        int count = 1;
        for (int i = 1; i < thing.length; i++) {
            if (first == thing[i]) count++;
        }
        return count != thing.length;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int w = Integer.parseInt(info[1]);
        int h = Integer.parseInt(info[2]);
        int[] scene = new int[w];
        generate(w, h, n, 0, scene);
        System.out.println(count%(Math.pow(10, 9)+7));
    }
}
