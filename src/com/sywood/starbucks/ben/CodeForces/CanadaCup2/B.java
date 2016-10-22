package com.sywood.starbucks.ben.CodeForces.CanadaCup2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String seat = input.readLine();
        String strRow = "" + seat.charAt(0);
        for (int i = 1; i < seat.length() - 1; i++) {
            strRow += seat.charAt(i);
        }
        long row = Long.parseLong(strRow)-1;
        long time;
        int sit = seat.charAt(seat.length()-1)- 'a';

        if(sit < 3)
            time = 4 + sit;
        else{
            if(sit == 5)
                time = 1;
            else if(sit == 4)
                time = 2;
            else
                time = 3;
        }

        long shift = row/4;
        long remainder = row%4;

        if(remainder%2 == 1)
            time += 7*(shift*2+1) + 2*(shift);
        else
            time += 4*(4*shift);


        System.out.println(time);
    }
}
