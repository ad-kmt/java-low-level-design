package org.kmt.lld.design.patterns.creational.abstractfactory;



/**
 * Demonstrates the usage of Abstract Factory in creating themed UI components.
 *
 * Pattern Overview:
 * The Abstract Factory pattern offers a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes. In this scenario, the pattern is used to create UI components that adhere to a specific theme (e.g., Light or Dark theme) dynamically.
 *
 * Components:
 * - AbstractFactory (UIFactory): An interface declaring a set of methods for creating abstract products. In this case, the UIFactory provides methods for creating themed Button and Checkbox components.
 * - ConcreteFactory (LightThemeFactory, DarkThemeFactory): Implements the AbstractFactory interface to generate concrete products. Each factory corresponds to a different theme and creates UI components consistent with that theme.
 * - AbstractProduct (Button, Checkbox): Declares an interface for a type of product object. Here, we have two kinds of product interfaces indicating the operations that all concrete products must implement.
 * - ConcreteProduct (LightButton, DarkButton, LightCheckbox, DarkCheckbox): Defines a product object to be created by the corresponding concrete factory. Implements the AbstractProduct interface.
 * - Client (AbstractFactoryDemo): Uses interfaces declared by the AbstractFactory and AbstractProduct classes. The client is decoupled from the concrete classes but can use the objects created by the factories.
 *
 */
public class AbstractUIFactoryMethod {
    public static void main(String[] args) {
        UIFactory factory = new LightThemeFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.paint();
        checkbox.paint();

        factory = new DarkThemeFactory();
        button = factory.createButton();
        checkbox = factory.createCheckbox();
        button.paint();
        checkbox.paint();
    }

    /**
     * Interface for Button products. Defines the operation all buttons must implement.
     */
    private interface Button {
        void paint();
    }

    /**
     * Interface for Checkbox products. Defines the operation all checkboxes must implement.
     */
    private interface Checkbox {
        void paint();
    }

    /**
     * Concrete implementation of Button for the Light theme.
     */
    private static class LightButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering button in light theme.");
        }
    }

    /**
     * Concrete implementation of Button for the Dark theme.
     */
    private static class DarkButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering button in dark theme.");
        }
    }

    /**
     * Concrete implementation of Checkbox for the Light theme.
     */
    private static class LightCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering checkbox in light theme.");
        }
    }

    /**
     * Concrete implementation of Checkbox for the Dark theme.
     */
    private static class DarkCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering checkbox in dark theme.");
        }
    }

    /**
     * AbstractFactory interface for creating families of related objects.
     * In this case, UI components like Buttons and Checkboxes.
     */
    private interface UIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    /**
     * Concrete factory for creating Light-themed UI components.
     */
    private static class LightThemeFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new LightButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new LightCheckbox();
        }
    }

    /**
     * Concrete factory for creating Dark-themed UI components.
     */
    private static class DarkThemeFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new DarkButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new DarkCheckbox();
        }
    }
}

