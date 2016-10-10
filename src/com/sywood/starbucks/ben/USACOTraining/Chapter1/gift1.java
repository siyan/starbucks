package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
ID: benbli
LANG: JAVA
TASK: gift1
 */
public class gift1 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("gift1.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int N = Integer.parseInt(input.readLine());
        ArrayList<String> names = new ArrayList<String>();
        HashMap<String, Integer> idx = new HashMap<String, Integer>();
        int[] accounts = new int[N];
        for (int i = 0; i < N; i++) {
            names.add(input.readLine());
            idx.put(names.get(i), i);
        }

        for (int i = 0; i < N; i++) {
            String person = input.readLine();
            String[] data = input.readLine().split(" ");
            int money = Integer.parseInt(data[0]);
            int ppl = Integer.parseInt(data[1]);
            if (ppl != 0) {
                int add = money / ppl;
                int leftOver = add * ppl;
                accounts[idx.get(person)] -= leftOver;

                for (int j = 0; j < ppl; j++) {
                    accounts[idx.get(input.readLine())] += add;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            printer.println(names.get(i) + " " + accounts[i]);
        }

        printer.close();
    }
}
