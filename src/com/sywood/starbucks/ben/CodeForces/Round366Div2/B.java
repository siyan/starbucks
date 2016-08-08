package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(input.readLine());
        int parity = 0;

        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());

            if (t > 0){
                parity += t+1;
            }

            if (parity % 2 == 0){
                System.out.println(2);
                parity = 0;
            }else{
                System.out.println(1);
                parity = 1;
            }
        }

    }
}
