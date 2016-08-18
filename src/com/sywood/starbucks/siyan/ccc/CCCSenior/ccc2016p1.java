package com.sywood.starbucks.siyan.ccc.CCCSenior;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-08-17.
 */
public class ccc2016p1 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String target = input.readLine();
        String end = input.readLine();
        int[] let = new int[26];
        int[] endTot = new int[26];
        boolean not = false;
        for (int i = 0; i < target.length(); i++) {
            let[target.charAt(i)-'a']++;
            if(end.charAt(i) != '*') {
                endTot[end.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(let[i] < endTot[i]){
                System.out.println("N");
                not = true;
                break;
            }
        }
        if(!not){
            System.out.println("A");
        }
    }
}
