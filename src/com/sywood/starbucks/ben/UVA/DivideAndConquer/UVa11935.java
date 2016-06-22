package com.sywood.starbucks.ben.UVA.DivideAndConquer;
import java.io.*;

public class UVa11935 {
    private static boolean can(double gas, String[][] data, int i){
        double cons = Double.parseDouble(data[0][3])/100;
        int curr = 0;
        double max = gas;
        double leak = 0;
        for (int j = 0; j <= i; j++){
            String[] line = data[j];
            int dist = Integer.parseInt(line[0]);
            int moved = dist-curr;
            gas -= moved*cons;
            if (gas < 0){
                return false;
            }
            switch (line[1]) {
                case "Leak":
                    leak++;
                    break;
                case "Fuel":
                    cons = Double.parseDouble(line[3]) / 100;
                    break;
                case "Gas":
                    gas = max;
                    break;
                case "Mechanic":
                    leak = 0;
                    break;
            }
            gas -= leak*moved;
            curr = dist;
        }
        return true;
    }
    private static double find(String[][] data, int i){
        double min = 0.0, max = 10000.0, mid, ans = 0.0;
        for (int j = 0; j < 100; j++) {
            mid = (max+min)/2.0;
            if (can(mid, data, i)){ ans = mid; max = mid;}
            else{min = mid;}
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        String[] info;
        while (!line.equals("0 Fuel consumption 0")){
            String[][] simulationData = new String[50][3];
            info = line.split(" ");
            int i = 0;
            while (!info[1].equals("Goal")){
                simulationData[i] = info;
                line = input.readLine();
                info = line.split(" ");
                i++;
            }
            simulationData[i] = info;
            System.out.printf("%.3f", find(simulationData, i));
            line = input.readLine();
            System.out.print("\n");
        }
    }
}
