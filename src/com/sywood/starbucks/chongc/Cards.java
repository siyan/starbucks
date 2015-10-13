package com.sywood.starbucks.chongc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by згёЦ on 2015/9/5.
 */
public class Cards {
    public static void main(String[] args) throws IOException{
        File f = new File("C:/File/card.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);

        int score1 = 0;
        int score2 = 0;
        int cardNum = 52;
        String[] cards = new String[cardNum];
        for(int i = 0;i<52;i++){
            cards[i] = textReader.readLine();
        }

        textReader.close();

        String[] checker ={"","","","",""};

        for(int i = 0;i<cardNum;i++){
            if(scoreCheck(cards[i])!=0){
                for(int j =0;j<=scoreCheck(cards[i]);i++){
                    checker[j+i] = cards[j+i];
                }
                if(scoring(i,checker) ==0){
                    continue;
                }else if(scoring(i,checker)>0){
                    System.out.println("playerA scores " + scoring(i,checker) + "point!");
                    score1 += scoring(i,checker);
                }else{
                    System.out.println("playerB scores " + -scoring(i,checker) + "point!");
                    score2 -= scoring(i,checker);
                }
            }
        }

        System.out.println("RESULT:");
        System.out.println("playerA scores " + score1 + "point!");
        System.out.println("playerB scores " + score2 + "point!");


    }

    public static int scoreCheck(String card){
        if(card=="jack"){
            return 1;
        }else if(card=="queen"){
            return 2;
        }else if(card =="king"){
            return 3;
        }else if(card=="ace"){
            return 4;
        }else{
            return 0;
        }


    }

    public static int scoring(int no,String[] cards){
        int count =0;
        for(int i=1;i<=scoreCheck(cards[0]);i++){
            count+=scoreCheck(cards[i]);

        }
        if(count!=0){
            return 0;
        }else{
            return scoreCheck(cards[0]);
        }

    }

}
