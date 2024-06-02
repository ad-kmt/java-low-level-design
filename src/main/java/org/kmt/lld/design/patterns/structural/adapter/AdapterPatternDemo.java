package org.kmt.lld.design.patterns.structural.adapter;

/**
 * Adapter Design Pattern Example
 *
 * Problem:
 * Incompatible objects need to work together. For example, integrating SquarePegs into a system designed for RoundHoles.
 *
 * Solution:
 * The Adapter pattern allows incompatible objects to collaborate by converting the interface of a class into another interface the client expects.
 *
 * Components:
 * - Adapter: Converts the interface of a class into another interface clients expect.
 * - Adaptee: The class with an incompatible interface.
 * - Client: Uses the Adapter to work with Adaptee.
 *
 * Classes:
 * 1. RoundHole:
 *    - Represents a round hole.
 *    - Contains methods to get the radius and check if a RoundPeg fits.
 *
 * 2. RoundPeg:
 *    - Represents a round peg.
 *    - Contains methods to get the radius.
 *
 * 3. SquarePeg:
 *    - Represents a square peg.
 *    - Contains methods to get the width and calculate the square.
 *
 * 4. SquarePegAdapter:
 *    - Adapts the interface of SquarePeg to be compatible with RoundHole.
 *    - Extends RoundPeg and overrides the getRadius method.
 *
 * 5. Demo:
 *    - Client code that demonstrates the use of the Adapter pattern.
 */

// RoundHole class
class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        // Check if the peg fits in the hole
        return this.getRadius() >= peg.getRadius();
    }
}

// RoundPeg class
class RoundPeg {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

// SquarePeg class
class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        // Calculate the square of the width
        return Math.pow(this.width, 2);
    }
}

// SquarePegAdapter class
class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        // Calculate a minimum circle radius that can fit this peg
        return Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2);
    }
}

// Demo class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Create a round hole with radius 5
        RoundHole hole = new RoundHole(5);

        // Create a round peg with radius 5
        RoundPeg rpeg = new RoundPeg(5);

        // Check if the round peg fits in the round hole
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        // Create square pegs with widths 2 and 20
        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        // Use the adapter to make square pegs compatible with round holes
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);

        // Check if the adapted small square peg fits in the round hole
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }

        // Check if the adapted large square peg fits in the round hole
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
