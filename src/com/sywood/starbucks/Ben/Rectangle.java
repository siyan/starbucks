package com.sywood.starbucks.Ben;

import com.sywood.starbucks.siyan.AbstractShape;

/**
 * Created by Striker on 2015-08-18.
 */
public class Rectangle extends AbstractShape {
    private double l, w;
    private String name;
    public Rectangle(double length, double width, String N){
        l = length;
        w = width;
        name = N;
    }
    public String name() {
        return name;
    }

    public double area() {
        return l*w;
    }
}
