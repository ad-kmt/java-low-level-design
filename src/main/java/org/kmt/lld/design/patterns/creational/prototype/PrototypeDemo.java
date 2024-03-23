package org.kmt.lld.design.patterns.creational.prototype;

/**
 * Prototype Pattern Java Example.
 *
 * Pattern Overview:
 * The Prototype pattern is utilized to clone objects from a prototype rather than instantiating
 * new objects from scratch, particularly useful when object creation is a costly operation.
 *
 * Summary:
 * This example demonstrates the Prototype pattern by creating a cloneable Shape interface.
 * It allows for the creation of new Shape objects by cloning existing instances, providing
 * a way to produce objects without knowing their specific classes, enhancing runtime flexibility.
 *
 * Components Used:
 * - Shape: An interface that defines the clone operation.
 * - Circle and Rectangle: Concrete implementations of the Shape interface that can be cloned.
 */

// Prototype interface with a method for cloning itself
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Concrete implementation of Shape that can be cloned
class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    // Copy constructor for cloning
    public Circle(Circle circle) {
        this.radius = circle.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public void draw() {
        System.out.println("Circle with radius: " + radius);
    }
}

// Another concrete implementation of Shape
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Copy constructor for cloning
    public Rectangle(Rectangle rectangle) {
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle with width: " + width + " and height: " + height);
    }
}

// Demonstrating the Prototype pattern
public class PrototypeDemo {
    public static void main(String[] args) {
        Shape originalCircle = new Circle(10);
        Shape clonedCircle = originalCircle.clone();
        clonedCircle.draw();

        Shape originalRectangle = new Rectangle(20, 30);
        Shape clonedRectangle = originalRectangle.clone();
        clonedRectangle.draw();
    }
}

