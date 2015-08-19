package com.sywood.starbuks.chongc;

import com.sywood.starbucks.siyan.AbstractShape;

/**
 * Created by згёЦ on 2015/8/19.
 */
public class Rectangle extends AbstractShape {
    private int l;
    private int w;

    public void Rectangle(int L,int W){
        l=L;
        w=W;

    }




    public double area(){
        return l*w;
    }
}