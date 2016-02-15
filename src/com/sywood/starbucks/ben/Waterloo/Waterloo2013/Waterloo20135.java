package com.sywood.starbucks.ben.Waterloo.Waterloo2013;
import java.util.Scanner;


public class Waterloo20135 {
    static int[][] games = new int[][]{
            {0,1,1,1},
            {0,0,1,1},
            {0,0,0,1},
            {0,0,0,0}};
    static int process(int a, int b, int scoreA, int scoreB){
        if (scoreA > scoreB){
            return a;
        }else if (scoreB > scoreA){
            return b;
        }else{
            return 4;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int fav = input.nextInt()-1;
        int iter = input.nextInt();
        int wins = 0;
        int[] scores = new int[]{0,0,0,0};
        for (int i = 0; i < iter; i++) {
            int a = input.nextInt()-1;
            int b = input.nextInt()-1;
            games[a][b] = 0;
            games[b][a] = 0;
            int winner = process(a, b, input.nextInt(), input.nextInt());
            if (winner != 4){
                scores[winner]+=3;
            }else{
                scores[a]++;
                scores[b]++;
            }
        }
        int first = 1;
        int second = 1;
        int third = 1;
        int fourth = 1;
        int fifth = 1;
        int sixth = 1;
        int a = 0;
        int[] newScore = new int[]{0,0,0,0};
        int[] point = new int[]{0,1,3};
        while (a < 3){
            if (games[0][1] == 0){
                a = 2;
                first = 0;
            }
            int b = 0;
            while (b < 3){
                if (games[0][2] == 0){
                    b = 3;
                    second = 0;
                }
                int c = 0;
                while (c < 3){
                    if (games[0][3] == 0){
                        c = 3;
                        third = 0;
                    }
                    int d = 0;
                    while (d < 3){
                        if (games[1][2] == 0){
                            d = 3;
                            fourth = 0;
                        }
                        int e = 0;
                        while (e < 3){
                            if(games[1][3] == 0){
                                e = 3;
                                fifth = 0;
                            }
                            int f = 0;
                            while(f < 3){
                                if(games[2][3]==0){
                                    f = 3;
                                    sixth = 0;
                                }
                                newScore[0] = scores[0] + point[a*first] + point[b*second] + point[c*third];
                                newScore[1] = scores[1] + point[(2-a)*first] + point[d*fourth] + point[e*fifth];
                                newScore[2] = scores[2] + point[(2-b)*second] + point[(2-d)*fourth] + point[f*sixth];
                                newScore[3] = scores[3] + point[(2-c)*third] + point[(2-e)*fifth] + point[(2-f)*sixth];
                                boolean won = true;
                                for (int i = 0; i < 4; i++){
                                    if (newScore[fav] <= newScore[i] & fav != i){
                                        won = false;
                                    }
                                }
                                if (won){
                                    wins++;
                                }
                                f++;
                            }
                            e++;
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }
        System.out.println(wins);
    }
}
