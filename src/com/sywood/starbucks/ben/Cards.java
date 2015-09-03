package com.sywood.starbucks.ben;
import javafx.scene.shape.Path;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;


public class Cards {

    public static boolean isHigh(String name){
        if (name == "king" || name == "queen" || name == "jack" || name == "ace"){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        File f = new File("C:/Users/Striker/Downloads/card.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);
        int player1 = 0;
        int player2 = 0;
        int count = 1;
        int numLines = 52;
        String[] cards = new String[numLines];

        for (int i = 0; i < numLines ; i++) {
            cards[i] = textReader.readLine();
        }
        textReader.close();
        for (int i = 0; i < numLines; i+=2) {
            if (cards[i].equals("ace") && i <= 47 &&
                    !isHigh(cards[i+1]) && !isHigh(cards[i+2]) && !isHigh(cards[i+3]) && !isHigh(cards[i+4])){
                if ((i+1) % 4 == 1 || (i+1) % 4 == 0){
                    player1 += 4;
                    System.out.println("Player 1 earned 4 points");
                }else{
                    player2 += 4;
                    System.out.println("Player 2 earned 4 points");
                }
            }else if (cards[i].equals("king") && i <= 48
                    && !isHigh(cards[i+1]) && !isHigh(cards[i+2]) && !isHigh(cards[i+3])){
                if ((i+1) % 4 == 1 || (i+1) %4 == 0){
                    player2 += 3;
                    System.out.println("Player 2 earned 3 points");
                }else{
                    player1 += 3;
                    System.out.println("Player 1 earned 3 points");
                }
            }else if (cards[i].equals("queen") && i <= 49
                    && !isHigh(cards[i+1]) && !isHigh(cards[i+2])){
                if ((i+1) % 4 == 1 || (i+1) % 4 == 0){
                    player2 += 2;
                    System.out.println("Player 2 earned 2 points");
                }else{
                    player1 += 2;
                    System.out.println("Player 1 earned 2 points");
                }
            }else if (cards[i].equals("jack") && i <= 50 && !isHigh(cards[i+1])){
                if ((i+1) % 4 == 1 || (i+1) % 4 == 0){
                    player2 += 1;
                    System.out.println("Player 2 earned 1 points");
                }else{
                    player1 += 1;
                    System.out.println("Player 1 earned 1 points");
                }
            }
        }
        System.out.println("Player 1 earned " + player1 + " points");
        System.out.println("Player 2 earned " + player2 + " points");
    }

}
