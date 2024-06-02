package org.kmt.lld.design.old.creational.prototype.withClonableInterface;

public class Circle implements Shape {

    public int radius;

    @Override
    public Shape makeCopy() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return circle;
    }

    @Override
    public boolean equals(Shape shape) {
        if (!(shape instanceof Circle shape2)) return false;
        return shape2.radius == radius;
    }
}
