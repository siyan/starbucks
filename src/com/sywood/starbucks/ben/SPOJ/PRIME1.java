package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Created by Ben on 2016-10-02.
 */
public class PRIME1 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        PrintWriter printer = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            String data[] = input.readLine().split(" ");
            long start = Long.parseLong(data[0]);
            long end = Long.parseLong(data[1]);
            for(long ii = start; ii <= end; ii++)
                if(BigInteger.valueOf(ii).isProbablePrime(4))
                    printer.println(ii);

            printer.println();
        }

        printer.close();
    }
}
