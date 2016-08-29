package com.sywood.starbucks.andi.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Andi Gu
 */
public class tree2 {
    private static final int[] xDirections = new int[]{1, -1, 0, 0};
    private static final int[] yDirections = new int[]{0, 0, 1, -1};

    private static int solve(int[][] matrix, int startX, int startY, int targetX, int targetY) {
        int[][] cost = new int[matrix.length][matrix[0].length];
        int[][] nTrees = new int[matrix.length][matrix[0].length];
        Set<int[]> queue = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cost[i][j] = 1000000000;
                nTrees[i][j] = 1000000000;
                queue.add(new int[]{i, j});
            }
        }
        cost[startX][startY] = 0;
        nTrees[startX][startY] = 0;
        while (queue.size() > 0) {
            int[] current = new int[]{-1, -1};
            int smallestCost = Integer.MAX_VALUE;
            for (int[] coordinates : queue) {
                int tempCost = cost[coordinates[0]][coordinates[1]];
                if (tempCost < smallestCost) {
                    smallestCost = cost[coordinates[0]][coordinates[1]];
                    current = coordinates;
                }
            }
            queue.remove(current);
            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + xDirections[i], nextY = current[1] + yDirections[i];
                if (nextX < matrix.length & nextX >= 0 & nextY < matrix[0].length & nextY >= 0) {
                    int tempCost = cost[current[0]][current[1]] + matrix[nextX][nextY];
                    if (tempCost < cost[nextX][nextY]) {
                        cost[nextX][nextY] = tempCost;
                        if (matrix[nextX][nextY] == 0) {
                            nTrees[nextX][nextY] = nTrees[current[0]][current[1]];
                        } else {
                            nTrees[nextX][nextY] = nTrees[current[0]][current[1]] + 1;
                        }
                    } else if (tempCost == cost[nextX][nextY]) {
                        if (nTrees[current[0]][current[1]] + 1 < nTrees[nextX][nextY]) {
                            if (matrix[nextX][nextY] == 0) {
                                nTrees[nextX][nextY] = nTrees[current[0]][current[1]];
                            } else {
                                nTrees[nextX][nextY] = nTrees[current[0]][current[1]] + 1;
                            }
                        }
                    }
                }
            }
        }
        return nTrees[targetX][targetY] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]), columns = Integer.parseInt(tokens[1]);
        int[][] trees = new int[rows][columns];
        int startX = -1, startY = -1;
        int tallestTreeHeight = 0;
        for (int i = 0; i < rows; i++) {
            tokens = reader.readLine().split(" ");
            for (int j = 0; j < columns; j++) {
                switch (tokens[j]) {
                    case "X":
                        startX = i;
                        startY = j;
                        trees[i][j] = 0;
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
        int tallestTreeX = -1, tallestTreeY = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (trees[i][j] == tallestTreeHeight) {
                    double dist = Math.pow(i - startX, 2) + Math.pow(j - startY, 2);
                    if (dist < closestDist) {
                        closestDist = dist;
                        tallestTreeX = i;
                        tallestTreeY = j;
                    }
                }
            }
        }
        System.out.println(solve(trees, startX, startY, tallestTreeX, tallestTreeY));
    }
}
