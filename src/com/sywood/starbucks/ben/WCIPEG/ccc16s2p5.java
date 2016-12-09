package com.sywood.starbucks.ben.WCIPEG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * solved the same way you solve pictures????
 * ignore the overlapped squares from points Q, only find the outer distances from EACH zombie
 * reduced into how do we find the perimeter of the polygon?
 * take the area of Q - area of Q-1 to find the perimeter (each cell counts as one
 */
public class ccc16s2p5 {
    private static int min(int a, int b){
        return a < b ? a : b;
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }

    private static int K, N, M, r1, r2, c1, c2, diff[][], zombiesr[], zombiesc[], xs[], ys[];
    private static TreeMap<Integer, Integer> compx, compy;

    private static long area(int Q){
        compx = new TreeMap<>();
        compy = new TreeMap<>();
        for (int i = 0; i < 4002; i++) {
            Arrays.fill(diff[i], 0);

        }

        for (int i = 0; i < K; i++) {
            compx.put(max(zombiesr[i]-Q-1, 0), 0);
            compx.put(min(zombiesr[i]+Q, N), 0);
            compy.put(max(zombiesc[i]-Q-1, 0), 0);
            compy.put(min(zombiesc[i]+Q, M), 0);
        }

        //xs = new ArrayList<>(); ys = new ArrayList<>();

        int cntx = 1, cnty = 1;

        for(int key : compx.keySet()){
            xs[cntx-1] = key;
            compx.put(key, cntx++);
            //xs.add(key);

        }
        for(int key : compy.keySet()){
            ys[cnty-1] = key;
            compy.put(key, cnty++);
            //ys.add(key);
        }

        for (int i = 0; i < K; i++) {
            int r1 = compx.get(max(zombiesr[i] - Q-1, 0));
            int r2 = compx.get(min(zombiesr[i] + Q, N)); //subtract one to include a point
            int c1 = compy.get(max(zombiesc[i] - Q-1, 0));
            int c2 = compy.get(min(zombiesc[i] + Q, M)); //same thing here
            diff[r1][c1]++;
            diff[r1][c2]--;
            diff[r2][c1]--;
            diff[r2][c2]++;
        }

        long ans = 0;
        for (int i = 1; i < cntx; i++) {
            for (int j = 1; j < cnty; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                if (diff[i][j] > 0){
                    //ans += ((long) xs.get(i) - xs.get(i - 1)) * ((long) ys.get(j) - ys.get(j - 1));
                    ans += (long) (xs[i] - xs[i - 1]) * (ys[j] - ys[j - 1]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(input.readLine());

        zombiesc = new int[2000];
        zombiesr = new int[2000];
        for (int i = 0; i < K; i++) {
            data = input.readLine().trim().split(" ");
            zombiesr[i] = Integer.parseInt(data[0]);
            zombiesc[i] = Integer.parseInt(data[1]);
        }

        int Q = Integer.parseInt(input.readLine());
        diff = new int[4002][4002];
        xs = new int[4002];
        ys = new int[4002];
        if(Q == 0) System.out.println(K);
        else {
            System.out.println(area(Q) - area(Q-1));
        }
    }
}