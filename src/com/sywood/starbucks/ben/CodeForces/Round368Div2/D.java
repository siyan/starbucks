package com.sywood.starbucks.ben.CodeForces.Round368Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-08-20.
 */

public class D {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] state = new int[q+1];
        int[] current = new int[n];
        int[][] previous = new int[q+1][];
        previous[0] = current;
        Arrays.fill(current, 0);
        state[0] = 0;
        for (int i = 1; i <= q; i++) {
            state[i] += state[i-1];
            st = new StringTokenizer(input.readLine());
            int c = Integer.parseInt(st.nextToken());
            if (c == 4){
                int k = Integer.parseInt(st.nextToken());
                System.out.println(state[k]);
                current = previous[k];
                state[i] = state[k];
            }else if (c == 1){
                int ii = Integer.parseInt(st.nextToken())-1;
                int j = Integer.parseInt(st.nextToken())-1;
                state[i] += (current[ii] & (1<<j)) > 0 ? 0 : 1;
                current[ii] |= (1<<j);
            }else if (c == 2){
                int ii = Integer.parseInt(st.nextToken())-1;
                int j = Integer.parseInt(st.nextToken())-1;
                state[i] -= (current[ii] & (1<<j)) > 0 ? 1 : 0;
                current[ii] &= ~(1<<j);
            }else if (c == 3){
                int j = Integer.parseInt(st.nextToken())-1;
                state[i] += (m - Integer.bitCount(current[j])) - Integer.bitCount(current[j]);
                current[j] ^= (1<<m)-1;
            }

            if (c != 4)
                System.out.println(state[i]);
            previous[i] = current;
        }
    }
}
