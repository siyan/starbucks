package com.sywood.starbucks.ben.UVA.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * first underlined dp problem
 */
public class UVa787 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null && !line.equals("")) {
            String[] data = line.split(" ");
            BigInteger product = BigInteger.valueOf(1);
            BigInteger answer = BigInteger.valueOf(Integer.parseInt(data[data.length-1]));
            for (int i = 0; i < data.length-1; i++) {
                for (int j = i; j < data.length-1; j++) {
                    product = product.multiply(BigInteger.valueOf(Integer.parseInt(data[j])));
                    if (product.compareTo(answer) == 1){
                        answer = product;
                    }
                }
                product = BigInteger.valueOf(1);
            }
            System.out.println(answer);
            line = input.readLine();
        }
    }
}
