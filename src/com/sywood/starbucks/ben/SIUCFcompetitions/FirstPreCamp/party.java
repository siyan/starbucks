package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;//package com.sywood.starbucks.ben.SIUCFcompetitions.FirstPreCamp;
import java.io.*;
import java.util.Arrays;

public class party {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while (!line.equals("0")){
            int n = Integer.parseInt(line);
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = input.readLine();
            }
            Arrays.sort(names);
            int center = (n-1)/2;
            String first = names[center];
            String second = names[center+1];
            String middle = "";
            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                char f = first.charAt(i);
                char s = second.charAt(i);
                int inbetween = (f+s)/2;
                if (inbetween != f){
                    inbetween = (char)(f+1);
                    middle += (char)inbetween;
                    break;
                }
                middle += (char)inbetween;
            }
            System.out.println(middle);
            line = input.readLine();
        }
    }
}
