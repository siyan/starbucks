package com.sywood.starbucks.ben.Waterloo.Waterloo2000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ccc00s5 {
    private static class Sheep implements Comparable<Sheep>{
        double x, y;
        public Sheep(double x, double y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Sheep o){
            if(y == o.y){
                if(x == o.x) return 0;
                return x > o.x ? 1 : -1;
            }
            return y > o.y ? 1 : -1;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        TreeSet<Sheep> sheeps = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            sheeps.add(new Sheep(Double.parseDouble(input.readLine()), Double.parseDouble(input.readLine())));
        }
        double minDist = sheeps.first().y;
        Sheep curr;
        for(; !sheeps.isEmpty();){
            curr = sheeps.pollFirst();
            if(Math.abs(curr.y-minDist) <= 0.1){
                System.out.print("The sheep at (");
                System.out.printf("%.02f", curr.x);
                System.out.print(", ");
                System.out.printf("%.02f", curr.y);
                System.out.println(") might be eaten.");
            }
            else break;
        }
    }
}
