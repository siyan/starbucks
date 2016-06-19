package com.sywood.starbucks.ben.Euler.Thirties;

public class ThirtyOne {
    static long[] memoize = new long[200];
    static int[] coinSizes = new int[]{ 1, 2, 5, 10, 20, 50, 100, 200 };
    static long[] bottomUp;
    private static long calculate(int money){
        if (money == 0){
            return 1;
        }else{
            if (memoize[money-1] != 0){
                return memoize[money-1];
            }
            long ways = 0;
            if (money - 1 >= 0){
                ways += calculate(money-1);
            }if (money-2>=0){
                ways += calculate(money-2);
            }if (money-5 >= 0){
                ways += calculate(money-5);
            }if (money-10 >= 0){
                ways += calculate(money-10);
            }if (money-20 >= 0){
                ways += calculate(money-20);
            }if (money-50 >= 0){
                ways += calculate(money-50);
            }if(money-100 >= 0){
                ways += calculate(money-100);
            }if(money-200 >= 0){
                ways += calculate(money-200);
            }
            memoize[money-1] = ways;
            return memoize[money-1];
        }
    }
    private static long dpUp(int money){
        bottomUp = new long[money+1];
        bottomUp[0] = 1;

        for (int i = 0; i < coinSizes.length; i++) {
            for (int j = coinSizes[i]; j <= money; j++) {
                bottomUp[j] += bottomUp[j - coinSizes[i]];
            }
        }

        return bottomUp[money];
    }

    public static void main(String[] args){
        System.out.println(dpUp(200));
    }
}
