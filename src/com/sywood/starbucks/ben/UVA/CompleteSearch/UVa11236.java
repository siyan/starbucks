package com.sywood.starbucks.ben.UVA.CompleteSearch;

import java.io.PrintWriter;

/**
 * this question involves simplifying a+b+c+d = abcde;
 * The smallest unit is in 100ths of an euro.
 * a/100 + b/100 + c/100 + d/100 = a/100*b/100*c/100*d/100
 *                 (a+b+c+d)/100 = (abcd)/10^8
 *                       a+b+c+d = abcd/10^6
 *                (a+b+c+d)*10^6 = abcd ----> division is bad in coding.
 *
 * The code was then optimized by solving for d in the equation, with j = abc, and i = a+b+c, and c = 10^6.
 *                       c*(i+d) = jd
 *                       ci + cd = jd
 *                            ci = jd - cd
 *                            ci = d(j-c)
 *                      ci/(j-c) = d
 *         10^6*abc/(a+b+c-10^6) = d
 *
 *         note that there is the restriction abc != 10^6
 *
 * upper bounds were calculated using the products of each number. if each number was the max (2000),
 * then the product would have to be less than or equal to 2*10^9
 *
 int counter = 0;
 int con = 1000000;
 for (long a = 1; a < 2000; a++) {
 for (long b = a; b < 2000; b++) {
 for (long c = b; c < 2000; c++) {
 if (a*b*c*c > 2000000000L)break;
 long product = a * b * c;
 long sum = a + b + c;
 long half = sum * con;
 long otherHalf = product - con;
 if (otherHalf != 0 && half%otherHalf == 0){
 long d = half/otherHalf;
 if (d < 0 || c > d){
 break;
 }
 if (sum+d <= 2000 && product*d <= 2000000000){
 double ra = a/100.0;
 double rb = b/100.0;
 double rc = c/100.0;
 double rd = d/100.0;
 if (ra+rb+rc+rd == ra*rb*rc*rd){
 System.out.printf("%.2f %.2f %.2f %.2f\n", ra, rb, rc, rd);
 counter++;
 }
 }
 }
 }
 }
 }
 System.out.println(counter); <--- this code might be used later
 */

public class UVa11236 {
    public static void main(String[] args) {
        PrintWriter printer = new PrintWriter(System.out);
        long product, sum, t1, t2, d;
        for(long a = 1; a <= 2000; a++){
            if (a*a*a*a > 2000000000L) break;
            for(long b = a; b <= 2000-a; b++){
                if (a*b*b*b > 2000000000L) break;
                for(long c = b; c <= 2000-a-b; c++){
                    if (a*b*c*c > 2000000000L) break;

                    product = a*b*c;
                    if (b== 1000000) continue;
                    sum = a+b+c;

                    t1 = sum*1000000;
                    t2 = product - 1000000;
                    if (t2 > 0) {
                        if (t1 % t2 != 0) continue;
                        d = t1 / t2;
                        if (c > d) continue;
                        if (sum + d > 2000) continue;
                        if (product * d > 2000000000L) continue;
                        printer.printf("%.02f %.02f %.02f %.02f\n", a / 100.0, b / 100.0, c / 100.0, d / 100.0);
                    }
                }
            }
        }
        printer.close();
    }
}
