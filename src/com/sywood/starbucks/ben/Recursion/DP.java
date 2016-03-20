package com.sywood.starbucks.ben.Recursion;

public class DP {
    static int[] memoize;
    static int[] prices = new int[]{2, 5, 6};//, 9, 10, 11, 19};
    static int findMin(int n){
        if (n == 1){
            return 0;
        }else{
            if(memoize[n-1] == 0){
                int max = 1+findMin(n-1);
                if (n%2 == 0) {
                    max = Math.min(max, 1+findMin(n / 2));
                }if (n%3 == 0){
                    max = Math.min(max, 1+findMin(n/3));
                }
                memoize[n-1] = max;
            }
            return memoize[n-1];
        }
    }
    static int bottomUp(int n){
        memoize[0] = 0;
        for (int i = 1; i < n; i++){
            memoize[i] = memoize[i-1]+1;
            if (i%2 == 0){
                memoize[i] = Math.min(memoize[i], 1+memoize[i/2]);
            }if (i % 3 == 0){
                memoize[i] = Math.min(memoize[i], 1+memoize[i/3]);
            }
        }
        return memoize[n-1];
    }
    static int logsRec(int n){
        if (n == 1){
            return prices[n-1];
        }else if (n < 1){
            return 0;
        }else{
            int max = 0;
            for (int i = 1; i <= n; i++){
                max = Math.max(prices[i - 1] + logsRec(n - i) , max);
            }
            return max;
        }
    }
    static int logBottomsUp(int n){
        memoize[0] = prices[0];
        for (int i = 0; i < n; i++){
            int max = 0;
            for (int j = 0; j < i; j++) {
                int temp;
                temp = prices[j] + memoize[i - j];
                System.out.println(j + " " + prices[j] + ", " + (i - j) + " " + prices[i - j]);
                max = Math.max(max, temp);
            }
            memoize[i] = max;
        }
        return memoize[n-1];
    }
    static int logDP(int n){
        if (n == 1){
            return prices[n-1];
        }else if (n < 1){
            return 0;
        }else{
            if (memoize[n-1] != 0){
                return memoize[n-1];
            }
            int max = 0;
            for (int i = 0; i < n; i++){
                int temp = prices[i] + logDP(n-i-1);
                max = Math.max(max, temp);
            }
            memoize[n-1] = max;
            return memoize[n-1];
        }
    }

    public static void main(String[] args){
        memoize = new int[prices.length];
        System.out.println(logBottomsUp(prices.length));
    }
}
