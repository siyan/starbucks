package com.sywood.starbucks.siyan.algo;

import com.sywood.starbucks.siyan.BTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by siyan on 2016-06-22.
 */
public class UVa00679 {


    private static BTreeNode buildTree( int level ) {
        BTreeNode root = new BTreeNode( 1 );

        for( int l = 1; l < level; l++ ) {

        }

        return root;
    }

    private static int run(int I, int D ) {

        BTreeNode root = buildTree( I );
    }

    public static void main( String[] args ) throws IOException {
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
