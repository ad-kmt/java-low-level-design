package org.kmt.lld.design.patterns.creational.prototype.withClonableInterface;

public interface Shape extends Cloneable {
    public Shape makeCopy();

    public boolean equals(Shape shape);
}
