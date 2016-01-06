package com.sywood.starbucks.ben.DadsWork;

import com.sywood.starbucks.siyan.AbstractShape;

/**
 * Created by Striker on 2015-08-18.
 */
public class Triangle extends AbstractShape {
    private double a, b, c;
    private String name;

    public Triangle(double A, double B, double C, String N){
        a = A;
        b = B;
        c = C;
        name = N;
    }

    public String name() {
        return name;
    }

    public double area() {
        double S = (a+b+c)/2;
        return Math.sqrt(((S-a)*(S-b)*(S-c)*S));
    }
}
