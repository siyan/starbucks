package com.sywood.starbucks.ben.UVA.DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * second underlined 2d array question
 *
 * We notice that the X or Y position of any number in a line of a ring is constant.
 *
 9 (5,5)

 10 (6,5)
 11 (6,4)
 12 (6,3)
 13 (6,2)

 14 (5,2)
 15 (4,2)
 16 (3,2)
 17 (2,2)

 18 (2,3)
 19 (2,4)
 20 (2,5)
 21 (2,6)

 22 (3,6)
 23 (4,6)
 24 (5,6)
 25 (6,6)
 */
public class UVa10920 {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        String[] data;
        long SZ, P, baseCoord, baseSqrt, nextSqrt, bS, nS, segmentLength, maxCoord, minCoord, second, third, fourth, x, y;

        while(!line.equals("0 0")){
            data = line.split(" ");
            SZ = Long.parseLong(data[0]);
            P = Long.parseLong(data[1]);
            baseCoord = SZ/2+1;

            baseSqrt = (int) Math.sqrt(P);
            baseSqrt -= (baseSqrt+1)%2;

            bS = baseSqrt*baseSqrt;
            nextSqrt = baseSqrt +2;
            nS = nextSqrt*nextSqrt;
            segmentLength = (nS-bS)/4; // finds the length of the ring in which point P is located
            baseCoord += (baseSqrt-1)/2; // this is the coordinate of the baseSqrt, which we use to calculate everything else

            maxCoord = baseCoord+1; //initialized as the next number (right after the base square)
            minCoord = baseCoord-baseSqrt; // the last item of the line. The changing coordinate is always decreasing.

            second = bS + segmentLength + 1; // start of the second line in the ring
            third = second + segmentLength; // start of the third line in the ring
            fourth = third + segmentLength; // start of the fourth line in the ring

            if (bS < P && P < second){
                x = maxCoord;
                y = (maxCoord-1) - (P-(bS +1));
            }else if(second <= P && P < third){
                x = (maxCoord-1) - (P-second);
                y = minCoord;
            }else if(third <= P && P < fourth){
                x = minCoord;
                y = minCoord + 1 + (P-third);
            } else if (fourth <= P && P <= nS){
                x = minCoord + 1 + (P-fourth);
                y = maxCoord;
            }else{
                x = baseCoord;
                y = baseCoord;
            }
            printer.printf("Line = %d, column = %d.\n", x, y);
            line = input.readLine();
        }

        printer.close();
    }
}
