package com.sywood.starbucks.ben.ICSChallengeQuestions;

/**
 * Created by Ben on 2016-11-10.
 */
public class Q2 {
    public static int method(int angle, int bounce){
        if(bounce == 0){
            return 360-angle;
        }else if (bounce == 1){
             return 270+angle;
        }else if (bounce == 2){
            return 90+angle;
        }else if (bounce == 3){
            return 180+angle;
        }
        return -1;
    }


    public static void main(String[] args){
        System.out.println(method(50, 1));
    }
}

