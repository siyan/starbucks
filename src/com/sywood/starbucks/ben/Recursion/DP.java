package com.sywood.starbucks.ben.Recursion;

public class DP {
    static int[] memoize;
    static int[] prices = new int[]{2,5,6,9,10};
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
                /*
                System.out.println(" loop: " + n + ", " + i);
                if (memoize[n-i] == 0){
                    memoize[n-i] = prices[i-1] + logs(n-i);
                    System.out.println(n-i + ", " + memoize[n-i]);
                }
                */
                max = prices[i-1] + logsRec(n-i) > max ? prices[i-1] + logsRec(n-i) : max;
            }
            return max;
        }
    }
    static int logBottomsUp(int n){
        for (int i = 1; i <= n; i++){
            if (i == 1){
                memoize[i-1] = prices[i-1];
            }else{
                memoize[i-1] = prices[i-1] + memoize[n-i];
            }
        }
        return memoize[n-1];
    }
    static int logDP(int n){
        if (n == 1){
            return prices[n-1];
        }else if (n < 1){
            return 0;
        }else{
            int max = 0;
            for (int i = 1; i <= n; i++){
                memoize[i-1] = memoize[i-1] > prices[i-1] + memoize[n-i] ? memoize[i-1] : prices[i-1] + memoize[n-i];
            }
            return memoize[n-1];
        }
    }

    public static void main(String[] args){
        memoize = new int[5];
        System.out.println(logDP(5));
    }
}
