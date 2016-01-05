package com.sywood.starbucks.ben.WCIPEG;
import java.math.BigInteger;
import java.util.Scanner;

public class CCC92S2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = Integer.parseInt(input.nextLine());
        for (int i = 0; i < iters; i++) {
            BigInteger num = new BigInteger(input.nextLine());
            BigInteger digit = num.mod(BigInteger.TEN);
            while (num.compareTo(BigInteger.valueOf(99)) == 1){
                System.out.println(num);
                digit = num.divideAndRemainder(BigInteger.TEN)[1];
                num = num.divideAndRemainder(BigInteger.TEN)[0];
                num = num.subtract(digit);
            }
            System.out.println(num);
            if (num.mod(BigInteger.TEN.add(BigInteger.ONE)) == BigInteger.ZERO){
                System.out.println("The number " + num + " is divisible by 11.");
            }else{
                System.out.println("The number " + num + " is not divisible by 11");
            }
        }
    }
}
