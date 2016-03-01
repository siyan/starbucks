package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Waterloo20075 {
    static int A = 0;
    static int B = 0;
    static int ways = 0;
    static void recuVisit(int dist, ArrayList<Integer> hotels, int days){
        if (dist >= 7000){
            ways++;
        }else{
            for (int i = 0; i < hotels.size(); i++){
                if (dist + hotels.get(i) < B*days & A*days < hotels.get(i) + dist){
                    recuVisit(dist+hotels.get(i), hotels.subList(i, hotels.size()-1), days+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        FileReader hotel = new FileReader("data/hotels.in");
        BufferedReader input = new BufferedReader(hotel);
        String[] locs = input.readLine().split(" ");
        ArrayList<Integer> hotels = new ArrayList<>();
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
