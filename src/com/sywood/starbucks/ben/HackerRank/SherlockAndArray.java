package com.sywood.starbucks.ben.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-10.
 */
public class SherlockAndArray {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(input.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(input.readLine());
            int[] nums = new int[N+1];
            st = new StringTokenizer(input.readLine());
            nums[0] = 0;
            for(int i = 1; i < N+1; i++){
                nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
            }
            boolean found = false;
            for(int i = 1; i <= N; i++){
                if (nums[i-1] == nums[N] - nums[i]) {
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("NO");
        }
    }
}
