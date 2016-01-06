package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCC963 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iter = Integer.parseInt(input.nextLine());
        for (int i = 0; i < iter; i++){
            int n = input.nextInt();
            int k = input.nextInt();
            String bits = "";
            for (int j = 0; j < n; j++) {
                if (--k > 0){
                    bits += "1";
                }else{
                    bits += "0";
                }
            }
            boolean complete = false;
            while (!complete){
                /*TODO: implement switch code for 1s and 0s*/

            }
        }
    }
}
