package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVa11790 {
    private static int[] both(int[] heights, int[] weights) {
        int[] weightFordm = new int[heights.length];
        int[] weightForlm = new int[heights.length];
        int dAns = weights[0];
        int iAns = weights[0];
        weightFordm[0] = weights[0];
        weightForlm[0] = weights[0];

        for (int x = 1; x < heights.length; x++) {
            int dMax = 0;
            int iMax = 0;
            for (int y = 0; y < x; y++) {
                if (heights[x] > heights[y]){
                    iMax = Math.max(iMax, weightForlm[y]);
                }
                if(heights[x] < heights[y]){
                    dMax = Math.max(dMax, weightFordm[y]);
                }
            }
            weightForlm[x] = iMax + weights[x];
            weightFordm[x] = dMax + weights[x];
            iAns = Math.max(iAns, weightForlm[x]);
            dAns = Math.max(dAns, weightFordm[x]);
        }
        return new int[]{iAns, dAns};
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(input.readLine());
            int[] heights = new int[n];
            int[] weights = new int[n];
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }
            int[] ans = both(heights, weights);
            if(ans[0] >= ans[1])
                System.out.printf("Case %d. Increasing (%d). Decreasing (%d).\n", t, ans[0], ans[1]);
            else
                System.out.printf("Case %d. Decreasing (%d). Increasing (%d).\n", t, ans[1], ans[0]);
        }
    }
}
