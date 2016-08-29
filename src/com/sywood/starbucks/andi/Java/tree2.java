package com.sywood.starbucks.andi.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Andi Gu
 */
public class tree2 {
    public static int[][] nextPositions(int[][] matrix, int currentX, int currentY) {
        int[] xDirections = new int[] {-1, 1, 0, 0};
        int[] yDirections = new int[] {0, 0, 1, -1};
        int[][] nextPositions = new int[4][2];
        for (int i=0; i < 4; i ++) {
            int newX = currentX + xDirections[i], newY = currentY + yDirections[i];

        }
        return 0;
    }

    public static int solve(int[][] matrix, int startX, int startY, int targetX, int targetY) {
        int[][] cost = new int[matrix.length][matrix[0].length];
        int[][] nTrees = new int[matrix.length][matrix[0].length];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[startX][startY] = 0;
        for (int[] row : nTrees) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        nTrees[startX][startY] = 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]), columns = Integer.parseInt(tokens[1]);
        int[][] trees = new int[rows][columns];
        int startX = -1, startY = -1;
        int tallestTreeHeight = 0;
        for (int i=0; i < rows; i ++) {
            tokens = reader.readLine().split(" ");
            for (int j=0; j < columns; j ++) {
                switch (tokens[j]) {
                    case "X":
                        startX = i;
                        startY = j;
                        trees[i][j] = -1;
                        break;
                    case ".":
                        trees[i][j] = 0;
                        break;
                    default:
                        trees[i][j] = Integer.parseInt(tokens[j]);
                        if (trees[i][j] > tallestTreeHeight) {
                            tallestTreeHeight = trees[i][j];
                        }
                        break;
                }
            }
        }

        double closestDist = Integer.MAX_VALUE;
        int tallestTreeX=-1, tallestTreeY=-1;
        for (int i=0; i < rows; i ++) {
            for (int j=0; j < columns; j ++) {
                double dist = Math.pow(i - startX, 2) + Math.pow(j - startY, 2);
                if (dist < closestDist) {
                    closestDist = dist;
                    tallestTreeX = i;
                    tallestTreeY = j;
                }
            }
        }
    }
}
