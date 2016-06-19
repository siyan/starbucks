package com.sywood.starbucks.ben.Euler.Twenties;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TwentyThree {
    private static ArrayList<Integer> abundantNums = new ArrayList<>();
    static Set<Integer> sums = new HashSet<>();
    private static boolean isAbundant(int num){
        int tot = 0;
        for (int i = 1; i < num; i++){
            if (num % i == 0){
                tot += i;
            }
        }
        return num < tot;
    }

    private static void genAbundant(){
        for (int i = 0; i < 28123; i++) {
            if (isAbundant(i)){
                abundantNums.add(i);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 1; i < 28123; i++) {
            ints.add(i);
        }
        genAbundant();
        for (int i = 0; i < abundantNums.size(); i++) {
            int x = abundantNums.get(i);
            for (int j = i; j < abundantNums.size(); j++){
                int y = abundantNums.get(j);
                int sum = x+y;
                sums.add(sum);
            }
        }
        System.out.println("done");
        int ret = 0;
        ints.removeAll(sums);
        for (int not : ints){
            ret += not;
        }
        System.out.println(ret);
    }
}
