package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
public class Circlee implements Shappe {
    private int r;
    private String n;
    public Circlee(int Rr,String Nn){
        r=Rr;
        n=Nn;
    }

    public String name() {
        return n;
    }


    public double area() {
        return r*r*3.14;
    }
}
