package com.sywood.starbucks.ben.ICSChallengeQuestions;

/**
 * Created by Striker on 2016-11-11.
 */
public class Q3 {
    public static int isEqual(int x, int y){
        return ((x^y)&1) | (((x^y)&(1<<1))>>1) | (((x^y)&1<<2)>>2) | (((x^y)&1<<3)>>3)|(((x^y)&1<<4)>>4)|(((x^y)&1<<5)>>5)|(((x^y)&1<<6)>>6)|(((x^y)&1<<7)>>7)|
                (((x^y)&1<<8)>>8)|(((x^y)&1<<9)>>9)|(((x^y)&1<<10)>>10)|(((x^y)&1<<11)>>11)|(((x^y)&1<<12)>>12);
    }
    public static void main(String[] args){
        System.out.println(isEqual(3, 3));
    }
}
