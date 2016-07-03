package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class TrailerUVa10976 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (line != null){
            int num = Integer.parseInt(line);
            double target = 1.0/num;
            int count = 0;
            for (double a = (num+1)*num; a >= num*2; a--){
                for (double b = num+1; b <= num*2; b++){
                    if (1.0/a+1.0/b == target){
                        count++;
                    }
                }
            }
            System.out.println(count);
            for (double a = (num+1)*num; a >= num*2; a--){
                for (double b = num+1; b <= num*2; b++){
                    if ((a+b)/(a*b) == target){
                        System.out.printf("1/%01d = 1/%01d + 1/%01d\n", num, (int)a, (int)b);
                    }
                }
            }
            line = input.readLine();
        }
    }
}
