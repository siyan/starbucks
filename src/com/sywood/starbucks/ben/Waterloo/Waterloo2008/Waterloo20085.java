package com.sywood.starbucks.ben.Waterloo.Waterloo2008;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20085 {
    static ArrayList<Integer> atoms = new ArrayList<>(4);
    static boolean removeString(int A, int B, int C, int D){
        if (atoms.get(0) >= A){
            atoms.set(0, atoms.get(0)-A);
        }else{
            return false;
        }if(atoms.get(1) >= B){
            atoms.set(1, atoms.get(1)-B);
        }else{
            return false;
        }if(atoms.get(2) >= C){
            atoms.set(2, atoms.get(2)-C);
        }else{
            return false;
        }if(atoms.get(3) >= D){
            atoms.set(3, atoms.get(3) - D);
        }else{
            return false;
        }
        return true;
    }
    static int playGame(int player){
        if (removeString(2, 1, 0, 2)){
            return playGame((player+1)%2);
        }if (removeString(1, 1, 1, 1)){
            return playGame((player+1)%2);
        }if (removeString(0,0,2,1)){
            return playGame((player+1)%2);
        }if(removeString(0,3,0,0)){
            return playGame((player+1)%2);
        }if(removeString(1,0,0,1)){
            return playGame((player+1)%2);
        }else{
            return (player+1)%2;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < atoms.size(); i++) {
            atoms.set(i, count);
        }
        System.out.println(playGame(0));
    }
}
