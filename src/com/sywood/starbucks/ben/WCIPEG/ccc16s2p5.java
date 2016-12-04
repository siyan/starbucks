package com.sywood.starbucks.ben.WCIPEG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * solved the same way you solve pictures????
 * ignore the overlapped squares from points Q, only find the outer distances from EACH zombie
 * reduced into how do we find the perimeter of the polygon?
 * take the area of Q - area of Q-1 to find the perimeter (each cell counts as one
 *
 max(r-Q, 0)
 min(r+Q, N)
 max(C-Q, 0)
 min(C+Q, M)
 restructure to use window
 */
public class ccc16s2p5 {
    static int min(int a, int b){
        return a < b ? a : b;
    }
    static int max(int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int K = Integer.parseInt(input.readLine());

        TreeMap<Integer, Integer> compx = new TreeMap<>();
        TreeMap<Integer, Integer> compy = new TreeMap<>();

        for (int i = 0; i < K; i++) {
            data = input.readLine().split(" ");
            compx.put(Integer.parseInt(data[0]), 0);
            compy.put(Integer.parseInt(data[1]), 0);
        }

        int cntx = 1, cnty = 1;
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();

        for(int key : compx.keySet()){
            compx.put(key, cntx++);
            xs.add(key);
        }
        for(int key : compy.keySet()){
            compy.put(key, cnty++);
            ys.add(key);
        }

        //compressed the zombies to a point. Need to scan for each point now?
        int Q = Integer.parseInt(input.readLine());
        if(Q == 0) System.out.println(K);
        else {
            int diff[][] = new int[4002][4002];
            //generate the perimeter of each zombie, looking for points that are smaller
            for (int i = 0; i < K; i++) {
                int r1 = max(xs.get(i) - Q-1, 0), r2 = min(xs.get(i) + Q, N); //subtract one to include a point
                int c1 = max(ys.get(i) - Q-1, 0), c2 = min(ys.get(i) + Q, M); //same thing here
                diff[r1][c1] += 1;
                diff[r1][c2] -= 1;
                diff[r2][c1] -= 1;
                diff[r2][c2] += 1;
            }

            long ans = 0;
            for (int i = 1; i < xs.size(); i++) {
                for (int j = 1; j < ys.size(); j++) {
                    diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                    if (diff[i][j] > 0) ans += ((long) xs.get(i) - xs.get(i - 1)) * ((long) ys.get(j) - ys.get(j - 1));
                }
            }
            long ans2 = 0;
            diff = new int[4002][4002];
            for (int i = 1; i < xs.size(); i++) {
                for (int j = 1; j < ys.size(); j++) {
                    diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                    if (diff[i][j] > 0)
                        ans += ((long) xs.get(i) - xs.get(i - 1)) * ((long) ys.get(j) - ys.get(j - 1));
                }
            }
            System.out.println(ans + ", " + ans2);
        }
    }
}
