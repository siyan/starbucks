package com.sywood.starbucks.ben.CodeForces.Round372Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-09-17.
 */
public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String words = input.readLine();
        String ret = "";
        boolean found = false;
        for(int i = 0; i+26 <= words.length() && !found; i++){
            String curr = words.substring(i, i+26);
            boolean[] taken = new boolean[26];
            int questCounter = 0;
            for (int j = 0; j < 26; j++) {
                if (curr.charAt(j) != '?')
                    taken[curr.charAt(j) - 'A'] = true;
                else
                    questCounter++;
            }
            int other = 0;
            for (int j = 0; j < 26; j++) {
                if(taken[j])
                    other++;
            }
            if (other+questCounter == 26){
                i += 26;
                for (int j = 0; j < 26; j++) {
                    if(curr.charAt(j) != '?')
                        ret += curr.charAt(j);
                    else{
                        for (int k = 0; k < 26; k++) {
                            if (!taken[k]){
                                taken[k] = true;
                                ret += (char) ('A' + k);
                                break;
                            }
                        }
                    }
                }
                found = true;
            }else{
                ret += words.charAt(i);
            }
        }

        if (!found)
            System.out.println(-1);
        else {
            int len = ret.length();
            for (int i = len; i < words.length(); i++) {
                ret += 'A';
            }
            System.out.println(ret);
        }
    }
}
