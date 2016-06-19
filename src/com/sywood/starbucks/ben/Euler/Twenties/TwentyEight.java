package com.sywood.starbucks.ben.Euler.Twenties;

public class TwentyEight {
    public static void main(String[] args){
        int[][] spiral = new int[1001][1001];
        int count = Math.floorDiv(1001, 2);
        int ring = Math.floorDiv(1001, 2);
        for( int i = 0; i <= ring; i++ ) {
            for( int j = 0; j < 4; j++ ) {
                for( int k = 1; k <= 2 * i; k++ ) {
                    int x = ring;
                    int y = ring;
                    switch( j ) {
                        case 0:
                            x += i;
                            y -= i - k;
                            break;
                        case 1:
                            x += i - k;
                            y += i;
                            break;
                        case 2:
                            x -= i;
                            y -= k - i;
                            break;
                        case 3:
                            x += k - i;
                            y -= i;
                            break;
                    }
                    spiral[y][x] = count;
                    count++;
                }
            }
        }
        long sum = 1;
        for (int i = 0; i < spiral.length; i++) {
            sum += spiral[i][i];
        }
        int n = 0;
        for (int i = spiral.length-1 ; i >= 0; i--, n++){
            sum += spiral[i][n];
        }
        System.out.println(sum);
    }
}
