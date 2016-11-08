package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MAY99_3 {
    private static boolean[][] visited;

    private static int x, y, z;

    private static int[] pour(int currX, int currY, int dir){
        int[] ret = new int[2];
        if(dir > 0){ //pour from x to y
            ret[0] = 0;
            ret[1] = currY+currX <= y ? currY+currX : y;
        }else{


        }
        return ret;
    }

    private static boolean dfs(int x, int y, int z){
        if(visited[x][y])
            return false;

        return false;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data;
        int T = Integer.parseInt(input.readLine().trim());
        for(int t = 1; t <= T; t++){
            data = input.readLine().split(" ");
            x = Integer.parseInt(data[0]);
            y = Integer.parseInt(data[1]);
            z = Integer.parseInt(data[2]);

            if(dfs(x, y, z))
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }
}
