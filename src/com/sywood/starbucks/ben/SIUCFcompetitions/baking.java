package com.sywood.starbucks.ben.SIUCFcompetitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baking {
    static class Point implements Comparable<Point>{
        double x, y;
        double theta, dist;

        public Point(double x, double y, double theta, double dist){
            this.x = x;
            this.y = y;
            this.theta = theta;
            this.dist = dist;
        }
        public int compareTo(Point o){
            if(o.theta == theta) return o.dist > dist ? -1 : 1;
            return Double.compare(theta, o.theta);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for(int i = 1; i <= n; i++){
            int c = Integer.parseInt(input.readLine());
            double coords[][] = new double[c][2];
            double polar[][] = new double[c][2];
            Point[] points = new Point[c];
            for (int j = 0; j < c; j++) {
                String data[] = input.readLine().split(" ");
                coords[j][0] = Integer.parseInt(data[0]);
                coords[j][1] = Integer.parseInt(data[1]);

                polar[j][0] = Math.abs(Math.atan(coords[j][1]/coords[j][0]));
                if(coords[j][0] < 0 && coords[j][1] > 0) polar[j][0] = 3.1415926535 - polar[j][0];
                else if(coords[j][0] < 0 && coords[j][1] < 0) polar[j][0] = 3.1415926534 + polar[j][0];
                else if (coords[j][0] > 0 && coords[j][1] < 0) polar[j][0] = 3.14159265*2 - polar[j][0];
                polar[j][1] = coords[j][0]*coords[j][1];
                points[j] = new Point(coords[j][0], coords[j][1], polar[j][0], polar[j][1]);
            }

            Arrays.sort(points);
            int totSum = 0;

            for(int j = 0; j < c-1; j++){
                totSum += coords[j][0]*coords[j+1][1];
            }
            for(int j = c-1; j > 0; j--)
                totSum -= coords[j][0]*coords[j-1][1];
            System.out.println(Math.abs(totSum/2));
        }
    }
}
