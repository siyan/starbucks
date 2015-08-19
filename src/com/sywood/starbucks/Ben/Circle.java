package com.sywood.starbucks.Ben;

import com.sywood.starbucks.siyan.AbstractShape;

public class Circle extends AbstractShape {
    private String nam;
    private double r;
    public Circle(String CName, double rad){
        nam = CName;
        r = rad;
    }
    public String name() {
        return nam;
    }

    public double area() {
        return r*r*Math.PI;
    }
}