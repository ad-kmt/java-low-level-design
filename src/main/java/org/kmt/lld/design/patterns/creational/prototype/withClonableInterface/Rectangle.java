package org.kmt.lld.design.patterns.creational.prototype.withClonableInterface;

public class Rectangle implements Shape{
    public int width;
    public int height;


    @Override
    public Shape makeCopy() {
        Rectangle rectangle = null;
        try {
            rectangle = (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return rectangle;
    }

    @Override
    public boolean equals(Shape object2) {
        if (!(object2 instanceof Rectangle shape2)) return false;
        return shape2.width == width && shape2.height == height;
    }
}
