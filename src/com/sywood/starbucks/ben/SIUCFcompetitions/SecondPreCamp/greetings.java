package com.sywood.starbucks.ben.SIUCFcompetitions.SecondPreCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class greetings {
    private static int n;
    private static int k;
    private static long wastedSpace = Long.MAX_VALUE;
    private static ArrayList<int[]> letters;
    private static void permute(int currIdx, ArrayList<int[]> tempLetters, int[][] envelopes){
        if (currIdx == k){
            int maxL = 0;
            int maxW = 0;
            for (int[] letter : tempLetters) {
                maxL = Math.max(maxL, letter[0]);
                maxW = Math.max(maxW, letter[1]);
            }
            if (maxL > 0 && maxW > 0) {
                envelopes[currIdx-1] = new int[]{maxL, maxW};
            }
            findWaste(envelopes);
            System.out.println();
        }else{
            for (int start = 0; start < tempLetters.size(); start++) {//starting letter
                ArrayList<int[]> initial = new ArrayList<>();
                for (int[] item : tempLetters){
                    initial.add(item);
                }
                for (int permute = 0; permute < 1 << initial.size(); permute++) {//iterates through all possible permutations
                    int counter = 0;
                    int maxL = 0;
                    int maxW = 0;
                    ArrayList<Integer> toRemove = new ArrayList<>();
                    for (int i = 0; i < initial.size(); i++) {
                        if (i >= start && permute >> i == 1 && counter < n-(k-currIdx)){
                            maxL = Math.max(maxL, tempLetters.get(i)[0]);
                            maxW = Math.max(maxW, tempLetters.get(i)[1]);
                            counter++;
                            toRemove.add(i);
                        }
                    }
                    Collections.sort(toRemove);
                    for (int i = toRemove.size()-1; i >= 0; i--) {
                        initial.remove(i);
                    }
                    if (maxL > 0 && maxW > 0) {
                        envelopes[currIdx-1] = new int[]{maxL, maxL};
                        permute(currIdx+1, initial, envelopes);
                    }
                }
            }
        }
    }
    private static void findWaste(int[][] envelopes){
        long tempWaste = 0;
        for (int[] letter : letters) {
            int temp = letter[0] * letter[1];
            int minWaste = Integer.MAX_VALUE;
            System.out.println("letter: [" + letter[0] + ", " + letter[1] + "] area: " + temp);
            for (int[] envelope : envelopes) {
                System.out.println("envelope: [" + envelope[0] + ", " + envelope[1] + "] area: " + (envelope[0]*envelope[1]));
                if (letter[0] <= envelope[0] && letter[1] <= envelope[1]) {
                    minWaste = Math.min(minWaste, envelope[0]*envelope[1] - temp);
                    System.out.println("fits");
                }
            }
            tempWaste += minWaste*letter[2];
        }
        System.out.println(tempWaste);
        wastedSpace = Math.min(wastedSpace, tempWaste);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        k = Integer.parseInt(info[1]);
        if (n <= k){
            for (int i = 0; i < n; i++) {
                input.readLine();
            }
            System.out.println(0);
        }else if (k == 1){
            int maxL = 0;
            int maxW = 0;
            int[][] letters = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().split(" ");
                letters[i] = new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])};
                maxL = Math.max(maxL, letters[i][0]);
                maxW = Math.max(maxW, letters[i][1]);
            }
            wastedSpace = 0;
            for (int i = 0; i < n; i++) {
                wastedSpace += (maxL*maxW - letters[i][0]*letters[i][1])*letters[i][2];
            }
            System.out.println(wastedSpace);
        }else{
            letters = new ArrayList<>();
            int[][] envelopes = new int[k][2];
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().split(" ");
                letters.add(new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])});
            } // stores all data.
            permute(1, letters, envelopes);
            System.out.println(wastedSpace);
        }
    }
}
