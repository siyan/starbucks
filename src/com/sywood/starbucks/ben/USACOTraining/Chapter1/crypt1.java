package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Ben on 2016-10-13.
 */
public class crypt1 {
    private static int[] digits;
    private static TreeSet<Integer> threeDig = new TreeSet<Integer>();
    private static TreeSet<Integer> twoDig = new TreeSet<Integer>();


    private static void build(String curr){
        if(curr.length() == 3)
            threeDig.add(Integer.parseInt(curr));
        else{
            if(curr.length() == 1)
                for (int i = 0; i < digits.length; i++) {
                    build(curr + digits[i]);
                    twoDig.add(Integer.parseInt(curr+digits[i]));
                }
            else
                for (int i = 0; i < digits.length; i++) {
                    build(curr + digits[i]);
                }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);

        int N  = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());

        digits = new int[N];
        boolean[] possible = new boolean[10];

        for (int i = 0; i < N; i++) {
            digits[i] = Integer.parseInt(st.nextToken());
            possible[digits[i]] = true;
        }
        build("");

        int count = 0;
        boolean invalid;
        for(int three : threeDig){
            for(int two : twoDig) {
                if (Integer.toString(three * (two % 10)).length() == 3 && Integer.toString(three * (two / 10)).length() == 3 && Integer.toString(three * two).length() == 4){
                    invalid = false;
                    for (int i = three; i > 0; i /=10) {
                        if (!possible[i % 10]) {
                            invalid = true;
                            break;
                        }
                    }
                    if(invalid)
                        continue;
                    for (int i = two; i > 0; i /= 10) {
                        if(!possible[i%10]){
                            invalid = true;
                            break;
                        }
                    }
                    if(invalid)
                        continue;
                    int t = three*two;
                    for (int i = 0; i < 4; i++) {
                        if(!possible[t%10]){
                            invalid = true;
                            break;
                        }
                        t /= 10;
                    }
                    if(invalid)
                        continue;
                    System.out.println(three + ", " + two + ", " + (three*two));
                    count++;
                }else
                    break;
            }
        }
        printer.println(count);
        printer.close();
        input.close();
    }
}
