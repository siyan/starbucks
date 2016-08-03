package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Second bitset question.
 */
public class UVa11926 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        int start, end, m, n, interval;
        boolean[] values;
        boolean conflict;

        while(!line.equals("0 0")){
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            values = new boolean[1000001];
            conflict = false;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(input.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                for(int j = start; j < end; j++){
                    if(values[j]){
                        conflict = true;
                        break;
                    }
                    values[j] = true;
                }
            }

            if(!conflict){
                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(input.readLine());
                    start = Integer.parseInt(st.nextToken());
                    end = Integer.parseInt(st.nextToken());
                    interval = Integer.parseInt(st.nextToken());
                    while(end <= 1000000){
                        for(int j = start; j < end; j++){
                            if(values[j]){
                                conflict = true;
                                break;
                            }
                            values[j] = true;
                        }
                        start += interval;
                        end += interval;
                    }
                }
            }
            if (!conflict){
                printer.println("NO CONFLICT");
            }else{
                printer.println("CONFLICT");
            }
            line = input.readLine();

        }
        printer.close();
    }
}
