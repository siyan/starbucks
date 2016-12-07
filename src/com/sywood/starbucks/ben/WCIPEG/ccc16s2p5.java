package com.sywood.starbucks.ben.WCIPEG;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    private static int min(int a, int b){
        return a < b ? a : b;
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static int K, N, M, diff[][];
    private static Zombie[] zombies;

    private static long area(int Q){
        TreeMap<Integer, Integer> compx = new TreeMap<>();
        TreeMap<Integer, Integer> compy = new TreeMap<>();
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(diff[i], 0);
        }

        for (int i = 0; i < K; i++) {
            compx.put(max(zombies[i].r-Q-1, 0), 0);
            compx.put(min(zombies[i].r+Q, N), 0);
            compy.put(max(zombies[i].c-Q-1, 0), 0);
            compy.put(min(zombies[i].c+Q, M), 0);
        }

        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        int cntx = 1, cnty = 1;

        for(int key : compx.keySet()){
            compx.put(key, cntx++);
            xs.add(key);
        }
        for(int key : compy.keySet()){
            compy.put(key, cnty++);
            ys.add(key);
        }
        //int diff[][] = new int[4002][4002];
        for (int i = 0; i < K; i++) {
            int r1 = compx.get(max(zombies[i].r - Q-1, 0));
            int r2 = compx.get(min(zombies[i].r + Q, N)); //subtract one to include a point
            int c1 = compy.get(max((zombies[i].c) - Q-1, 0));
            int c2 = compy.get(min((zombies[i].c) + Q, M)); //same thing here
            diff[r1][c1]++;
            diff[r1][c2]--;
            diff[r2][c1]--;
            diff[r2][c2]++;
        }

        long ans = 0;
        for (int i = 1; i < xs.size(); i++) {
            for (int j = 1; j < ys.size(); j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                if (diff[i][j] > 0){
                    ans += ((long) xs.get(i) - xs.get(i - 1)) * ((long) ys.get(j) - ys.get(j - 1));
                }
            }
        }
        return ans;
    }
    static class Zombie{
        int r, c;
        Zombie(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        K = Integer.parseInt(input.readLine());

        zombies = new Zombie[K];

        for (int i = 0; i < K; i++) {
            data = input.readLine().trim().split(" ");
            zombies[i] = new Zombie(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        }

        int Q = Integer.parseInt(input.readLine());
        diff = new int[4002][4002];
        if(Q == 0) System.out.println(K);
        else {
            System.out.println(area(Q) - area(Q-1));
        }
    }
}