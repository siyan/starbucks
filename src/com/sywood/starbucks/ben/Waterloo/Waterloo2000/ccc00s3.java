package com.sywood.starbucks.ben.Waterloo.Waterloo2000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ccc00s3 {
    static boolean[][] matrix = new boolean[2500][2500];
    static int max;
    private static boolean bfs(int start, int end){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[2500];
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
        PrintWriter printer = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine().trim());

        HashMap<String, Integer> urlToIdx = new HashMap<>();
        int count = 0;
        String curr;
        for (int i = 0; i < n; i++) {
            curr = input.readLine();
            urlToIdx.put(curr, count++);
            for(String line = input.readLine(); !line.equals("</HTML>"); line = input.readLine()){
                int startPos = line.indexOf("HREF=");
                while( startPos > -1 ) {
                    int endPos = line.indexOf("\"", startPos+6);
                    String linkUrl = line.substring( startPos+6, endPos);
                    if(!urlToIdx.containsKey(linkUrl))
                        urlToIdx.put( linkUrl, count++ );

                    printer.println("Link from " + curr + " to " + linkUrl);
                    matrix[urlToIdx.get(curr)][urlToIdx.get(linkUrl)] = true;
                    startPos = line.indexOf("HREF=", endPos);
                }
            }
        }

        max = count;
        //all links have been processed
        String l1 = input.readLine();
        String l2;
        for(; !l1.trim().equals("The End"); ){
            l2 = input.readLine();
            if(bfs(urlToIdx.get(l1), urlToIdx.get(l2))) printer.println("Can surf from " + l1 + " to " + l2 + ".");
            else printer.println("Can't surf from " + l1 + " to " + l2 + ".");
            l1 = input.readLine();
        }
        printer.close();
    }
}