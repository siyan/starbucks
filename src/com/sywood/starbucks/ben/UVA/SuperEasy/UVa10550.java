package com.sywood.starbucks.ben.UVA.SuperEasy;
import java.io.*;

public class UVa10550 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0 0 0 0")){
            int totDegrees = 360*2;
            String[] nums = line.split(" ");
            int[] degrees = new int[4];
            for (int i = 0; i < 4; i++) {
                degrees[i] = (Integer.parseInt(nums[i]))*360/40;
            }
            totDegrees += degrees[1] - degrees[0];
            totDegrees += 360;
            totDegrees += degrees[2];
            totDegrees += degrees[3];
            System.out.println(totDegrees);
            line = input.readLine();
        }
    }
}
