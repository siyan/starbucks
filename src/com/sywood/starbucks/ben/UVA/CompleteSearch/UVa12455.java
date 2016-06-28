package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa12455 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        for (int a = 0; a < t; a++) {
            int target = Integer.parseInt(input.readLine());
            int n = Integer.parseInt(input.readLine());
            int[] bars = new int[n];
            int each = 0;
            boolean found = false;
            for (String bar : input.readLine().split(" ")){
                bars[each] = Integer.parseInt(bar);
                each++;
            }
            for (int i = 0; i < 1<<n; i++){
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if ((i>>j)%2 == 1){
                        sum += bars[j];
                    }
                }
                if (sum == target){
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            if (!found){
                System.out.println("NO");
            }
        }
    }
}
