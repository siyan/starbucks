package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * third UVa underlined collections problem
 */
public class UVa10285 {
    private static class People implements Comparable<People>{
        int person;
        int numSolved;
        int penaltyPoints;

        People(int id, int q, boolean[] at, int[] points){
            person = id;
            numSolved = q;
            for (int i = 0; i < 9; i++) {
                if(at[i]){
                    penaltyPoints += points[i];
                }
            }
        }

        public int compareTo(People other){
            if(numSolved == other.numSolved){
                if (penaltyPoints == other.penaltyPoints){
                    return Integer.compare(person, other.person);
                }
                return Integer.compare(penaltyPoints, other.penaltyPoints);
            }else{
                return -Integer.compare(numSolved, other.numSolved);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine().trim());
        input.readLine();
        for (int i = 0; i < T; i++) {
            int[] numSolved = new int[100];
            boolean[][] questions = new boolean[100][9];
            int[][] points = new int[100][9];
            boolean[] attempted = new boolean[100];
            Arrays.fill(attempted, false);
            String line = input.readLine();
            while(line != null && !line.equals("") && !line.equals("\n")){
                String[] data = line.split(" ");
                int person = Integer.parseInt(data[0])-1;
                int question = Integer.parseInt(data[1])-1;
                attempted[person] = true;
                if(data[3].equals("I") && !questions[person][question]){
                    points[person][question] += 20;
                }else if(data[3].equals("C") && !questions[person][question]){
                    questions[person][question] = true;
                    numSolved[person]++;
                    points[person][question] += Integer.parseInt(data[2]);
                }
                line = input.readLine();
            }
            TreeSet<People> ppl = new TreeSet<>();
            for (int j = 0; j < 100; j++) {
                if (attempted[j]) {
                    People temp = new People(j, numSolved[j], questions[j], points[j]);
                    ppl.add(temp);
                }
            }
            for(People person : ppl){
                printer.printf("%d %d %d\n", person.person+1, person.numSolved, person.penaltyPoints);
            }
            if (i != T-1) {
                printer.println();
            }
        }

        printer.close();
    }
}
