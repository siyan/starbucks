package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Waterloo20075 {
    static int A = 0;
    static int B = 0;
    static int ways = 0;
    static ArrayList<Integer> hotels = new ArrayList<>();
    static int[] hotel;
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
    static void topDown(int dist){
        if (dist >= 7000) {
            ways++;
        } else {

            for (Integer hotel : hotels){
                if (hotel - dist <= B && A <= hotel-dist){
                    topDown(hotel);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        FileReader hotelz = new FileReader("data/hotels.in");
        BufferedReader input = new BufferedReader(hotelz);
        String[] locs = input.readLine().split(" ");
        for (String loc : locs){
            hotels.add(Integer.parseInt(loc));
        }
        A = Integer.parseInt(input.readLine());
        B = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        hotel = new int[13+m];
        for (int i = 0; i < 13+m; i++){
            hotel[i] = 1;
        }
        for (int i = 0; i < m; i++){
            int x = Integer.parseInt(input.readLine());
            if(!hotels.contains(x)){
                hotels.add(x);
            }
        }
        Collections.sort(hotels);
        recuVisit(0);
        DPVisit();
        System.out.println(hotel[13+m-1]);
    }
}
