package com.sywood.starbucks.ben.Waterloo.Waterloo2000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ccc00s3 {
    static boolean[][] matrix = new boolean[101][101];
    static int max;
    private static boolean bfs(int start, int end){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        visited[start] = true;
        for (int i = 0; i < max; i++) {
            if(matrix[start][i]) q.addLast(i);
        }
        for(; !q.isEmpty();){
            int curr = q.poll();
            for(int i = 0; i < max; i++){
                if(matrix[curr][i] && !visited[i])q.addLast(i);
                if(i == end) return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        HashMap<String, Integer> urlToIdx = new HashMap<>();
        int count = 0;
        String curr;
        for (int i = 0; i < n; i++) {
            curr = input.readLine();
            urlToIdx.put(curr, count++);
            for(String line = input.readLine(); !line.equals("</HTML>"); line = input.readLine()){
                if(line.contains("<A HREF=")){
                    String[] arr = line.split("<A HREF=");
                    for(String link : arr){
                        if(link.contains("\">")) {
                            String lnk = link.substring(1, link.indexOf("\">"));
                            if (!urlToIdx.containsKey(lnk))
                                urlToIdx.put(lnk, count++);
                            System.out.println("Link from " + curr + " to " + lnk);
                            matrix[urlToIdx.get(curr)][urlToIdx.get(lnk)] = true;
                        }
                    }
                }
            }
        }
        max = count;
        //all links have been processed
        String l1 = input.readLine();
        String l2;
        for(; !l1.trim().equals("The End"); l1 = input.readLine()){
            l2 = input.readLine();
            if(bfs(urlToIdx.get(l1), urlToIdx.get(l2))) System.out.println("Can surf from " + l1 + " to " + l2 + ".");
            else System.out.println("Can't surf from " + l1 + " to " + l2 + ".");
        }
    }
}