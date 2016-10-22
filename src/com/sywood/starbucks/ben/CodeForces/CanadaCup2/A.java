package com.sywood.starbucks.ben.CodeForces.CanadaCup2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        String moves = input.readLine();
        int counter = 0;
        boolean[] directionsR = new boolean[size];
        directionsR[0] = moves.charAt(0) == '<';
        for(int i = 1; i < size; i++){
            if(directionsR[i-1] && moves.charAt(i) == '<'){
                directionsR[i] = true;
            }
        }
        boolean[] directionsL = new boolean[size];
        directionsL[size-1] = moves.charAt(size-1) == '>';

        for(int i = size-2; i >= 0; i--){
            if(directionsL[i+1] && moves.charAt(i) == '>'){
                directionsL[i] = true;
            }
        }

        for (int i = 0; i < size; i++) {
            if(directionsL[i] || directionsR[i])
                counter++;
        }
        System.out.println(counter);
    }
}
