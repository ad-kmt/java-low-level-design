package org.kmt.lld.design.patterns.creational.prototype;

/**
 * Demonstrates a shallow copy in Java using the Cloneable interface.
 *
 * Cloneable Interface: The Cloneable interface facilitates the prototype pattern in Java
 * by enabling object cloning through the `clone()` method
 *
 * Shallow Copy: In a shallow copy, only the object's top-level fields are copied, and if the field
 * is a reference, both the original and the clone will refer to the same object.
 */
public class ShallowCopyExample implements Cloneable {
    // An array to demonstrate the effect of shallow copying on references.
    private int[] data;

    // Constructor initializes the data array with some values.
    public ShallowCopyExample() {
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

    // Override the clone method to provide public access and implement shallow copying.
    @Override
    protected ShallowCopyExample clone() throws CloneNotSupportedException {
        return (ShallowCopyExample) super.clone();
    }

    // Main method to demonstrate the effect of shallow copying.
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowCopyExample original = new ShallowCopyExample();
        ShallowCopyExample cloned = original.clone();

        // Modifying the cloned object's data array also affects the original object.
        cloned.setData(0, 100);
        System.out.println("Original's first element: " + original.getData()[0]);
        System.out.println("Clone's first element: " + cloned.getData()[0]);
        // Output: Original's first element: 100, indicating that both original and cloned
        // objects share the same 'data' array (shallow copy).
    }
}