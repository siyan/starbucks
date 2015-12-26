package com.sywood.starbucks.ben;
import java.util.Scanner;

public class Waterloo20084 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = 0;
        int middle = 0;
        for (int i = 0; i < 3; i++) {
            int curr = Integer.parseInt(input.nextLine());
            System.out.print(curr);
            if (curr > max){
                middle = max;
                max = curr;
            }
        }
        System.out.println(middle);
    }
}
