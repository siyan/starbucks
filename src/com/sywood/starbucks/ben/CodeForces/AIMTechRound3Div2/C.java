package com.sywood.starbucks.ben.CodeForces.AIMTechRound3Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-08-24.
 */
public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int length = line.length();
        if (length > 1) {
            int start = -1;
            int subLength = 0;
            for (int i = 0; i < length; i++) {
                if (line.charAt(i) > 'a' && start == -1) {
                    start = i;
                    subLength++;
                } else if (start > -1 && line.charAt(i) > 'a') {
                    subLength++;
                } else if (start > -1 && line.charAt(i) == 'a') {
                    break;
                }
            }
            if (start > -1) {
                String ret = line.substring(0, start);
                String process = line.substring(start, subLength);
                if (subLength > 1) {
                    for (int i = 0; i < subLength; i++) {
                        ret += (char) (process.charAt(i) - 1);
                    }
                    ret += line.substring(start + subLength);
                } else if (subLength == 1) {
                    ret += (char) (line.charAt(start) - 1);
                    ret += line.substring(start + subLength);
                } else {
                    ret = line.substring(0, length - 1);
                    ret += 'z';
                }
                System.out.println(ret);
            } else {
                String ret = line.substring(0, length - 1);
                ret += 'z';
                System.out.println(ret);
            }
        }else{
            char curr = line.charAt(0);
            if (curr == 'a'){
                System.out.println('z');
            }else {
                curr = (char) (curr-1);
                System.out.println(curr);
            }
        }
    }
}
