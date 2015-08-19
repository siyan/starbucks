package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
public class Trianglee implements Shappe {

    private int a;
    private int b;
    private int c;
    private String n;

    public Trianglee(int Aa,int Bb,int Cc,String Nn){
        a=Aa;
        b=Bb;
        c=Cc;
        n=Nn;
    }

    public String name() {
        return n;
    }
    public double area(){
        int h= (a+b+c)/2;
        return java.lang.Math.sqrt((h-a)*(h-b)*(h-c)*h);


    }
}
