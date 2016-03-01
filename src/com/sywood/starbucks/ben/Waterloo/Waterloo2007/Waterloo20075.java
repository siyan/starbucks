package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Waterloo20075 {
    static int A = 0;
    static int B = 0;
    static int ways = 0;
    static ArrayList<Integer> hotels = new ArrayList<>();
    static void recuVisit(int dist){
        if (dist >= 7000){
            ways++;
        }else{
            for (int i = 0; i < hotels.size(); i++){
                if (hotels.get(i)-dist <= B & A <= hotels.get(i) - dist){
                    recuVisit(hotels.get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        FileReader hotel = new FileReader("data/hotels.in");
        BufferedReader input = new BufferedReader(hotel);
        String[] locs = input.readLine().split(" ");
        for (String loc : locs){
            hotels.add(Integer.parseInt(loc));
        }
        A = Integer.parseInt(input.readLine());
        B = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        for (int i = 0; i < m; i++){
            int x = Integer.parseInt(input.readLine());
            if(!hotels.contains(x)){
                hotels.add(x);
            }
        }
        Collections.sort(hotels);
        recuVisit(0);
        System.out.println(ways);
    }
}
