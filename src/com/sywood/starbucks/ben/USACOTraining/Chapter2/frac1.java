package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.TreeSet;

/**
 ID: benbli
 LANG: JAVA
 TASK: frac1
 */
public class frac1 {
    private static class fraction implements Comparable<fraction> {
        double num;
        double denom;
        public fraction(int num, int denom){
            this.num = num/gcf(num, denom);
            this.denom = denom/gcf(num, denom);
        }

        public int compareTo(fraction other){
            if((num/denom) < (other.num/other.denom))
                return -1;
            else if(num/denom > other.num/other.denom)
                return 1;
            return 0;
        }

        public String toString(){
            return ((int)num) + "/" + ((int)denom);
        }
    }

    private static int gcf(int a, int b){
        if(b == 0)
            return a;
        return gcf(b, a%b);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("frac1.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        int N = Integer.parseInt(input.readLine());
        input.close();
        TreeSet<fraction> fractions = new TreeSet<fraction>();

        for(int denom = 1; denom <= N; denom++){
            for(int num = 0; num <= denom; num++)
                fractions.add(new fraction(num, denom));
        }

        for(fraction t : fractions)
            printer.println(t.toString());


        printer.close();
    }
}
