package com.sywood.starbucks.ben.Dmoj.TLENov2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-11-17.
 */
public class P2 {
    private static long calcPoly(int[] arr, long x){
        long ret = 0;
        for(int i = 0; i < arr.length; i++)
            ret += (long) (Math.pow(x, arr.length-i))*arr[i];
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] data = input.readLine().split(" ");
        int P = Integer.parseInt(data[0]);
        int N = Integer.parseInt(data[1]);
        int V = Integer.parseInt(data[2]);
        int R = Integer.parseInt(data[3]);
        long[] px = new long[P];
        long py[] = new long[P];

        for (int i = 0; i < P; i++) {
            data = input.readLine().split(" ");
            px[i] = Integer.parseInt(data[0]);
            py[i] = Integer.parseInt(data[1]);
        }
        int[] coeff = new int[N];
        for (int i = 0; i < N; i++) {
            coeff[i] = Integer.parseInt(input.readLine());
        }
        long counter = 0;
        long centerX = V;
        long centerY = calcPoly(coeff, V);
        for (int i = 0; i < P; i++) {
            if(calcPoly(coeff, px[i]) == py[i] && px[i] < V ||
                    ((px[i]-centerX)*(px[i]-centerX) + (py[i]-centerY)*(py[i]-centerY) <= R*R)){
                //System.out.println(px[i] + ", " + py[i]);
                counter++;
            }
        }
        System.out.println(counter);
    }
}
