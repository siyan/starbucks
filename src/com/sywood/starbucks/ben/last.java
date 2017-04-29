package com.sywood.starbucks.ben;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class last {
    public static void main(String args) throws Exception{
        //BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\strik\\Documents\\GitHub\\starbucks\\src\\com\\sywood\\starbucks\\ben\\DATA31.txt")));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 10; t++){
            int N = Integer.parseInt(input.readLine().trim());
            String[] arr = new String[N];
            for(int i =0;i < N; i++){
                arr[i] =  input.readLine().trim();
            }
            for(int i =0;i <N; i++){
                String[] lst = new String[N-1];
                for(int j = 0; j < N; j++){
                    if(j > i){
                        lst[j-1] = arr[j];
                    }else lst[j] = arr[j];
                }
                System.out.println(Arrays.toString(lst));
            }
        }
    }
}
