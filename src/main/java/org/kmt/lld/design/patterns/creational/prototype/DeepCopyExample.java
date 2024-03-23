package org.kmt.lld.design.patterns.creational.prototype;

import java.util.Arrays;

/**
 * Demonstrates a deep copy in Java using the Cloneable interface.
 *
 * Cloneable Interface: The Cloneable interface facilitates the prototype pattern in Java
 * by enabling object cloning through the `clone()` method
 *
 * Deep Copy: A deep copy involves copying the object and recursively copying objects referenced
 * by it, ensuring complete independence of the clone from the original.
 */
public class DeepCopyExample implements Cloneable {
    // An array to demonstrate the effect of deep copying on references.
    private int[] data;

    // Constructor initializes the data array with some values.
    public DeepCopyExample() {
        data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

    // Method to modify an element of the data array.
    public void setData(int index, int value) {
        data[index] = value;
    }

    // Method to access the data array.
    public int[] getData() {
        return data;
    }

    // Override the clone method to provide public access and implement deep copying.
    @Override
    protected DeepCopyExample clone() throws CloneNotSupportedException {
        DeepCopyExample clone = (DeepCopyExample) super.clone();
        // Explicitly cloning the internal array for a deep copy.
        clone.data = data.clone();
        return clone;
    }

    // Main method to demonstrate the effect of deep copying.
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCopyExample original = new DeepCopyExample();
        DeepCopyExample cloned = original.clone();

        // Modifying the cloned object's data array does not affect the original object.
        cloned.setData(0, 100);
        System.out.println("Original's first element: " + original.getData()[0]);
        System.out.println("Clone's first element: " + cloned.getData()[0]);
        // Output: Original's first element: 0, indicating that original and cloned
        // objects do not share the same 'data' array (deep copy).
    }
}

