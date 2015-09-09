package com.sywood.starbucks.ben;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Cards {

    public static boolean isHigh(String name){
        return (name.equals("king") || name.equals("queen") || name.equals("jack") || name.equals("ace"));
    }
    public static int player(int player){
        if (player == 0){
            return 1;
        }else{
            return 2;
        }
    }
    public static int score(String card){
        switch (card) {
            case "ace":
                return 4;
            case "king":
                return 3;
            case "queen":
                return 2;
            case "jack":
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        File f = new File("C:/Users/Striker/Downloads/card.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);
        int player1 = 0;
        int player2 = 0;
        int currPlayer = 0;
        int turns = 0;
        int cType = 0;

        for (int i = 0; i < 52; i++) {
            String card = textReader.readLine();
            textReader.readLine();
            if (isHigh(card)) {
                currPlayer = player(i % 2);
                turns = cType = score(card);
            }else if(turns > 0 && !isHigh(card)){
                turns -= 1;
                if (turns == 0){
                    if (currPlayer == 1){
                        player1 += cType;
                        System.out.println("Player 1 earned " + cType + " points");
                        turns = cType = 0;
                    }else{
                        player2 += cType;
                        System.out.println("Player 2 earned " + cType + " points");
                        turns = cType = 0;
                    }
                }
            }
        }
        textReader.close();
        System.out.println("Player 1 earned " + player1 + " points");
        System.out.println("Player 2 earned " + player2 + " points");
    }

}
