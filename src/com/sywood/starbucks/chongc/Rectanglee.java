package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/20.
 */
public class Rectanglee implements Shappe {
    private int l;
    private int w;
    private String n;
    public Rectanglee(int Ll,int Ww,String Nn){
        l=Ll;
        w=Ww;
        n=Nn;
    }
    public String name(){
        return n;
    }
    public double area(){
        return l*w;
    }
}
