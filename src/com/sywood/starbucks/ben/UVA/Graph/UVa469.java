package com.sywood.starbucks.ben.UVA.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Flood fill
 */

public class UVa469 {

    private static int[] dr = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    private static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    private static int R, C;

    private static char[][] colours;

    private static int floodfill(int row, int col, char c1, char c2) {
        if (row < 0 || row >= R || col < 0 || col >= C)
            return 0;

        if (colours[row][col] != c1)
            return 0; //exited the boundaries of the colour

        int ans = 1;
        colours[row][col] = c2;

        for(int d = 0; d < 8; d++)
            ans += floodfill(row + dr[d], col + dc[d], c1, c2);
        return ans;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        int T = Integer.parseInt(input.readLine());
        input.readLine();
        for(int t = 1; t < T+1; t++){
            colours = new char[99][99];
            line = input.readLine();
            R = 0;
            while(line.charAt(0) == 'L' || line.charAt(0) == 'W'){
                C = line.length();
                colours[R++] = line.toCharArray();
                line = input.readLine();
            }


            while(!line.equals("")){
                st = new StringTokenizer(line);

                int row = Integer.parseInt(st.nextToken())-1;
                int col = Integer.parseInt(st.nextToken())-1;


                if (colours[row][col] == '.')
                    System.out.println(floodfill(row, col, '.', 'W'));
                else
                    System.out.println(floodfill(row, col, 'W', '.'));
                line = input.readLine();
            }
            System.out.println();
        }
    }
}
