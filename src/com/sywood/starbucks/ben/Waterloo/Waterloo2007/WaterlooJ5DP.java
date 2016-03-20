package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class WaterlooJ5DP {
    static int A = 0;
    static int B = 0;
    static int[] hotel;
    static ArrayList<Integer> hotels = new ArrayList<>();
    public static void main(String[] args)throws IOException{
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
    }
}
