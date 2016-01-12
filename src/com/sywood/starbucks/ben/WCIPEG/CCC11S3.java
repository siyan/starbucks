package com.sywood.starbucks.ben.WCIPEG;
import java.util.Scanner;

public class CCC11S3 {
    private static int scan(int m, int x, int y){
        if (m == 0){
            return 0;
        }else{
            if (x > Math.pow(5, m-1)-1){
                scan(0, x, y);
            }else if (x > Math.pow(5, m-1)/5-1){
                if (y > Math.pow(5, m-1)/5*3-1){
                    scan(m-1,x,y);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iter = input.nextInt();
        for (int i = 0; i < iter; i++){
            int m = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            scan(m, x, y);
        }
    }
}
