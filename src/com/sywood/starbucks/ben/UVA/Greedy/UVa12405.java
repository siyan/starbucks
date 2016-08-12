package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * third basic greedy problem, underlined
 */

public class UVa12405 {
    public static void main(String[] args)throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine()), N, counter;
        char[] field;
        boolean[] covered;
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(input.readLine());
            field = input.readLine().toCharArray();
            covered = new boolean[N];
            counter = 0;

            if (N > 1){
                if (field[0] == '#' && field[1] == '.'){
                    covered[0] = true;
                    covered[1] = true;
                    counter++;
                }
                for (int j = 1; j < N-1; j++) {
                    boolean found = false;
                    if (field[j] == '#'){
                        if (field[j-1] == '.' && !covered[j-1]) {
                            covered[j - 1] = true;
                            counter++;
                            found=  true;
                        }
                        if (field[j+1] ==  '.' && !covered[j+1]){
                            covered[j+1] = true;
                            if (!found){
                                counter++;
                            }
                        }
                    }
                }
                if (field[N-1] == '#' && field[N-2] == '.' && !covered[field[N-2]]){
                    counter++;
                }
            }
            printer.printf("Case %d: %d\n", i, counter);
        }
        printer.close();
    }
}
