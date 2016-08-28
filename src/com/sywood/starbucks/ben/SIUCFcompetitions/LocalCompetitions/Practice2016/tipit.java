package com.sywood.starbucks.ben.SIUCFcompetitions.LocalCompetitions.Practice2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2016-08-27.
 */
public class tipit {
    private static boolean isPalindrome(int n){
        String first = Integer.toString(n);
        String reverse = "";
        for (int i = first.length()-1; i >= 0; i--) {
            reverse += first.charAt(i);
        }
        return first.equals(reverse);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(input.readLine());
            System.out.println("Input cost: " + price);
            int start = (int) Math.ceil(price*0.2);
            if (isPalindrome(start+price))
                System.out.println(start + " " + (price + start));
            else{
                while(!isPalindrome(start+price)){
                    start++;
                }
                System.out.println(start + " " + (price+start));
            }
        }
    }
}
