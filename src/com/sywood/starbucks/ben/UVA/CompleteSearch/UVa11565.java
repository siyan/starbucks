package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;

public class UVa11565 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        for(int i = 0; i < N; i++){
            String[] stats = input.readLine().split(" ");
            int A = Integer.parseInt(stats[0]);
            int B = Integer.parseInt(stats[1]);
            int C = Integer.parseInt(stats[2]);
            boolean found = false;
            for (int x = -100; x <= 100; x++){
                for(int y = -100; y <= 100; y++){
                    for (int z = -100; z <= 100; z++){
                        if (z != y && y != x && x != z && x*x + y*y + z*z == C && x*y*z == B && x + y + z == A && !found){
                            System.out.printf("%d %d %d\n", x, y, z);
                            found = true;
                        }
                    }
                }
            }
            if (!found){
                System.out.println("No solution.");
            }
        }
    }
}
