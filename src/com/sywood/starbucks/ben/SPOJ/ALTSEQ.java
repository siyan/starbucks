package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-10-02.
 */
public class ALTSEQ {
    static public ArrayList<Integer> lds(int[] A) {
        int[] m = new int[A.length];
        //Arrays.fill(m, 1);//not important here
        for (int x = A.length - 2; x >= 0; x--) {
            for (int y = A.length - 1; y > x; y--) {
                if (m[x] <= m[y] && Math.abs(A[x]) < Math.abs(A[y]) && (A[x] < 0 && A[y] > 0 || A[x] > 0 && A[y] < 0)) {
                    m[x]= m[y]+1;//or use m[x]++
                }
            }
        }
        int max = m[0];
        for (int i = 0; i < m.length; i++) {
            if (max < m[i]) {
                max = m[i];
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < m.length; i++) {
            if (max == m[i]) {
                result.add(A[i]);
                max--;
            }
        }
        return result;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] inp = new int[n];
        for (int i = 0; i < n; i++) {
            inp[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(lds(inp).size());
    }
}
