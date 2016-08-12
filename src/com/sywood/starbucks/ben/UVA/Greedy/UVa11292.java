package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Second underlined sorted greedy problem
 */
public class UVa11292 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        int n, m, idx, cost;
        int[] dragons;
        int[] knights;
        boolean[] taken;
        boolean found;
        String line = input.readLine();
        while(!line.equals("0 0")){
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dragons = new int[n];
            knights = new int[m];
            taken = new boolean[m];
            for (int i = 0; i < n; i++) {
                dragons[i] = Integer.parseInt(input.readLine());
            }
            for (int i = 0; i < m; i++) {
                knights[i] = Integer.parseInt(input.readLine());
            }
            Arrays.sort(dragons);
            Arrays.sort(knights);
            if (m < n){
                printer.println("Loowater is doomed!");
            }else{
                cost = 0;
                found = false;
                for(int dragon : dragons){
                    found = false;
                    for(int i = 0; i < m; i++){
                        if (knights[i] >= dragon && !taken[i]){
                            cost += knights[i];
                            taken[i] = true;
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        break;
                    }
                }
                if (!found){
                    printer.println("Loowater is doomed!");
                }else{
                    printer.println(cost);
                }
            }
            line = input.readLine();
        }
        printer.close();
    }
}
