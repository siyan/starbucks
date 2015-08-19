package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
import java.util.Scanner;


public class Comett {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("WHAT IS THE NAME OF THE COMET????? ");
        String com = input.next();
        System.out.print("WHAT IS THE NAME OF THE GROUP????? ");
        String gro = input.next();
        com = com.toUpperCase();
        gro = gro.toUpperCase();
        com = com.substring(0,6);
        gro = gro.substring(0,6);
        int[] c;
        int[] g;
        c =new int[com.length()];
        g =new int[gro.length()];
        int vc=1 ;
        int vg=1 ;

        for(int i=0;i<com.length();i++){
            int co = com.toCharArray()[i];
            c[i]=co-64;

            vc=vc*c[i];

        }


        for(int i=0;i<gro.length();i++){
            int gr =gro.toCharArray()[i];
            g[i]=gr-64;

            vg=vg*g[i];
        }
        int cc;
        int gg;
        cc = vc % 47;
        gg = vg %47 ;
        boolean go = cc == gg;
        if(go){
            System.out.println("GO");
        }else{
            System.out.println("STAY");
        }







    }
}
