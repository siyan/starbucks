package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
/**
 *
 */
public class TrailerUVa10487 {
    private static int closest(int[] ints, int target){
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << ints.length; i++) {
            int counter = 0;
            int sum = 0;
            for (int j = 0; j < ints.length; j++) {
                if ((i>>j)%2 == 1){
                   // System.out.printf("%d + ", ints[j]);
                    sum += ints[j];
                    counter++;
                }
            }
            //System.out.printf(" = %d\n", sum);
            if (counter >= 2 && Math.abs(target-sum) < Math.abs(target-current)){
                current = sum;
            }
        }
        return current;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int num = 1;
        while (!line.equals("0")) {
            System.out.printf("Case %d:\n", num);num++;
            int n = Integer.parseInt(line);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(input.readLine());
            }
            int m = Integer.parseInt(input.readLine());
            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(input.readLine());
                System.out.printf("Closest sum to %d is %d.\n", target, closest(ints, target));
            }
            line = input.readLine();
        }
    }
}
