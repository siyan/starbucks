package com.sywood.starbucks.ben.CodeForces.Round372Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-09-17.
 */
public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());

        int counter = 1;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n; i++){
            counter++;
            if (data[i]-data[i-1] > c)
                counter = 1;
        }
        if (n == 1){
            System.out.println(1);
        }else
            System.out.println(counter);
    }
}
