package com.sywood.starbucks.ben.UVA.CompleteSearch;

import java.io.*;
import java.util.ArrayList;
public class TrailerUVa10976 {
    private static ArrayList<Integer> calculate(int num){
        ArrayList<Integer> ret = new ArrayList<>();
        double target = 1.0/num;
        int count = 0;
        ret.add(count);
        for (double a = (num+1)*num; a >= num*2; a--){
            for (double b = num+1; b <= num*2; b++){
                if (1.0/a+1.0/b == target){
                    count++;
                    ret.add((int)a);
                    ret.add((int)b);
                }
            }
        }
        ret.set(0, count);
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        while (line != null && !line.equals("")) {
            int num = Integer.parseInt(line);
            ArrayList<Integer> read = calculate(num);
            printer.println(read.get(0));
            for (int i = 1; i < read.size(); i += 2) {
                printer.printf("1/%d = 1/%d + 1/%d\n", num, read.get(i), read.get(i + 1));
            }
            line = input.readLine();
        }
        printer.close();
    }
}
