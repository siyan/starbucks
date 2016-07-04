package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
// FIXME: 2016-07-04 bugs with counting permutations and combos

public class UVa735 {
    private static ArrayList<int[]> stuff;
    private static int combos;
    private static int check(int a, int b, int c, int target){
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i*a + j*b + k*c == target){
                        count++;
                        int[] temp = new int[]{i*a, j*b, k*c};
                        Arrays.sort(temp);
                        boolean found = false;
                        for (int[] set : stuff){
                            if (Arrays.equals(temp, set)){
                                found = true;
                                break;
                            }
                        }
                        if (!found) combos++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(input.readLine());
        while(target > 0) {
            int perms = 0;
            stuff = new ArrayList<>();
            combos = 0;
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    for (int k = 1; k <= 20; k++) {
                        perms += check(i, j, k, target);
                    }
                }
            }
            if (combos > 0){
                System.out.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.", target, combos);
                System.out.printf("\nNUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", target, perms);
            }else{
                System.out.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", target);
            }
            System.out.println("**********************************************************************");
            target = Integer.parseInt(input.readLine());
        }
        System.out.print("END OF OUTPUT");
    }
}
