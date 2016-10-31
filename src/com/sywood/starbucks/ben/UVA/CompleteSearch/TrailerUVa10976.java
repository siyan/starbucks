package com.sywood.starbucks.ben.UVA.CompleteSearch;

import java.io.*;
import java.util.ArrayList;
public class TrailerUVa10976 {
    private static ArrayList<Integer> calculate(int num){
        ArrayList<Integer> ret = new ArrayList<>();

        for(int i = num+1; i <= num+num; i++){
            if((i*num)%(i-num) == 0){
                ret.add((i*num)/(i-num));
                ret.add(i);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        while (line != null && !line.equals("")) {
            int num = Integer.parseInt(line);
            ArrayList<Integer> read = calculate(num);
            printer.println(read.size()/2);
            for (int i = 0; i < read.size(); i += 2) {
                printer.printf("1/%d = 1/%d + 1/%d\n", num, read.get(i), read.get(i + 1));
            }
            line = input.readLine();
        }
        printer.close();
    }
}
