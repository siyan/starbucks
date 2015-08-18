package com.sywood.starbucks.siyan;

/**
 * Created by siyan on 8/17/15.
 */
public abstract class AbstractShape {
    private String _name;

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public abstract double area();
}
