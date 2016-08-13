package com.sywood.starbucks.ben.UVA.Greedy;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Final underlined non-classical greedy
 */
public class UVa11157 {
    public static void main(String args[])throws Exception{
        int NumberOfRocks, Distance;
        String[] LineRocks;
        ArrayList<Integer> V;
        Scanner input = new Scanner(System.in);
        int Cases = 1;

        int TestCases = input.nextInt();
        while(TestCases-- > 0){
            NumberOfRocks = input.nextInt();
            Distance	  = input.nextInt();
            V 			  = new ArrayList<Integer>();

            V.add(0);	V.add(0);

            for(int i = 0; i < NumberOfRocks; i++){
                LineRocks = input.next().split("-", -1);
                int D = Integer.parseInt(LineRocks[1]);
                V.add(D);
                if(LineRocks[0].equals("B"))
                    V.add(D);
            }
            V.add(Distance);	V.add(Distance);

            int Result = -10000000;
            for(int i = 2; i < V.size(); i++){
                Result = Math.max(Result, V.get(i) - V.get(i - 2));
            }
            System.out.printf("Case %d: %d\n", Cases++, Result);
        }

    }
}
