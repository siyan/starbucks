package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
import java.util.HashSet;
import java.util.Arrays;
//TODO optimize, code is to slow.

public class UVa735 {
    private static int countCombos(HashSet<int[]> combos){
        int count = 0;
        boolean similar = false;
        int i = 0;
        for(int[] combo : combos){
            int j = 0;
            for (int[] other : combos){
                if (Arrays.equals(combo, other) && i != j && i < j){
                    similar = true;
                    break;
                }
                j++;
                similar = false;
            }
            if (!similar){
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(input.readLine());
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i <= 20; i++) {
            numbers.add(i);
            numbers.add(i*2);
            numbers.add(i*3);
        }
        numbers.add(50); // add a bullseye to the set of possible scores
        int[] temp;
        while(target > 0) {
            HashSet<int[]> combos = new HashSet<>();
            int permutations = 0;
            for (int a : numbers){
                for (int b : numbers){
                    for (int c : numbers){
                        if (a+b+c == target){
                            permutations++;
                            temp = new int[]{a, b, c};
                            Arrays.sort(temp);
                            combos.add(temp);
                        }
                    }
                }
            }
            int numCombos = countCombos(combos);
            if (numCombos > 0){
                System.out.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", target, numCombos);
                System.out.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", target, permutations);
            }else{
                System.out.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", target);
            }
            System.out.print("**********************************************************************\n");
            target = Integer.parseInt(input.readLine());
        }
        System.out.print("END OF OUTPUT");
    }
}