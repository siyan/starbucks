package com.sywood.starbucks.ben.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-01.
 */
public class Trionacci {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int q = Integer.parseInt(data[1]);
        int[] f = new int[n];
        int[] increase = new int[n+1];
        int[] values = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());

        f[0] = Integer.parseInt(st.nextToken());
        f[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(input.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            increase[l] += values[l];
        }
    }
}
