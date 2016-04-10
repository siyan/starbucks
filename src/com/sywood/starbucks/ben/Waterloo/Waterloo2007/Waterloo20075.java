package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Waterloo20075 {
    private static int A = 0;
    private static int B = 0;
    private static int ways = 0;
    private static ArrayList<Integer> hotels = new ArrayList<>();
    private static int[] hotel;
    private static int[] memoize = new int[24];
    private static void generate(){
        hotel = new int[34];
        hotel[0] = 0;
        hotel[1] = 990;
        hotel[2] = 1010;
        hotel[3] = 1970;
        hotel[4] = 2030;
        hotel[5] = 2940;
        hotel[6] = 3060;
        hotel[7] = 3930;
        hotel[8] = 4060;
        hotel[9] = 4970;
        hotel[10] = 5030;
        hotel[11] = 5990;
        hotel[12] = 6010;
        hotel[13] = 7000;
    }
    private static void recuVisit(int dist){

        if (dist >= 7000){
            ways++;
        }else{
            for (Integer hotel : hotels) {
                if (hotel - dist <= B & A <= hotel - dist) {
                    recuVisit(hotel);
                }
            }
        }
    }
    private static void DPVisit(){
        for (int i = 0; i < hotel.length; i++){
            for (int j = i+1; j < hotel.length; j++) {
                if (A <= hotels.get(j)-hotels.get(i) && B >= hotels.get(j)-hotels.get(i)){
                    hotel[j] += hotel[i];
                }
            }
        }
    }
    static int topDown(int currIndex){
        int min = currIndex-1;
        while(min > -1 && hotel[currIndex] - hotel[min] < A) min--;
        if (min <= 0){
            return (min == -1 || hotel[currIndex] - hotel[min] < A) ? 0 : 1;
        }else{
            while(min > -1 && hotel[currIndex] - hotel[min] <= B){
                if (memoize[min] == 0){
                    memoize[min] = topDown(min);
                }
                memoize[currIndex] += memoize[min];
                min--;
            }
            return memoize[currIndex];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        generate();
        A = Integer.parseInt(input.readLine());
        B = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            hotel[14+i] = Integer.parseInt(input.readLine());
        }
        //DPVisit();

        System.out.println(topDown(13+N));
    }
}
