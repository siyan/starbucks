package com.sywood.starbucks.ben.Euler;

public class TwentyEight {
    public static void main(String[] args){
        int[][] spiral = new int[5][5];
        int x = 2;
        int y = 2;
        int num = 1;
        spiral[x][y] = num;
        for (int i = 2; i <= 5; i++) {
            int direction = 1;
            if (i%2 == 1){
                x += 1;
                direction = -1;
            }else{
                x -= 1;
            }
            for (int j = 0; j < i; j++) {
                num++;
                System.out.println(y+j*direction + ", " + x);
                /*
                int tempY = y+(j*direction);
                spiral[tempY][x] = num;
                */
            }
            for (int j = 0; j < i-1; j++) {
                num++;
                System.out.println(y + ", " + x+j*direction);
                /*
                int tempX = x+(j*direction);
                spiral[tempX][x] = num;
                */
            }
        }
        for (int[] row : spiral){
            for (int temp : row){
                System.out.print(temp + " ");
            }
            System.out.print("\n");
        }
    }
}
