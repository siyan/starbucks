package com.sywood.starbucks.ben.ICSChallengeQuestions;

import java.util.Scanner;

public class Q6 {
    static int counter = 0;
    public static void solve(int step, int n, String start, String aux, String end) {
        counter++;
        System.out.println("CALLED METHOD WITH PARAMETERS:\nn: " + n + ", start: " + start + ", aux: " + aux + ", end: " + end);
        System.out.println("LEVEL NUMBER: " + step);
        System.out.println("STATE: ");
        if (n == 1) {
            System.out.println("CONDITION: n == 1");
            System.out.print("OUTPUT: ");
            System.out.println(start + " -> " + end);
        } else {
            System.out.println("CONDITION: ELSE");
            System.out.println("STATE NUMBER: " + step + ", solve #1");
            solve(step+1, n - 1, start, end, aux);
            System.out.print("OUTPUT: ");
            System.out.println(start + " -> " + end);
            System.out.println("STATE NUMBER: " + step + ", solve #2");
            solve(step+1, n - 1, aux, start, end);
        }
    }
    public static void main(String[] args) {
        Scanner Stdin = new Scanner(System.in);
        System.out.print("Enter number of discs: ");
        int discs = Stdin.nextInt();
        solve(1, discs, "A", "B", "C");
        System.out.println("TOTAL NUMBER OF FUNCTION CALLS: " + counter);
    }
}
