package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * second underlined greedy problem
 *
 */
public class UVa11389 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        String line = input.readLine();
        int n, d, r, total, t;
        ArrayList<Integer> morning, afternoon;
        while(line != null && !line.equals("")){
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            total = 0;
            morning = new ArrayList<>();
            afternoon = new ArrayList<>();
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                morning.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                afternoon.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(morning);
            Collections.sort(afternoon, Collections.<Integer>reverseOrder());
            for (int i = 0; i < n; i++) {
                t = morning.get(i) + afternoon.get(i);
                if (t > d){
                    total += (t-d)*r;
                }
            }
            printer.println(total);

            line = input.readLine();
        }
        printer.close();
    }
}
