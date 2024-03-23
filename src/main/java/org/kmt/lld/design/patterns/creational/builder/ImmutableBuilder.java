package org.kmt.lld.design.patterns.creational.builder;



/**
 * Demonstrates the creation of an immutable Person object using the Builder pattern.
 */
public class ImmutableBuilder {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .withName("Aditya")
                .withAge(25)
                .withAddress("Bangalore")
                .build();

        System.out.println("Person Name: " + person.getName());
        System.out.println("Person Age: " + person.getAge());
        System.out.println("Person Address: " + person.getAddress());
    }

    /**
     * Represents an immutable Person object.
     * Once a Person object is created, its state cannot be altered.
     */
    private static final class Person {
        private final String name;
        private final int age;
        private final String address;

        /**
         * Private constructor to be accessed by the Builder only.
         * Initializes the immutable fields of the Person object.
         */
        private Person(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.address = builder.address;
        }

        // Getters for accessing the properties
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        /**
         * The Builder class for Person.
         * Facilitates the step-by-step construction of a Person object.
         */
        public static class Builder {
            private String name;
            private int age;
            private String address;

            public Builder withName(String name) {
                this.name = name;
                return this;
            }

            public Builder withAge(int age) {
                this.age = age;
                return this;
            }

            public Builder withAddress(String address) {
                this.address = address;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }

}



