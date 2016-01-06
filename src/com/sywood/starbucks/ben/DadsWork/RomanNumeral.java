package com.sywood.starbucks.ben.DadsWork;

import java.util.Scanner;


public class RomanNumeral {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the type of number you wish to convert to? Roman numeral (r) or base 10 (10)");
        String inp = input.next();

        if (inp.equals("10")){
            System.out.print("What is the number you wish to convert?: ");
            int num = input.nextInt();
            String retStr = "";

            if (num >= 1000){
                int numM = num / 1000;
                for (int i = 0; i < numM; i++) {
                    retStr = retStr + 'M';
                }
                num -= 1000*numM;
            }
            if (num >= 500){
                int numD = num / 500;
                num -= 500*numD;
                for (int i = 0; i < numD; i++) {
                    retStr = retStr + 'D';
                }
            }
            if (num >= 100){
                if (500 > num && num > 400){
                    num -= 400;
                    retStr += "CD";
                }
                else{
                    int numC = num / 100;
                    for (int i = 0; i < numC; i++) {
                        retStr += 'C';
                    }
                    num -= numC*100;
                }
            if (num >= 50);
                if (100 > num && num > 90){
                    num -= 90;
                    retStr += "XC";
                }
                else{
                    int numL = num / 50;
                    for (int i = 0; i < numL; i++) {
                        retStr += "L";
                    }
                    num -= numL*50;
                }
                }
            if (num >= 10){
                if (50 > num && num > 40){
                    num -= 40;
                    retStr += "XL";
                }
                int numX = num/10;
                for (int i = 0; i < numX; i++) {
                    retStr += "X";
                }
                num -= numX*10;
            }
            if (num >= 5){
                if (num == 9){
                    retStr += "IX";
                    num -= 9;
                }
                else{
                    int numV = num / 5;
                    for (int i = 0; i < numV; i++) {
                        retStr += "V";
                    }
                    num -= numV*5;
                }
            }
            if (num >= 0){
                if (num == 4){
                    retStr += "IV";
                    num -= 4;
                }
                else{
                    int numI = num;
                    for (int i = 0; i < numI; i++) {
                        retStr += "I";
                    }
                }
            }
            System.out.print(retStr);
        }
        else if (inp.equals("r")){
            System.out.print("What is the number you wish to convert?: ");
            String rNum = input.next();
        }
    }
}
