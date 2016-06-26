package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa725 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        while (N != 0) {
            boolean found = false;
            for (int fghij = 1234; fghij <= 98765; fghij++) {
                int temp;
                int abcde = fghij*N;
                if (abcde <= 98765) {
                    int used = 0;
                    if (fghij < 10000) {
                        used |= 1;
                    }
                    temp = abcde;
                    while (temp > 0) {
                        used |= 1 << temp % 10;
                        temp /= 10;
                    }
                    temp = fghij;
                    while (temp > 0) {
                        used |= 1 << temp % 10;
                        temp /= 10;
                    }
                    if (used == (1 << 10) - 1) {
                        found = true;
                        System.out.printf("%05d / %05d = %d\n", abcde, fghij, N);
                    }
                }
            }
            if (!found){
                System.out.println("There are no solutions for " + N + ".");
            }
            System.out.print("\n");
            N = Integer.parseInt(input.readLine());
        }
        System.out.print("\n");
    }
}
