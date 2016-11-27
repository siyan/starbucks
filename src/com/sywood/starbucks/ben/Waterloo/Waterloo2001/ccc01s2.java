package com.sywood.starbucks.ben.Waterloo.Waterloo2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc01s2 {
    static int len;
    static String intToString(int num){
        String curr = Integer.toString(num);
        for (int i = 0; i + curr.length() <= len; i++) {
            curr = " " + curr;
        }
        return curr;
    }
    static String genSpaces(int count){
        if(count == 0) return "";
        String ret = "";
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < len; j++) {
                ret += " ";
            }
        }
        return ret.substring(0, ret.length());
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(input.readLine());
        int e = Integer.parseInt(input.readLine());

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.get(0).add(s);
        int length = 1;
        int num = s+1;
        int row = 0;

        if(s != e) {
            for (int i = s + 1; i <= e; i++) {
                if ((length & 1) == 1) {//odd numbered length
                    //increase rows, add new arrayList
                    matrix.add(new ArrayList<>());
                    for (int j = 1; j <= length; j++) {
                        matrix.get(row + j).add(0, num++);
                        if (num - 1 == e) break;
                    }
                    if (num - 1 == e) break;
                    row += length;
                    //add numbers to bottom row
                    for (int j = 1; j <= length; j++) {
                        matrix.get(row).add(num++);
                        if (num - 1 == e) break;
                    }
                    if (num - 1 == e) break;
                } else {
                    //increase rows, add new arrayList
                    matrix.add(0, new ArrayList<>());
                    row++;
                    for (int j = 1; j <= length; j++) {
                        matrix.get(row - j).add(num++);
                        if (num - 1 == e) break;
                    }
                    if (num - 1 == e) break;
                    row -= length;
                    //add numbers to bottom row
                    for (int j = 1; j <= length; j++) {
                        matrix.get(0).add(0, num++);
                        if (num - 1 == e) break;
                    }
                    if (num - 1 == e) break;
                }
                length++;
            }
            if (e > 10)
                //spacing between letters is 3.
                len = 3;
            else
                len = 2;

            String curr = "";
            String ret;
            for (int i = matrix.size() - 1; i > 0; i--) {
                ret = intToString(matrix.get(i).get(0));
                for (int j = 1; j < matrix.get(i).size(); j++)
                    ret += intToString(matrix.get(i).get(j));
                curr = ret + "\n" + curr;
            }

            ret = genSpaces(matrix.get(matrix.size() - 1).size() - matrix.get(0).size());

            for (int i = 0; i < matrix.get(0).size(); i++)
                ret += intToString(matrix.get(0).get(i));

            curr = ret + "\n" + curr;
            System.out.println(curr);

        }else{
            System.out.println(s);
        }
    }
}
