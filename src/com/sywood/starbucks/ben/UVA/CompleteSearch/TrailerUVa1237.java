package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
import java.util.HashMap;

public class TrailerUVa1237 {
    private static String check(String[][] data, int num){
        boolean found = false;
        String ret = "UNDETERMINED";
        for (String[] info : data) {
            if (Integer.parseInt(info[1]) <= num && Integer.parseInt(info[2]) >= num && !found){
                found = true;
                ret = info[0];
            }else if(Integer.parseInt(info[1]) <= num && Integer.parseInt(info[2]) >= num && found){
                ret = "UNDETERMINED";
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        for (int i = 0; i < T; i++) {
            int D = Integer.parseInt(input.readLine());
            String[][] data = new String[D][];
            for (int j = 0; j < D; j++) {
                data[j] = input.readLine().split(" ");
            }
            int Q = Integer.parseInt(input.readLine());
            for (int j = 0; j < Q; j++) {
                int value = Integer.parseInt(input.readLine());
                System.out.println(check(data, value));
            }
        }
    }
}
