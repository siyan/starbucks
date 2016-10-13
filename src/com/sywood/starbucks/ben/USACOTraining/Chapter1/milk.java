//package com.sywood.starbucks.ben.USACOTraining.Chapter1;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: milk
 */
public class milk {
    private static class farmer implements Comparable<farmer>{
        int cost;
        int amount;

        public farmer(int cost, int amount){
            this.cost = cost;
            this.amount = amount;
        }

        public int compareTo(farmer other){
            if(cost == other.cost){
                return amount > other.amount ? -1 : 1;
            }
            return cost < other.cost ? -1 : 1;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("milk.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        String[] data = input.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        PriorityQueue<farmer> farmers = new PriorityQueue<farmer>();
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            farmers.add(new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int cost = 0;
        int total = 0;
        while(total < N){
            farmer curr = farmers.poll();
            if(total+curr.amount > N){
                cost += (N-total)*curr.cost;
                total += (N-total);
            }else{
                cost += curr.amount*curr.cost;
                total += curr.amount;
            }
        }

        printer.println(cost);
        printer.close();
        input.close();
    }
}
