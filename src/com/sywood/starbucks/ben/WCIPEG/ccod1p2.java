package com.sywood.starbucks.ben.WCIPEG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ccod1p2 {
    private static boolean toBase(long decimal, long base){
        ArrayList<Long> ret = new ArrayList<>();
        for (long i = decimal; i != 0; i /= base) {
            ret.add(i%base);
        }
        for (int i = 0; i < ret.size()/2; i++) {
            long t1 = ret.get(i), t2 = ret.get(ret.size()-1-i);
            if(t1 != t2)
                return false;
        }
        return true;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        long N = Long.parseLong(input.readLine());
        long base;
        for(base = 2; base*base <= N; base++){
            //System.out.println(curr);
            if(toBase(N, base))
                printer.println(base);
        }
        while(base*base+base >= N)base--;

        for(;base > 0; base--){
            if(N%base == 0) printer.println(N/base-1);
        }
        printer.close();
    }
}
