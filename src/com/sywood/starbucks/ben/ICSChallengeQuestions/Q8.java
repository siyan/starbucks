package com.sywood.starbucks.ben.ICSChallengeQuestions;

/**
 * Created by Ben on 2016-11-10.
 */
public class Q8 {
    private static boolean used[] = new boolean[26];
    private static int maxLen;
    public static void genPermutations(String curr){
        if(curr.length() == maxLen)
            System.out.println(curr);
        else{
            for(int i = 0; i < used.length; i ++){
                if(!used[i]){
                    if(curr.length() + 1 != maxLen) System.out.println(curr + (char)('A' + i));
                    used[i] = true;
                    genPermutations(curr + (char)('A' + i));
                    used[i] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        maxLen = 3;
        genPermutations("");
    }
}
