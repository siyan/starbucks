package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */

import  java.util.Scanner;

public class Romannum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the number?");
        String num = input.next();
        num =num.substring(0,4);
        int th = num.toCharArray()[0] -48 ;
        int hun = num.toCharArray()[1] -48;
        int ten = num.toCharArray()[2] -48;
        int uno = num.toCharArray()[3] -48;
        String Rth = "";
        String Rhud = "";
        String Rte = "";
        String Runo = "";

        for(int i=0;i<th;i++){
            Rth = Rth + "M";
        }

        if(hun<4){
            for(int i=0;i<hun;i++){
                Rhud = Rhud +"C";
            }
        }else{
            if(hun<8){
                if(hun<5){
                    for(int i=0;i<hun-3;i++){
                        Rhud = Rhud +"C";
                    }
                    Rhud = Rhud +"D";
                }else{
                    Rhud = Rhud +"D";
                    for(int i=0;i<hun-5;i++){
                        Rhud = Rhud +"C";
                    }
                }
            }else{
                for(int i=0;i<10-hun;i++){
                    Rhud = Rhud +"C";
                }
                Rhud = Rhud +"M";
            }
        }

        if(ten<4){
            for(int i=0;i<ten;i++){
                Rte = Rte +"X";
            }
        }else{
            if(ten<8){
                if(ten<5){
                    for(int i=0;i<ten-3;i++){
                        Rte = Rte +"X";
                    }
                    Rte = Rte +"L";
                }else{
                    Rte = Rte +"L";
                    for(int i=0;i<ten-5;i++){
                        Rte = Rte +"X";
                    }
                }
            }else{
                for(int i=0;i<10-ten;i++){
                    Rte = Rte +"X";
                }
                Rte = Rte +"C";
            }
        }

        if(uno<4){
            for(int i=0;i<uno;i++){
                Runo = Runo +"X";
            }
        }else{
            if(uno<8){
                if(uno<5){
                    for(int i=0;i<uno-3;i++){
                        Runo = Runo +"I";
                    }
                    Runo = Runo +"V";
                }else{
                    Runo = Runo+"V";
                    for(int i=0;i<uno-5;i++){
                        Runo = Runo +"I";
                    }
                }
            }else{
                for(int i=0;i<10-uno;i++){
                    Runo = Runo +"I";
                }
                Runo = Runo +"X";
            }
        }
        String roma = Rth + Rhud + Rte +Runo;
        System.out.println(roma);

    }
}
