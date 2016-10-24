package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * second DP problem, not actually DP
 */
public class ANARC09A {

    private static int isValid(String inp){
        int counter = 0;
        int changed = 0;
        //System.out.println(inp);
        for (int i = 0; i < inp.length(); i++) {
            if(inp.charAt(i) == '{')
                counter++;
            else if(counter > 0) counter--;
            else{
                counter++;
                changed++;
            }
        }
        changed += counter/2;
        return changed;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int counter = 1;
        while(!line.contains("-")){
            //System.out.println(isValid(line));
            //System.out.println();
            System.out.println(counter++ + ". " + isValid(line));
            //System.out.println();
            line = input.readLine();
        }
    }
}
