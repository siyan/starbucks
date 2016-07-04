package com.sywood.starbucks.ben.UVA.CompleteSearch;
import java.io.*;
import java.util.Arrays;

public class UVa11242 {
    private static double find(double[] ratios){
        double max = 0;
        for (int i = 0; i < ratios.length-1; i++) {
            if (max < ratios[i+1]/ratios[i]&&ratios[i] != 0){
                max = ratios[i+1]/ratios[i];
            }
        }
        return max;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0")){
            String[] fAndR = line.split(" ");
            int f = Integer.parseInt(fAndR[0]);
            int r = Integer.parseInt(fAndR[1]);
            int[] front = new int[f];
            int[] rear = new int[r];
            int i = 0;
            for (String sprocket : input.readLine().split(" ")){
                front[i] = Integer.parseInt(sprocket);
                i++;
            }
            i = 0;
            for (String sprocket : input.readLine().split(" ")){
                rear[i] = Integer.parseInt(sprocket);
                i++;
            }
            double[] ratios = new double[front.length*rear.length];
            for (int j = 0; j < front.length; j++) {
                for (int k = 0; k < rear.length; k++) {
                    ratios[j+k] = (double)rear[k]/(double)front[j];
                }
            }
            Arrays.sort(ratios);
            System.out.println(Math.round(find(ratios)*100)/100.0);
            line = input.readLine();
        }
    }
}
