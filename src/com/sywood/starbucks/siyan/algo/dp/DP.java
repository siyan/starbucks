package com.sywood.starbucks.siyan.algo.dp;

/**
 * Created by siyan on 2016-03-18.
 */
public class DP {

    static int[] prices = new int[]{2, 5, 6, 9, 10, 11, 19};


    static int logTD(int n){

        if (n == 0){
            return 0;
        }
        else if (n == 1) {
            return prices[0];
        }
        else{
            if (memoize[n-1] != 0 ) {
                return memoize[n-1];
            }

            int max = 0;

            for (int i = 0; i < n; i++){
                int val = prices[i] + logTD( n - i - 1);
                max = Math.max( max, val );
            }

            memoize[n-1] = max;
            return max;
        }
    }

    static int[] memoize;
    public static void main(String[] args){
        memoize = new int[prices.length];
        System.out.println(logTD( prices.length ));
    }
}
