package com.sywood.starbucks.ben.USACOTraining.Chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 ID: benbli
 LANG: JAVA
 TASK: castle
 */
public class castle {
    private static int[] dr = new int[]{1, -1, 0, 0}; // 4 directions
    private static int[] dc = new int[]{0, 0, 1, -1}; //4 directions

    private static int R, C;
    private static int[][] colours;
    private static module[][] paths;

    private static int floodfill(int row, int col, int c1, int c2) {
        if (row < 0 || row >= R || col < 0 || col >= C)
            return 0;

        if (colours[row][col] != c1)
            return 0; //exited the boundaries of the colour

        int ans = 1;
        colours[row][col] = c2;

        for(int d = 0; d < 4; d++) {
            if(paths[row][col].canTravel(d)) {
                ans += floodfill(row + dr[d], col + dc[d], c1, c2);
            }
        }
        return ans;
    }

    private static class module{
        int walls;
        module(int wall){
            this.walls = wall;
        }

        boolean canTravel(int dIdx){
            if(dIdx == 0){
                return (walls&8) == 0; //south
            }else if(dIdx == 1){
                return (walls&2) == 0; //north
            }else if(dIdx == 2){
                return (walls&4) == 0; //east
            }else if(dIdx == 3){
                return (walls&1) == 0; //west
            }
            return false;
        }
    }

    private static class dirCol implements Comparable<dirCol>{
        int dir;
        int row;
        int col;
        int area;

        dirCol(int row, int col, int dir, int area){
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.area = area;
        }

        public int compareTo(dirCol o){
            if(area > o.area) return -1;
            else if (area < o.area)return 1;
            else{
                //areas are equal: then look for farthest west
                if(col == o.col){
                    if(row == o.row){
                        if(dir == o.dir)
                            return 0;
                        return dir < o.dir ? -1 : 1;
                    }
                    return row > o.row ? -1 : 1;
                }
                return col < o.col ? -1 : 1;
            }
        }

        public String toString(){
            String ret = (row + 1) + " " + (col+1) + " ";

            if(dir == 1)
                ret += "N";
            else
                ret += "E";
            return ret;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("castle.in")));
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        String[] data = input.readLine().split(" ");
        int M = Integer.parseInt(data[0]);
        int N = Integer.parseInt(data[1]);
        R = N;
        C = M;
        colours = new int[N][M];
        paths = new module[N][M];

        StringTokenizer st;

        for(int i = 0; i < N; i++){ //reads in rows
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < M; j++){ //inflates by two to avoid things
                paths[i][j] = new module(Integer.parseInt(st.nextToken()));
            }
        }
        int col = 1;
        int largest = 0;
        ArrayList<Integer> areas = new ArrayList<Integer>();
        for (int j = 0; j < M; j++)
            for (int i = 0; i < N; i++)
                if(colours[i][j] == 0) {
                    areas.add(floodfill(i, j, 0, col++));
                    largest = Math.max(largest, areas.get(col-2));
                }

        ArrayList<Integer>[] adj = new ArrayList[areas.size()];
        ArrayList<dirCol> modules = new ArrayList<dirCol>();

        for (int i = 0; i < areas.size(); i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int j = 0; j < M; j++) //travel west to east down columns
            for(int i = N-1; i >= 0; i--) //travel from south-north
                //search all adjacent squares, looking to see if there's a wall
                //AND if it's a different colour
                for (int k = 0; k < 4; k++)
                    if(!paths[i][j].canTravel(k))
                        if(i+dr[k] >= 0 && i+dr[k] < N && j+dc[k] >= 0 && j+dc[k] < M)
                            if (colours[i][j] != colours[i + dr[k]][j + dc[k]])
                                if (!adj[colours[i][j]-1].contains(colours[i + dr[k]][j + dc[k]])) {
                                    adj[colours[i][j] - 1].add(colours[i + dr[k]][j + dc[k]]);
                                    modules.add(new dirCol(i, j, k,
                                            areas.get(colours[i][j] - 1) + areas.get(colours[i + dr[k]][j + dc[k]]-1)));
                                    //System.out.println(modules.get(modules.size()-1).toString() + " " + modules.get(modules.size()-1).area);
                                }

        Collections.sort(modules);
        printer.println(col-1);
        printer.println(largest);
        printer.println(modules.get(0).area);
        printer.println(modules.get(0).toString());

        printer.close();
    }
}
