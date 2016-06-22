package com.sywood.starbucks.ben.UVA.DivideAndConquer;
import java.io.*;
import java.util.HashMap;

public class UVa00679 {
    static HashMap<Integer, int[]> drop = new HashMap<>();
    static HashMap<Integer, Boolean> simulate = new HashMap<>();
    private static void generate(int depth){
        int nodeNum = 1;
        for (int row = 0; row < depth-1; row++) {
            for (int i = 0; i < Math.pow(2, row); i++) {
                int[] temp = new int[]{2 * nodeNum, 2 * nodeNum + 1};
                drop.put(nodeNum, temp);
                simulate.put(nodeNum, false);
                simulate.put(2*nodeNum, false);
                simulate.put(2*nodeNum+1, false);
                nodeNum++;
            }
        }
    }
    private static int run(int I, int D){
        int currNode = 1;
        generate(D);
        for (int i = 0; i < I; i++) {
            currNode = 1;
            for (int j = 1; j < D; j++) {
                if (!simulate.get(currNode)){
                    simulate.replace(currNode, true);
                    currNode = drop.get(currNode)[0];
                }else{
                    simulate.replace(currNode, false);
                    currNode = drop.get(currNode)[1];
                }
            }
        }
        return currNode;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(input.readLine());
        for (int i = 0; i < max; i++) {
            String[] test = input.readLine().split(" ");
            int D = Integer.parseInt(test[0]);
            int I = Integer.parseInt(test[1])%(int)Math.pow(2, D);
            System.out.println(run(I, D));
        }
    }
}
