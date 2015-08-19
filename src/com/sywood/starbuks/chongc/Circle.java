package com.sywood.starbuks.chongc;

import com.sywood.starbucks.siyan.AbstractShape;

/**
 * Created by згёЦ on 2015/8/19.
 */

public abstract  class Circle extends AbstractShape {

    private int r;

    public void Circle(int R){
        r=R;
    }




    public double area(){
        return r*r*3.14;
    }
}
