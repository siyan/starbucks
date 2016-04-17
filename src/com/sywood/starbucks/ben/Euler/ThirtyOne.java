package com.sywood.starbucks.ben.Euler;

public class ThirtyOne {
    static long[] memoize = new long[200];
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

    public static void main(String[] args){
        System.out.println(calculate(200));
    }
}
