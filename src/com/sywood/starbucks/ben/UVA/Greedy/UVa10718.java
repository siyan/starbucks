package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Second underlined non-classical greedy problem
 */
public class UVa10718 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        long N, L, U;//l is lower and U is upper
        long M, best;
        while(line != null && !line.equals("")){
            st = new StringTokenizer(line);
            N = Long.parseLong(st.nextToken());
            L = Long.parseLong(st.nextToken());
            U = Long.parseLong(st.nextToken());
            M = 0;
            best = Long.MAX_VALUE;
            for (long p = 31; p >= 0; --p) {
                long nowM = M | (1L << p);
                if (nowM > U) continue;
                if (nowM <= L) {
                    M = nowM;
                    if (M < best)
                        best = M;
                } else if (nowM <= U && nowM >= L) {
                    if ((M | N) == (nowM | N)) {
                        if (M < best) best = M;
                    } else {
                        M = nowM;
                        best = M;
                    }
                }
            }
            printer.println(M);
            line = input.readLine();
        }
        printer.close();
    }
}
