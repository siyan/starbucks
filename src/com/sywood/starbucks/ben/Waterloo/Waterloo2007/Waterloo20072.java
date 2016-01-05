package com.sywood.starbucks.ben.Waterloo.Waterloo2007;
import java.util.Scanner;

public class Waterloo20072 {
    public static String conversion(String enter) {
        if (enter.equals("CU")){
            return "see you";
        }else if (enter.equals(":-)")){
            return "I'm Happy";
        }else if (enter.equals(":-(")){
            return "I'm unhappy";
        }else if (enter.equals(";-)")){
            return "wink";
        }else if (enter.equals(":-P")){
            return "stick out my tongue";
        }else if (enter.equals("(˜.˜)")){
            return "sleepy";
        }else if (enter.equals("TA")){
            return "totally awesome";
        }else if (enter.equals("CCC")){
            return "Canadian Computing Competition";
        }else if (enter.equals("CUZ")){
            return "because";
        }else if (enter.equals("TY")) {
            return "thank-you";
        }else if (enter.equals("YW")){
            return "you're welcome";
        }else if (enter.equals("TTYL")){
            return "talk to you later";
        }else {
            return enter;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter phrase>");
        String inp = conversion(input.nextLine());
        while (!inp.equals("talk to you later")){
            System.out.println(inp);
            System.out.print("Enter phrase>");
            inp = conversion(input.nextLine());
        }
        System.out.println("talk to you later");
    }
}
