package com.sywood.starbucks.ben.Euler.Twenties;

import java.util.HashMap;
import java.util.Map;

public class TwentySix {
    public static void main(String[] args) {
        System.out.println(run());
    }

    private static String run() {
        int bestNumber = 0;
        int bestLength = 0;
        for (int i = 1; i <= 1000; i++) {
            int len = getCycleLength(i);
            if (len > bestLength) {
                bestNumber = i;
                bestLength = len;
            }
        }
        return Integer.toString(bestNumber);
    }


    private static int getCycleLength(int n) {
        Map<Integer,Integer> stateToIter = new HashMap<Integer,Integer>();
        int state = 1;
        int iter = 0;
        while (!stateToIter.containsKey(state)) {
            stateToIter.put(state, iter);
            state = state * 10 % n;
            iter++;
        }
        return iter - stateToIter.get(state);
    }
}
