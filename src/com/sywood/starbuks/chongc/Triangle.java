package com.sywood.starbuks.chongc;

import com.sywood.starbucks.siyan.AbstractShape;

/**
 * Created by згёЦ on 2015/8/19.
 */

public class Triangle extends AbstractShape {
    private int a;
    private int b;
    private int c;

    public void Triangle(int A,int B,int C){
        a=A;
        b=B;
        c=C;
    }


    public double area(){
        int p;
        p=(a+b+c)/2;

        return Math.sqrt((p-a)*(p-b)*(p-c)*p);
    }
}