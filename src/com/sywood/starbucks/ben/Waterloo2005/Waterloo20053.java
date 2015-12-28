package com.sywood.starbucks.ben.Waterloo2005;
import java.util.LinkedList;
import java.util.Scanner;

public class Waterloo20053 {
    private static String move(String let){
        if (let.equals("L")){
            return "RIGHT";
        }else if (let.equals("R")){
            return "LEFT";
        }else{
            return let;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedList<String> directions = new LinkedList<String>();
        String word = input.nextLine();
        while (!word.equals("SCHOOL")){
            directions.add(move(word));
            word = input.nextLine();
        }
        directions.add(move("HOME"));
        for (int i = 0; i < directions.size(); i+=2) {
            if (directions.get(i+1).equals("HOME")){
                System.out.println("Turn " + directions.get(i) + " into your " + directions.get(i+1) + ".");
            }else{
                System.out.println("Turn " + directions.get(i) + " onto " + directions.get(i+1) + " street.");
            }
        }
    }
}
