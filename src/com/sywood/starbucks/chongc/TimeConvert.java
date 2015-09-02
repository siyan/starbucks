package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/31.
 */
import java.util.Scanner;
public class TimeConvert {
    public static void main(String[] args){

        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!
        //THERE ARE ERROR IN THIS PROGRAM!!

        String[] numberWord ={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","twenty"};
        Scanner input = new Scanner(System.in);
        System.out.println("hour?");
        String h = input.next();
        System.out.println();
        System.out.println("minute?");
        String m = input.next();
        int hour;
        if(h.length()==1){
            hour =h.toCharArray()[0]-48;
        }else{
            hour = h.toCharArray()[1]-36;
        }
        int minuteTen = 0;
        int minuteUno;
        if(m.length()==1){
            minuteUno = m.toCharArray()[0]-48;
        }else{
            minuteTen = m.toCharArray()[1]-48;
            minuteUno = (m.toCharArray()[0])*10;


        }
        boolean counter=false;
        if(minuteTen>=3){
            if(minuteTen==3){
                if(minuteUno!=0){
                    minuteTen = 5 - minuteTen;
                    minuteUno = 10 - minuteUno;
                    counter = true;
                }
            }else{
                minuteTen = 5 - minuteTen;
                minuteUno = (10 - minuteUno) % 10;
                counter =true;
            }
        }

        String minuteWord;
        String hourWord;
        if(minuteTen==2 && minuteUno!=0){
            minuteWord = numberWord[minuteTen]+numberWord[minuteUno];
        }else{
            if(minuteTen==1 && minuteUno==5){
                minuteWord ="A quarter";
            }else {
                minuteWord = numberWord[minuteTen + minuteUno];
            }

        }
        hourWord = numberWord[hour];


        String gap;

        if(counter){
            gap = "to";
        }else{
            if(minuteTen == 0 && minuteUno == 0){
                gap = "o'clock";
            }else{
                gap = "past";
            }
        }
        System.out.print("---->" + minuteWord + " " + gap + " " + hourWord);

    }
}
