package com.sywood.starbucks.ben.Euler.Forties;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FortyTwo {
    private static HashMap<Character, Integer> letToNum = new HashMap<>();
    private static ArrayList<Integer> tri = new ArrayList<>();

    private static void initialize(){
        for (int i = 65; i < 91; i++) {
            letToNum.put((char) i, i-64);
        }
    }

    private static boolean isTriangle(String word){
        int sum = 0;
        for (char letter : word.toCharArray()){
            sum += letToNum.get(letter);
        }
        if (tri.contains(sum)){
            return true;
        }else{
            int i = tri.size();
            int temp = i*(i+1)/2;
            tri.add(temp);
            while (temp < sum){
                i++;
                temp = i*(i+1)/2;
                tri.add(temp);
            }
            return temp == sum;
        }
    }
    public static void main(String[] args)throws IOException{
        initialize();
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Striker\\IdeaProjects\\Starbucks\\data\\p42.in"));
        String[] words = input.readLine().split("\"+,+\"");
        int tot = 0;
        for (String word : words){
            if (isTriangle(word)){
                tot++;
            }
        }
        System.out.println(tot);
    }
}
