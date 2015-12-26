package com.sywood.starbucks.ben.Waterloo2007;
import java.util.Scanner;

public class Waterloo20071 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = 0;
        int middle = 0;
        int min = 990;
        for (int i = 0; i < 3; i++) {
            int curr = Integer.parseInt(input.nextLine());
            if (curr > max){
                middle = max;
                max = curr;
            }else if (curr < min){
                middle = min;
                min = curr;
            }else{
                middle = curr;
            }
        }
        System.out.println(middle);
    }
}
