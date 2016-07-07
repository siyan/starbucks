package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;

public class unhappy {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0 0")){
            String[] data = line.split(" ");
            int lo = Integer.parseInt(data[0]);
            int hi = Integer.parseInt(data[1]);
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                System.out.println(i);
                String currentDigits = Integer.toString(i);
                int curr = i;
                while (curr != 1){
                    int digitSum = 0;
                    int temp  = curr;
                    while (temp > 1){
                        digitSum += (temp%10)*(temp%10);
                        temp /= 10;
                    }
                    currentDigits += Integer.toString(digitSum);
                    String repeated = currentDigits.replaceAll("(.+?)\\1+", "$1");
                    String[] repeats = currentDigits.split(repeated);
                    System.out.println(repeated);
                    if (!repeated.equals(digitSum) && repeats.length == 1 && repeats[0].length() < currentDigits.length()-(repeated.length()*2)){
                        count++;
                        break;
                    }
                    curr = digitSum;
                }
            }
            System.out.println(count);
            line = input.readLine();
        }
    }
}
