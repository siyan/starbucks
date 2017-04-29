package com.sywood.starbucks.ben.ICSChallengeQuestions;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        System.out.print("input fundamental frequency: ");
        double base = in.nextDouble();
        double root = Math.pow(5, 0.25);
        double f = 1;
        out.printf("Root: %f\n", base*f);
        f = root*root/2.0;
        out.printf("Maj. 2: %f\n", base*f);
        f = Math.pow(root, 4)*Math.pow(2, -2);
        out.printf("Maj. 3: %f\n", base*f);
        f = Math.pow(root, -1)*2;
        out.printf("Per. 4: %f\n", base*f);
        f = root;
        out.printf("Per. 5: %f\n", base*f);
        f = Math.pow(root, 3)/2.0;
        out.printf("Maj. 6: %f\n", base*f);
        f = Math.pow(root, 5)*Math.pow(2, -2);
        out.printf("Per. 8: %f\n", base*2);
        out.close();

    }
}
