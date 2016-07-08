package com.sywood.starbucks.ben.SIUCFcompetitions.SecondPreCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class greetings {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] info = input.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        if (n == k){
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
            int wastedSpace = 0;
            for (int i = 0; i < n; i++) {
                wastedSpace += (maxL*maxW - letters[i][0]*letters[i][1])*letters[i][2];
            }
            System.out.println(wastedSpace);
        }else{
            ArrayList<int[]> letters = new ArrayList<>();
            ArrayList<int[]> envelopes = new ArrayList<>();
            int wastedSpace = 0;
            for (int i = 0; i < n; i++) {
                String[] data = input.readLine().split(" ");
                letters.add(new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])});
            }
            for (int i = 0; i < k - 1; i++) { // finds the best envelope for the group of letters that takes up the most area
                int maxArea = 0;
                int idx = -1;
                for (int j = 0; j < letters.size(); j++) {
                    int tempArea = letters.get(j)[0]*letters.get(j)[1]*letters.get(j)[2];
                    if (maxArea < tempArea){
                        maxArea = tempArea;
                        idx = j;
                    }
                }
                envelopes.add(new int[]{maxArea/letters.get(idx)[2], letters.get(idx)[0], letters.get(idx)[1]});
                letters.remove(idx);
            }
            int maxL = 0;
            int maxW = 0;
            for (int[] letter : letters){
                maxL = Math.max(maxL, letter[0]);
                maxW = Math.max(maxW, letter[1]);
            }
            envelopes.add(new int[]{maxL*maxW, maxL, maxW});
            for (int[] letter : letters){
                int temp = letter[0]*letter[1];
                int minWaste = Integer.MAX_VALUE;
                for (int[] envelope : envelopes){
                    if (letter[0] <= envelope[1] && letter[1] <= envelope[2]){
                        minWaste = Math.min(minWaste, envelope[0]-temp);
                    }
                }
                wastedSpace += minWaste*letter[2];
            }
            System.out.println(wastedSpace);
        }
    }
}
