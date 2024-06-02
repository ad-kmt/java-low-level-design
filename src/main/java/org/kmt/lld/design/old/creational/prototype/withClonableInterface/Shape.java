package org.kmt.lld.design.old.creational.prototype.withClonableInterface;

public interface Shape extends Cloneable {
    public Shape makeCopy();

    public boolean equals(Shape shape);
}
