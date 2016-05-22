package com.sywood.starbucks.ben.UVA.Greedy;
import java.io.*;

public class UVa10382 {
    private static double[][] sort(double[][] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] < array[i-1][0]){
                double temp = array[i][0];
                double[] otherTemp = array[i];
                int j;
                for (j = i-1; j >= 0 && temp < array[j][0]; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = otherTemp;
            }
        }
        return array;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = input.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int L = Integer.parseInt(inputs[1]);
        double newW = Integer.parseInt(inputs[2]);
        double center = newW/2*newW/2;
        String[] values;
        int[][] sprinklers = new int[n][2];
        for (int i = 0; i < n; i++) {
            values = input.readLine().split(" ");
            sprinklers[i][0] = Integer.parseInt(values[0]);
            sprinklers[i][1] = Integer.parseInt(values[1]);
        }
        double[][] intervals = new double[n][2];
        for (int i = 0; i < n; i++) {
            double dx = Math.sqrt(sprinklers[i][1]*sprinklers[i][1] - center);
            intervals[i] = new double[]{sprinklers[i][0] - dx, sprinklers[i][0]+dx};
        }
        intervals = sort(intervals);
        int numSprinklers = 1;
        double left = intervals[0][0];
        double right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > right){
                i = n;
            }else if (intervals[i][0] <= left & intervals[i][1] > right){
                right = intervals[i][1];
            }else if (intervals[i][0] > left & intervals[i][1] > right){
                left = right;
                right = intervals[i][1];
                numSprinklers++;
            }
        }
        if (right < L){
            System.out.println(-1);
        }else{
            System.out.println(numSprinklers);
        }
    }
}
