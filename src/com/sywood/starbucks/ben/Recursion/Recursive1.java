package com.sywood.starbucks.ben.Recursion;

import java.lang.reflect.Array;

/**
 * Created by Striker on 2015-08-22.
 */
public class Recursive1 {

    public static int triangle(int num){
        if (num == 0){
            return 0;
        } else if (num == 1){
            return 1;
        }
        return num+triangle(num-1);
    }
    public static int stringCounter(String whole, String sub){

            int subLen = sub.length();

            if( whole == null || whole.length() == 0 || sub == null) {
                return 0;
            }
            else if ( sub.equalsIgnoreCase( whole.substring( 0, subLen) )) {
                return 1 + stringCounter( whole.substring(subLen), sub );
            }
            else {
                return stringCounter(whole.substring(1), sub );
            }
        }
    public static String allStar(String ret) {
        if (ret.length() == 0) {
            return "";
        }else if (ret.length() == 1){
            return ret;
        }else{
            return ret.substring(0, 1) + "*" + allStar(ret.substring(1));
        }
    }

    public static boolean strCopies(String whole, String sub, int num){

        return stringCounter(whole, sub) == num;
    }

    public static int sumDigits(int num){
        if (num < 10){
            return num;
        } else{
            return num%10 + sumDigits(num/10);
        }
    }
    public static int countPairs(String str){
        if( str == null || str.length() <= 2) {
            return 0;
        }
        if (str.charAt(0) == str.charAt(2)) {
            return 1 + countPairs(str.substring(2));
        }else{
            return countPairs(str.substring(2));
        }
    }

    public static String stringClean(String inp) {
        if ( inp == null || inp.length() < 2) {
            return inp;
        }else if (inp.charAt(0) == inp.charAt(1)){
            return stringClean(inp.substring(1));
        }else{
            return inp.substring(0, 1) + stringClean(inp.substring(1));
        }
    }

    public static String noX(String inp){
        if (inp == null || inp == "x" || inp.equals("")){
            return "";
        } else if (inp.charAt(0) == 'x'){
            return noX(inp.substring(1));
        } else{
            return inp.charAt(0) + noX(inp.substring(1));
        }
    }

    public static boolean array6(int[] arr, int start){
        if (arr.length == 0 || arr.length == start-1){
            return false;
        } else if (arr[start] == 6){
            return true;
        }else{
            return array6(arr, start+1);
        }
    }

    public static String changePi(String inp){
        if (inp.length() < 2){
            return inp;
        } else if (inp.charAt(0) == 'p'){
            if (inp.charAt(1) == 'i'){
                return "3.14" + changePi(inp.substring(2));
            }else{
                return inp.charAt(0) + changePi(inp.substring(1));
            }
        }else{
            return inp.charAt(0) + changePi(inp.substring(1));
        }
    }

    public static boolean nestParen(String inp) {
        if (inp.length() == 0) {
            return true;
        }else if (inp.length() < 2){
            return false;
        }else if(inp.charAt(0) == '(' && inp.charAt(inp.length()-1) == ')' && inp.length() == 2){
            return true;
        }else{
            if (inp.charAt(0) == '(' && inp.charAt(inp.length() -1) == ')'){
                return nestParen(inp.substring(1 , inp.length()-2));
            }else{
                return nestParen(inp.substring(1));
            }
        }
    }

    public static String parenBit(String inp){
         if (inp == null || inp.length() < 2 || inp.charAt(0) == '(' && inp.charAt(inp.length() -1) == ')'){
             return inp;
         }else if(inp.charAt(0) == '('){
             return inp.charAt(0) + parenBit(inp.substring(1));
         }else if(inp.charAt(inp.length()-1) == ')'){
             return parenBit(inp.substring(0, inp.length()-1));
         }else{
             return "ERROR" + inp;
         }
    }

    public static void towerOfHanoi(int disk, String source, String dest, String spare){
        if (disk == 0){
            System.out.println("Moved " + disk + " from " + source + " to " + dest);
        }else{
            towerOfHanoi(disk-1, source, spare, dest);
            System.out.println("Moved " + disk + " from " + source + " to " + dest);
            towerOfHanoi(disk - 1, spare, dest, source);
            System.out.println("Moved " + disk + " from " + source + " to " + dest);

        }
    }

    public static void timeToWord(String time){
        String[] TIMES = new String[]
                {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                 "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                 "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
                 "twenty six", "twenty seven", "twenty eight", "twenty nine"};
        int hour = 0;
        String ret = "";
        int mins = 0;
        if (time.length() == 4){
            hour += Integer.parseInt(time.substring(0, 1));
            mins = Integer.parseInt(time.substring(2));
        }else{
            hour = Integer.parseInt(time.substring(0, 2));
            mins = Integer.parseInt(time.substring(3));
        }
        if (mins == 0){
            System.out.println(TIMES[hour-1] + " o'clock");
        }else{
            if (mins < 30){
                if (mins == 15){
                    System.out.println("Quarter past " + TIMES[hour-1]);
                }else{
                    System.out.println((TIMES[mins-1] + " past " + TIMES[hour-1]));
                }
            }else if (mins == 30){
                System.out.println("half past " + TIMES[hour-1]);
            }else{
                mins = 60 - mins;
                if (mins == 15){
                    System.out.println("quarter to " + TIMES[hour]);
                }else{
                    System.out.println(TIMES[mins-1] + " to " + TIMES[hour]);
                }
            }
        }
    }

    public static int quarterMachine(int quarters, int first, int second, int third){
        int rounds = 0;
        while(quarters > 0){
            if (quarters > 0) {
                quarters -= 1;
                if (first < 35) {
                    first += 1;
                } else if (first == 35) {
                    first = 0;
                    quarters += 30;
                }
                rounds += 1;
            }

            if (quarters > 0 ){
                quarters -= 1;
                if (second < 100){
                    second += 1;
                }else if (second == 100){
                    second = 0;
                    quarters += 60;
                }
                rounds += 1;
            }

            if (quarters > 0){
                quarters -= 1;
                if (third < 10){
                    third += 1;
                }else if (third == 10){
                    third = 0;
                    quarters += 9;
                }
                rounds += 1;
            }
        }
        return rounds;
    }

    public static int countHi2(String hi){
        if (hi.length() < 2){
            return 0;
        }else if (hi.charAt(0) == 'h'){
            if (hi.charAt(1) == 'i'){
                return 1 + countHi2(hi.substring(1));
            }else{
                return countHi2(hi.substring(1));
            }
        }else if (hi.charAt(0) == 'x'){
            if (hi.length() >= 3){
                return countHi2(hi.substring(2));
            }else{
                return 0;
            }
        }else{
            return countHi2(hi.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(countHi2("xhixhi"));
    }
}
