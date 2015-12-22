package com.sywood.starbucks.ben.Waterloo2010;
import java.util.Scanner;

public class Waterloo20102 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int s = input.nextInt();
        int Nikky = 0;
        int Byron = 0;
        int useStepA = a;
        int useStepB = c;
        boolean A = true;
        boolean B = true;
        for (int i = 0; i < s; i++) {
            if (A & useStepA == 0){
                A = false;
                useStepA = b;
            }else if (!A & useStepA == 0){
                A = false;
                useStepA = a;
            }
            if (B & useStepB == 0){
                B = false;
                useStepA = d;
            }else if (!B & useStepB == 0){
                B = false;
                useStepA = c;
            }
            if (A){
                Nikky++;
                useStepA--;
            }else{
                Nikky--;
                useStepA--;
            }if (B){
                Byron++;
                useStepB--;
            }else{
                Byron--;
                useStepB--;
            }
        }
        if (Nikky > Byron){
            System.out.print("Nikky");
        }else if (Byron > Nikky){
            System.out.print("Byron");
        }else{
            System.out.print("Tied");
        }
    }
}
