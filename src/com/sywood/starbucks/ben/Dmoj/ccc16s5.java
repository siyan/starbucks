package com.sywood.starbucks.ben.Dmoj;

import com.sywood.starbucks.ben.CodeForces.AIMTechRound3Div2.B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ben on 2016-10-09.
 */
public class ccc16s5 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long N = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        long start = Long.parseLong(input.readLine(), 2);
        for(int i = 60; i >=0; i--)if(((t>>i)&1) > 0){
            start = ((1L<<i))^(N-(1L<<i));
        }
        String ret = "";
        for (int i = 0; i < N; i++) {
            ret += "0";
        }
        System.out.println(ret.substring(0, Long.bitCount(start)+1) + Long.toBinaryString(start));
    }
}
