package com.sywood.starbucks.ben.ICSChallengeQuestions;

import java.io.PrintWriter;
import java.util.Scanner;



/*
Tuned using quarter-comma mean tone tuning
a seventeenth is: 5
a major third is: 5/4
a fifth is : 5^(0.25), since a seventeenth is 4 stacked fifths
a whole tone is: sqrt(5)/2.0: two fifths up and an octave down
a semitone is: 2^3/pow(5, 5/4.0): three octaves up, five fifths down
 */

public class Q7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        System.out.print("input fundamental frequency: ");
        double base = in.nextDouble();
        double root = Math.pow(5, 0.25);
        double f = 1;
        out.printf("Root: %f\n", base*f);
        f = Math.pow(root, 2)/2.0;
        out.printf("Maj. 2: %f\n", base*f);
        f = Math.pow(root, 4)/4.0;
        out.printf("Maj. 3: %f\n", base*f);
        f = Math.pow(root, -1)*2.0;
        out.printf("Per. 4: %f\n", base*f);
        f = root;
        out.printf("Per. 5: %f\n", base*f);
        f = Math.pow(root, 3)/2.0;
        out.printf("Maj. 6: %f\n", base*f);
        f = Math.pow(root, 5)/4.0;
        out.printf("Maj. 7: %f\n", base*f);
        f = 2;
        out.printf("Per. Octave: %f\n", base*f);
        out.close();

    }
}
