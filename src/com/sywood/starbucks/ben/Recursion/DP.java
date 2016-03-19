package com.sywood.starbucks.ben.Recursion;

public class DP {
    static int[] memoize;
    static int[] prices = new int[]{2,5,8,9,10};
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
                max = ((prices[i - 1] + logsRec(n - i)) > max) ? (prices[i - 1] + logsRec(n - i)) : max;
            }
            return max;
        }
    }
    static int logBottomsUp(int n){
        for (int i = 0; i < n; i++){
            if (i == 0){
                memoize[i] = prices[i];
            }else{
                if (memoize[n-1] != 0){
                    return memoize[n-1];
                }
                for (int j = 0; j < i ; j++) {
                    int temp = prices[j] + logBottomsUp(i - j);
                    if (temp > memoize[i]) {
                        System.out.println(i + ", " + (i-j));
                        memoize[i] = temp;
                    }
                }
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
        System.out.println(logBottomsUp(5));
    }
}
