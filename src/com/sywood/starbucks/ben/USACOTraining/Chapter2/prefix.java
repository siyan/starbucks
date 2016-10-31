package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: prefix
 */
public class prefix {
    private static ArrayList<String> strs;
    private static int max(int a, int b){
        return a > b ? a : b;
    }

    private static int recurse(String curr, int total){
        int longest = 0;
        if(curr.equals(""))
            return total;

        for(String str : strs){
            if(curr.indexOf(str) != 1)
                longest = max(longest, recurse(curr.replaceFirst(str, ""), total+1));
        }
        return longest;
    }

    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner((System.in));
        PrintWriter printer = new PrintWriter(System.out);
        strs = new ArrayList<String>();
        String str = input.next();
        for(; !str.equals(".");str = input.next())
            strs.add(str);
        String target = input.next();

        printer.println(recurse(target, 0));
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i){
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if (st.hasMoreTokens()){
                return st.nextToken();
            }else{
                st = new StringTokenizer(br.readLine());
            }
            return next();
        }
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        public String readLine() throws IOException{
            return br.readLine();
        }
    }
}
