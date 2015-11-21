package com.sywood.starbucks.ben;
import java.util.Scanner;

/**
 * Created by Striker on 2015-11-21.
 */
public class Waterloo20142 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nVote = Integer.parseInt(input.nextLine());
        int a = 0;
        int b = 0;
        String votes = input.nextLine();
        for (int i = 0; i < nVote; i++) {
            if (votes.charAt(i) == 'A'){
                a += 0;
            }else if (votes.charAt(i) == 'B'){
                b += 0;
            }
        }
        if (a > b){
            System.out.print("A");
        }else if (b > a){
            System.out.print("B");
        }else{
            System.out.print("Tie");
        }
    }
}
