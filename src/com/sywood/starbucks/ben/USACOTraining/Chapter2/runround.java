package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.BitSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: runround
 */
public class runround {
    private static boolean isRunaround(int num){
        int[] digits = new int[20];
        int at = 0;
        while(num != 0)
        {
            digits[at] = (int)(num%10);
            num/=10;
            at++;
        }
        int[] r = new int[at];

        boolean[] in = new boolean[10];
        for(int i = 0; i < at;i++)
        {
            r[i] = digits[i];
            if(in[r[i]]) return false;
            in[r[i]] = true;
        }
        boolean[] visited = new boolean[10];

        at = at-1;
        for(int i = r.length-1;;i--)
        {
            if(visited[r[at]]) return false;
            visited[r[at]] = true;

            at = (at - r[at]+r.length*10)%r.length;
            if(at == r.length-1) break;
        }
        for(int i = 0; i < 10;i++)
        {
            if(visited[i] != in[i]) return false;
        }
        return true;
    }
    private static boolean isUnique(int n){
        int used = 0;
        for(; n > 0; n /= 10){
            if((used & (1<<n%10)) > 0 || n%10 == 0)
                return false;
            used |= 1<<n%10;
        }
        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("runround.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int start = Integer.parseInt(input.readLine())+1;
        input.close();
        for(;;start++){
            if(isUnique(start) && isRunaround(start)){
                printer.println(start);
                break;
            }
        }
        printer.close();
    }
}
