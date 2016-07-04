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
        String line = input.readLine();
        String nextLine = input.readLine();
        while (nextLine != null && !nextLine.equals("")){
            int num = Integer.parseInt(line);
            ArrayList<Integer> read = calculate(num);
            System.out.println(read.get(0));
            for (int i = 1; i < read.size(); i+= 2) {
                System.out.printf("1/%d = 1/%d + 1/%d\n", num, read.get(i), read.get(i+1));
            }
            line = nextLine;
            nextLine = input.readLine();
        }
    }
}
