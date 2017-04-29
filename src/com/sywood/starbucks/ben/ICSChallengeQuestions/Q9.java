package com.sywood.starbucks.ben.ICSChallengeQuestions;

public class Q9{
    static long calc(int[][] matrix){
        if(matrix.length == 2){
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        long sum = 0;
        int sz = matrix.length;
        int[][] nxt = new int[sz-1][sz-1];
        int add = 1;
        for(int i = 0; i < matrix.length; i++){
            //this is the excluded column.
            int cnt = 0;
            for(int j = 0; j < sz; j++){
                if(j == i) continue;
                for(int k = 1; k < sz; k++) {
                    //System.out.println(k);
                    nxt[k-1][cnt] = matrix[k][j];
                }
                cnt++;
            }
            sum += matrix[0][i]*add*calc(nxt);

            //System.out.println(matrix[0][i] + ", " + add + ", " + calc(nxt));
            add *= -1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int test[][] = new int[][]{{6, 1, 1}, {4, -2, 5}, {2, 8, 7}};
        System.out.println(calc(test));
    }
}
