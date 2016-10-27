package com.sywood.starbucks.ben.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 TODO learn binary search better and finish this problem
 */
public class ANARC05B {
    private static int firstLen, secLen;
    private static int[] first = new int[10001], sec = new int[10001];
    private static int[] memo; //stores best sum up to and including the idx.

    //first write recursive solution
    private static int solve(int fIdx, int sIdx, int pos, int sum){
        //System.out.println(fIdx + ", " + sIdx + ", " + pos + ", " + sum);
        if(fIdx >= firstLen || sIdx >= secLen)
            return sum;
        else {
            int idx = pos == 0 ? fIdx : sIdx;

            int best = Integer.MIN_VALUE;
            if(first[fIdx] == sec[sIdx]){
                best = solve(fIdx+1, sIdx+1, (pos+1)&1, sum + first[fIdx]);
            }

            sum += pos == 0 ? first[fIdx] : sec[sIdx];

            best = best > solve(fIdx+1, sIdx, pos, sum) ? best : solve(fIdx+1, sIdx, pos, sum);
            best = best > solve(fIdx+1, sIdx+1, pos, sum) ? best : solve(fIdx+1, sIdx+1, pos, sum);
            best = best > solve(fIdx, sIdx+1, pos, sum) ? best : solve(fIdx, sIdx+1, pos, sum);

            return best;
        }
    }


    public static void main(String[] args)throws Exception{
        FastScanner input = new FastScanner(System.in);
        firstLen = input.nextInt();
        while(firstLen != 0){
            for (int i = 0; i < firstLen; i++) {
                first[i] = input.nextInt();
            }
            secLen = input.nextInt();
            for (int i = 0; i < secLen; i++) {
                sec[i] = input.nextInt();
            }
            memo = new int[firstLen > secLen ? firstLen : secLen];
            Arrays.fill(memo, Integer.MIN_VALUE);
            memo[0] = first[0] > sec[0] ? first[0] : sec[0];
            System.out.println(solve(1, 1, 0, memo[0]));
            System.out.println(Arrays.toString(memo));
            firstLen = input.nextInt();
        }
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream i){
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if (st.hasMoreTokens()){
                return st.nextToken();
            }else{
                st = new StringTokenizer(br.readLine());
            }
            return next();
        }
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        public String readLine() throws IOException{
            return br.readLine();
        }
    }
}
