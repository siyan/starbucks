package com.sywood.starbucks.ben.DadsWork;

public class FibDP {
    static long[] vals;
    static long bottomUp(int n){
        for (int i = 0; i < n; i++){
            if (i == 0 || i == 1) vals[i] = 1;
            else{
                vals[i] = vals[i-1] + vals[i-2];
            }
        }
        return vals[n-1];
    }
    static long topDown(int n){
        if (n == 0 || n == 1){
            return 1;
        }else{
            if (vals[n] == 0){
                vals[n] = topDown(n-1) + topDown(n-2);
            }
            return vals[n];
        }
    }

    public static void main(String[] args){
        int n = 100;
        vals = new long[n];
        System.out.println(topDown(n-1));
    }
}
