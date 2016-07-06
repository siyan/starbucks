package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;

import java.io.*;

public class paintme {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0 0 0 0 0 0")){
            String[] first = line.split(" ");
            int n = Integer.parseInt(first[0]);
            int width = Integer.parseInt(first[1]);
            int length = Integer.parseInt(first[2]);
            int height = Integer.parseInt(first[3]);
            int area = Integer.parseInt(first[4]);
            int m = Integer.parseInt(first[5]);
            double currVolume = width*length + height*length*2 + width*height*2;
            for (int i = 0; i < m; i++) {
                String[] data = input.readLine().split(" ");
                currVolume -= Integer.parseInt(data[0])*Integer.parseInt(data[1]);
            }
            currVolume *= n;
            currVolume /= area;
            currVolume = Math.ceil(currVolume);
            System.out.println((int)currVolume);
            line = input.readLine();
        }
    }
}
