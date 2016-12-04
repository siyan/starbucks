package com.sywood.starbucks.ben.Waterloo.Waterloo2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Solved using a 2D difference array and coordinate compression
 * Use real coordinates and map to virtual coordinates.
 *
 dif[r1][c1] += v
 dif[r1][c2+1] -= v
 dif[r2+1][c1] -= v
 dif[r1+1][c2+1] += v
 */
public class ccc14s4 {
    static class Window{
        int x1, x2, y1, y2, t;
        public Window(int x1, int y1, int x2, int y2, int t){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.t = t;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(input.readLine());
        int T = Integer.parseInt(input.readLine());

        Window[] windows = new Window[N];
        TreeMap<Integer, Integer> compx = new TreeMap<>();
        TreeMap<Integer, Integer> compy = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] data = input.readLine().split(" ");
            windows[i] = new Window(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
            compx.put(windows[i].x1, 0);
            compx.put(windows[i].x2, 0);
            compy.put(windows[i].y1, 0);
            compy.put(windows[i].y2, 0);
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

        long[][] diff = new long[2002][2002];

        for (int i = 0; i < N; i++) {
            int r1 = compx.get(windows[i].x1), r2 = compx.get(windows[i].x2);
            int c1 = compy.get(windows[i].y1), c2 = compy.get(windows[i].y2);
            int v = windows[i].t;
            diff[r1][c1] += v; diff[r1][c2] -= v; diff[r2][c1] -= v; diff[r2][c2] += v;
        }
        long ans = 0;
        for(int i = 1; i < xs.size(); i++){
            for (int j = 1; j < ys.size(); j++) {
                diff[i][j] += diff[i-1][j] + diff[i][j-1]-diff[i-1][j-1];
                if(diff[i][j] >= T) ans += ((long)xs.get(i) - xs.get(i - 1)) * ((long)ys.get(j) - ys.get(j - 1));
            }
        }
        System.out.println(ans);
    }
}
