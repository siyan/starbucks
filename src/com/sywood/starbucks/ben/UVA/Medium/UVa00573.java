package com.sywood.starbucks.ben.UVA.Medium;
import java.io.*;
public class UVa00573 {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0 0 0 0")){
            String[] data = line.split(" ");
            int H = Integer.parseInt(data[0]);
            double U = Double.parseDouble(data[1]);
            int D = Integer.parseInt(data[2]);
            double F = Double.parseDouble(data[3]);
            double subtract = U*F/100.0;
            double height = 0;
            int day = 1;
            while (height >= 0 && height < H){
                height += U;
                if (height > H){
                    break;
                }
                height -= D;
                if (!(height >= 0)){
                    break;
                }
                if (U - subtract < 0) {
                    U = 0;
                }else{
                    U -= subtract;
                }
                day++;
            }
            String yes = height >= 0 ? "success" : "failure";
            System.out.println(yes + " on day " + day);
            line = input.readLine();
        }
    }
}
