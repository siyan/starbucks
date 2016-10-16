package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: combo
 */
public class combo {
    private static int[] john;
    private static int[] master;
    private static int N;

    private static boolean check(int a, int b){
        if(Math.abs(a-b) <= 2) return true;
        else if (Math.abs(a-b) >= N-2) return true;
        return false;
    }

    private static boolean valid(int[] combo){

        return (check(john[0], combo[0]) && check(john[1], combo[1]) && check(john[2], combo[2])) || (check(master[0], combo[0]) && check(master[1], combo[1]) && check(master[2], combo[2]));
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("combo.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        john = new int[3];
        for (int i = 0; i < 3; i++) {
            john[i] = Integer.parseInt(st.nextToken());
        }
        master = new int[3];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 3; i++) {
            master[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++){
                    int[] inp = new int[]{i, j, k};
                    if(valid(inp)) {
                        count++;
                    }
                }
            }
        }




        printer.println(count);
        printer.close();
        input.close();
    }
}
