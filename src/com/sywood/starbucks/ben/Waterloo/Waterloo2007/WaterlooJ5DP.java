package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;

public class WaterlooJ5DP {
    private static int A = 0;
    private static int B = 0;
    private static int[] hotel;
    private static int[] memoise = new int[7000];
    private static int ways = 0;
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

    static void truck(int distance){
         if (distance >= 7000){
              ways++;
         }else{
             for (int i = 0; i < hotel.length; i++) {
                 if (memoise[distance-1] != 0){
                      //memoise[distance-1];
                 }else {
                     if (hotel[i] - distance > A && hotel[i] - distance < B) {
                         //memoise[distance-1] = truck(hotel[i]);
                     }
                 }
             }
         }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        generate();
        A = Integer.parseInt(input.readLine());
        B = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        for (int i = 0; i < N; i++) {
            hotel[14+i] = Integer.parseInt(input.readLine());
        }


    }
}
