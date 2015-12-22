package com.sywood.starbucks.ben.Waterloo2010;
import java.util.Scanner;

public class Waterloo20103 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int A = 0;
        int B = 0;
        while (first != 7){
            String command = input.next();
            if (first == 1){
                if (command.equals("A")){
                    A = input.nextInt();
                }else{
                    B = input.nextInt();
                }
            }else if (first == 2){
                if (command.equals("A")){
                    System.out.println(A);
                }else{
                    System.out.println(B);
                }
            }else if (first == 3){
                int Y = input.nextInt();
                if (command.equals("A")){
                    A += Y;
                }else{
                    B += Y;
                }
            }else if (first == 4){
                int Y = input.nextInt();
                if (command.equals("A")){
                    A *= Y;
                }else{
                    B *= Y;
                }
            }else if (first == 5){
                int Y = input.nextInt();
                if (command.equals("A")){
                    A -= Y;
                }else{
                    B -= Y;
                }
            }else if (first == 6){
                int y = input.nextInt();
                if (command.equals("A")){
                    A = A/y;
                }else{
                    B = B/y;
                }
            }
        }

    }
}
