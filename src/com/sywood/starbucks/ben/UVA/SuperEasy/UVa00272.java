package com.sywood.starbucks.ben.UVA.SuperEasy;
import java.io.*;

public class UVa00272 {
    private static String process(String line){
        String ret = "";
        int counter = 0;
        for (char let : line.toCharArray()){
            if (let == '\"'){
                if (counter++ % 2 == 0){
                    ret += "``";
                }else{
                    ret += "''";
                }
            }else{
                ret += let;
            }
        }
        return ret;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        String i = input.readLine();

        while (i != null && !i.equals("\n") && !i.equals("")){
            line += i;
            line += "\n";
            i = input.readLine();
        }
        System.out.print(process(line));
    }
}
