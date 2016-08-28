package com.sywood.starbucks.ben.SIUCFcompetitions.LocalCompetitions.Practice2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Ben on 2016-08-27.
 */
public class texting {
     public static void main(String[] args)throws Exception{
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(input.readLine());
         HashMap<String, String> words = new HashMap<>();
         for (int i = 0; i < n; i++) {
             String[] data = input.readLine().split(" ");
             String first = data[0];
             String second = "";
             for(int j = 1; j < data.length; j++)
                 second += data[j] + " ";
             words.put(first, second);
         }
         int p = Integer.parseInt(input.readLine());
         for (int i = 0; i < p; i++) {
             String[] data = input.readLine().split(" ");
             String ret = "";
             for(String word : data){
                 if (words.containsKey(word)){
                     ret += words.get(word);
                 }else{
                     ret += word + " ";
                 }
             }
             System.out.println(ret.trim());
         }

     }
}
