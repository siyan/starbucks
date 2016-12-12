package com.sywood.starbucks.ben.SIUCFcompetitions.HSPT2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * Created by Ben on 2016-12-10.
 */
public class stacks {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for(int i = 1; i <= n; i++){
            System.out.print("Row #" + i + ": Jerry needs to add a minimum of ");
            int m = Integer.parseInt(input.readLine());
            String data[] = input.readLine().split(" ");
            int[] coins = new int[m];
            BitSet parity = new BitSet(m);
            BitSet startOne = new BitSet(m);
            BitSet startZero = new BitSet(m);
            boolean curr = true;
            for (int j = 0; j < m; j++) {
                startOne.set(j, curr);
                startZero.set(j, !curr);
                curr = !curr;
            }
            for (int j = 0; j < m; j++) {
                coins[j] = Integer.parseInt(data[j]);
                parity.set(j, coins[j]%2 == 0);
            }
            BitSet copy = (BitSet) parity.clone();
            copy.xor(startOne);
            int min = copy.cardinality();
            copy = (BitSet) parity.clone();
            copy.xor(startZero);
            min = Math.min(min, copy.cardinality());
            System.out.println(min + " coins");

        }
    }
}
