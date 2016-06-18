package com.sywood.starbucks.ben.Euler.Thirties;
import java.util.ArrayList;

public class ThirtyNine {
    private static long findNum(){
        long ret = 0;
        long resultSolutions = 0;
        for (long p = 2; p <= 1000; p += 2){
            int numOfSolutions = 0;
            for (long a = 2; a < (p/3); a++) {
                if (p * (p - 2 * a) % (2*(p-a)) == 0){
                    numOfSolutions++;
                }
            }
            if (numOfSolutions > resultSolutions){
                resultSolutions = numOfSolutions;
                ret = p;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        System.out.println(findNum());
    }
}
