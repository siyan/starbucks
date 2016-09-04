package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * First queue question. ->>> last question in DS, switched to DP
 */
public class UVa10172 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter printer = new PrintWriter(System.out);

        int T = Integer.parseInt(input.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken()); //number of stations
            int S = Integer.parseInt(st.nextToken()); //max number of items cargo carrier can hold
            int Q = Integer.parseInt(st.nextToken()); //max number of things platform B can hold

            ArrayDeque<Integer>[] platforms = new ArrayDeque[N]; //array of platform b queues

            boolean finished;

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(input.readLine());
                int n = Integer.parseInt(st.nextToken());
                platforms[i] = new ArrayDeque<>();
                for (int j = 0; j < n; j++) {
                    platforms[i].addLast(Integer.parseInt(st.nextToken())-1);
                }
            }

            ArrayDeque<Integer> carrier = new ArrayDeque<>(); //functions as a STACK
            int i = 0, time = 0;
            while(true){

                while(!carrier.isEmpty() && platforms[i].size() < Q){ //unloading carrier
                    if (carrier.peek() == i)
                        carrier.pop();
                    else
                        platforms[i].addLast(carrier.pop());
                    time++;
                }

                while(!platforms[i].isEmpty() && carrier.size() < S){
                    carrier.push(platforms[i].pop());
                    time++;
                }

                finished = carrier.isEmpty();

                for (int j = 0; j < N && finished; j++) {
                    finished = platforms[i].isEmpty();
                }

                if(finished)
                    break;

                time += 2;
                i = (i+1)%N;
            }
            printer.println(time);
        }

        printer.close();
    }
}
