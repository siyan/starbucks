package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.ArrayList;

/**
 ID: benbli
 LANG: JAVA
 TASK: hamming
 */
public class hamming {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("hamming.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

        String[] data = input.readLine().split(" ");
        input.close();
        int N = Integer.parseInt(data[0]);
        int B = Integer.parseInt(data[1]);
        int D = Integer.parseInt(data[2]);


        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(0);
        boolean works;
        for(int i = 1; i < 1<<B && numbers.size() < N; i++){
            works = true;
            for(int num : numbers){
                if(Integer.bitCount(num^i) < D) {
                    works = false;
                    break;
                }
            }
            if(works)
                numbers.add(i);
        }

        String ret = "";

        for (int i = 0; i < numbers.size(); i++) {
            if(i%10 == 9){
                ret += numbers.get(i) + "\n";
            }else
                ret += numbers.get(i) + " ";
        }
        printer.println(ret.trim());

        printer.close();
    }
}
