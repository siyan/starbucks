package com.sywood.starbucks.ben.DadsWork;

//addded a comment
import com.sywood.starbucks.siyan.AbstractShape;

public class Circle extends AbstractShape {
    private String nam;
    private double ra;
    public Circle(String CName, double rad){
        nam = CName;
        ra = rad;
    }
    public String name() {
        return nam;
    }

    public double area() {
        return ra*ra*Math.PI;
    }
}