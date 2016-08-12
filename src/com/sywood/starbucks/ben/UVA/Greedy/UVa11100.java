package com.sywood.starbucks.ben.UVA.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * First pre-sort/sort greedy underlined problem.
 */
public class UVa11100 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        StringTokenizer st;
        int max;
        String ret;
        String line = input.readLine();
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        PriorityQueue<Integer> current = new PriorityQueue<>();
        PriorityQueue<Integer> other = new PriorityQueue<>();
        PriorityQueue<String> print = new PriorityQueue<>();

        while(!line.equals("0")){
            int n = Integer.parseInt(line);
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }
            while(!numbers.isEmpty() || !other.isEmpty()){
                ret = "";
                if (!numbers.isEmpty()){
                    current.add(numbers.poll());
                    max = current.peek();
                    while(!numbers.isEmpty()){
                        if (max < numbers.peek()){
                            max = numbers.poll();
                            current.add(max);
                        }else{
                            other.add(numbers.poll());
                        }
                    }
                }else{
                    current.add(other.poll());
                    max = current.peek();
                    while(!other.isEmpty()){
                        if(max < other.peek()){
                            max = other.poll();
                            current.add(max);
                        }else{
                            numbers.add(other.poll());
                        }
                    }
                }
                for(int num : current){
                    ret += num + " ";
                }
                print.add(ret.trim());
                current.clear();
            }
            printer.println(print.size());
            for(String toPrint : print){
                printer.println(toPrint);
            }
            line = input.readLine();

            numbers.clear();
            current.clear();
            print.clear();
            other.clear();
        }
        printer.close();
    }
}