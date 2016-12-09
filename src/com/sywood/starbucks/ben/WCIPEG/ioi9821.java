package com.sywood.starbucks.ben.WCIPEG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * like zombie apocalypse, but we are given the rectangle. instead, we need to subtract 1 from the perimeter
 */
public class ioi9821 {
    static class Rect {
        int x1, y1, x2, y2;

        public Rect(int x2, int y2, int x1, int y1) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    private static TreeMap<Integer, Integer> compx, compy;
    private static int n;
    private static int[][] diff = new int[5001][5001];
    private static int[] xs = new int[5000], ys = new int[5000];
    private static Rect[] rects = new Rect[5000];

    private static int area(int change){
        diff = new int[5001][5001];
        compx = new TreeMap<>();
        compy = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            compx.put(rects[i].x1 - change, 0);
            compx.put(rects[i].x2 + change, 0);
            compy.put(rects[i].y1 - change, 0);
            compy.put(rects[i].y2 + change, 0);
        }

        int cntx = 1, cnty = 1;
        for(int key : compx.keySet()){
            xs[cntx-1] = key;
            compx.put(key, cntx++);
        }
        for(int key : compy.keySet()){
            ys[cnty-1] = key;
            compy.put(key, cnty++);
        }

        for (int i = 0; i < n; i++) {
            int r1 = compx.get(rects[i].x1 - change);
            int r2 = compx.get(rects[i].x2 + change);
            int c1 = compy.get(rects[i].y1 - change);
            int c2 = compy.get(rects[i].y2 + change);
            diff[r1][c1]++;
            diff[r1][c2]--;
            diff[r2][c1]--;
            diff[r2][c2]++;
        }

        int ans = 0;

        for (int i = 1; i < xs.length; i++) {
            for (int j = 1; j < ys.length; j++) {
                diff[i][j] += diff[i-1][j] + diff[i][j-1] - diff[i-1][j-1];
                if(diff[i][j] > 0) ans += (long) (xs[i]-xs[i-1]) * (ys[j]-ys[j-1]);
            }
        }

        return ans;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());

        String[] data;

        for (int i = 0; i < n; i++) {
            data = input.readLine().split(" ");
            rects[i] = new Rect(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        }
        int a1 = area(0);
        int a2 = area(1);
        if(a1 == a2 && a1 == 1)
            System.out.println(1);
        else
            System.out.println(area(0) - area(1));
    }
}
