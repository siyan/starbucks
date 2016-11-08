package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MAY99_3 {
    private static boolean[][] visited;

    private static int x, y, z;

    private static int[] pour(int currX, int currY, int dir){
        int[] ret = new int[2];
        if(dir > 0){ //pour from y to x
           if (currX+currY <= x)
               ret[0] = currX +currY;
           else{
               ret[1] = currY - (x-currX);
               ret[0] = x;
           }
        }else{
            if (currX+currY <= y)
                ret[1] = currX +currY;
            else{
                ret[0] = currX - (y-currY);
                ret[1] = y;
            }
        }
        return ret;
    }

    private static boolean dfs(int x, int y){
        if (x == z || y == z){
            visited[x][y] = true;
            return true;
        }
        if(visited[x][y])
            return false;
        visited[x][y] = true;
        System.out.println(x + ", " + y);
        boolean found;
        int[] pour = pour(x, y, 0);
        found = dfs(pour[0], pour[1]);
        pour = pour(x, y, 1);
        found |= dfs(pour[0], pour[1]);
        return found;
    }

    public static void main(String[] args)throws Exception{
        x = 2;
        y = 6;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data;
        int T = Integer.parseInt(input.readLine().trim());
        for(int t = 1; t <= T; t++){
            data = input.readLine().split(" ");
            x = Integer.parseInt(data[0]);
            y = Integer.parseInt(data[1]);
            z = Integer.parseInt(data[2]);
            visited = new boolean[x+30][y+30];
            if(dfs(0, y) || dfs(x, 0) || dfs(x, y))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
