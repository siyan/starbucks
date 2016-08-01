package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Second underlined Collections Question
 */
public class UVa10107 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        ArrayList<Integer> nums = new ArrayList<>();
        while(line != null && !line.equals("")){
            int num = Integer.parseInt(line.trim());
            nums.add(num);
            Collections.sort(nums);
            if(nums.size()%2 == 0){
                printer.print((nums.get(nums.size()/2-1) + nums.get(nums.size()/2))/2+"\n");
            }else{
                printer.print((nums.get(nums.size()/2)+"\n"));
            }
            line = input.readLine();
        }
        printer.close();
    }
}
