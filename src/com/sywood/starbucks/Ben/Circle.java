package com.sywood.starbucks.Ben;

import com.sywood.starbucks.siyan.AbstractShape;

public class Circle extends AbstractShape {
    private String name;
    private double r;
    public Circle(String CName, double rad){
        name = CName;
        r = rad;
    }
    public String name() {
        return name;
    }

    public double area() {
        return r*r*Math.PI;
    }
}