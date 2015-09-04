package com.sywood.starbucks.ben;
//import javafx.scene.shape.Path;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;


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

    public static void main(String[] args) throws IOException{
        File f = new File("C:/Users/Striker/Downloads/card.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);
        int player1 = 0;
        int player2 = 0;
        int[] count = {0, 0, 0};
        String[] cards = new String[52];

        for (int i = 0; i < 52 ; i++) {
            cards[i] = textReader.readLine();
            textReader.readLine();
        }
        textReader.close();
        for (int i = 0; i < 52; i++) {
            String card = cards[i];
            if (isHigh(card)) {
                count[2] = player(i % 2);
                if (card.equals("ace")) {
                    count[0] = 4;
                    count[1] = 4;
                } else if (card.equals("king")) {
                    count[0] = 3;
                    count[1] = 3;
                } else if (card.equals("queen")) {
                    count[0] = 2;
                    count[1] = 2;
                } else {
                    count[0] = 1;
                    count[1] = 1;
                }
            }else if(count[0] > 0 && !isHigh(card)){
                count[0] -= 1;
                if (count[0] == 0){
                    if (count[2] == 1){
                        if(count[1] == 4){
                            player1 += 4;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 1 earned " + 4 + " points");
                        }else if(count[1] == 3){
                            player1 += 3;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 1 earned " + 3 + " points");
                        }else if(count[1] == 2){
                            player1 += 2;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 1 earned " + 2 + " points");
                        }else if(count[1] == 1){
                            player1 += 1;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 1 earned " + 1 + " points");
                        }
                    }else{
                        if(count[1] == 4){
                            player2 += 4;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 2 earned " + 4 + " points");
                        }else if(count[1] == 3){
                            player2 += 3;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 2 earned " + 3 + " points");
                        }else if(count[1] == 2){
                            player2 += 2;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 2 earned " + 2 + " points");
                        }if(count[1] == 1){
                            player2 += 1;
                            count[0] = 0;
                            count[1] = 0;
                            System.out.println("Player 2 earned " + 1 + " points");
                        }
                    }
                }
            }
        }
        System.out.println("Player 1 earned " + player1 + " points");
        System.out.println("Player 2 earned " + player2 + " points");
    }

}
