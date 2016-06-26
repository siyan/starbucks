package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa00441 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String lines = input.readLine();
        while (!lines.equals("0")){
            String[] nums = lines.split(" ");
            int k = Integer.parseInt(nums[0])+1;
            for (int a = 1; a < k-5; a++){
                for (int b = a+1; b < k-4; b++){
                    for (int c = b+1; c < k-3; c++){
                        for (int d = c+1; d < k-2; d++){
                            for (int e = d+1; e < k-1; e++){
                                for (int f = e+1; f < k; f++){
                                    System.out.printf("%s %s %s %s %s %s\n", nums[a], nums[b], nums[c], nums[d], nums[e], nums[f]);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
            lines = input.readLine();
        }
    }
}
