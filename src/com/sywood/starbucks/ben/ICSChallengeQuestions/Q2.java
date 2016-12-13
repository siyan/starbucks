package com.sywood.starbucks.ben.ICSChallengeQuestions;

/**
 * Created by Ben on 2016-11-10.
 */
public class Q2 {
    public static int method(int angle, int bounce){
        int ref = angle%90;
        if(bounce == 0)
            return 90-ref;
        else if (bounce == 1)
            return 270-ref;
        else if(bounce == 2)
            return 180+ref;
        else if(bounce == 3)
            return 270+ref;

        return -1;
    }


    public static void main(String[] args){
        System.out.println(method(320, 1));
    }
}

