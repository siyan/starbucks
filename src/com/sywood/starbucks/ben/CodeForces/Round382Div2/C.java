package com.sywood.starbucks.ben.CodeForces.Round382Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 Actually question A
 */
public class C {
    static boolean[] visited;
    static int n, k, end;
    static boolean canTravel(int idx){
        if(idx == end)return true;
        visited[idx] = true;
        boolean ret = false;

        if(idx - k >= 0 && !visited[idx-k]) ret = canTravel(idx-k);
        if(idx + k < n && !visited[idx+k]) ret |= canTravel(idx+k);

        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        k = Integer.parseInt(data[1]);
        String line = input.readLine();
        int[] arr = new int[n];
        visited = new boolean[n];
        int start = -1;
        for (int i = 0; i < n; i++) {
            if(line.charAt(i) == '#') {
                arr[i] = 0;
                visited[i] = true;
            }
            else if(line.charAt(i) == '.') arr[i] = 1;
            else if (line.charAt(i) == 'G') {
                start = i;
                arr[i] = 2;
            }
            else {
                end = i;
                arr[i] = 3;
            }
        }
        if(canTravel(start)) System.out.println("YES");
        else System.out.println("NO");
    }
}
