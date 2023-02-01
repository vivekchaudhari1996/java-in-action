package com.koko.interview;

public class SOLID {
    /**
     * Introduction
     * SOLID is an acronym for the first five object-oriented design (OOD) principles by Robert C. Martin
     * (also known as Uncle Bob). SOLID is a structured design approach that ensures your software is modular and easy
     * to maintain, understand, debug, and refactor. SOLID prevents your code from becoming rigid and fragile.
     *
     * SOLID stands for:
     * S- Single responsibility Principle
     * O- Open-closed Principle
     * L- Liskov Substitution Principle
     * I- Interface Segregation Principle
     * D- Dependency Inversion Principle
     *
     * 1. Single-Responsibility Principle
     *
     * Single-responsibility Principle (SRP) states:
     * A class should have one and only one reason to change, meaning that a class should have only one job.
     * Here’s an example of a Java class that does not follow the single responsibility principle (SRP):
     *
     * public class Vehicle {
     *     public void printDetails() {}
     *     public double calculateValue() {}
     *     public void addVehicleToDB() {}
     * }
     * The Vehicle class has three separate responsibilities: reporting, calculation, and database.
     * By applying SRP, we can separate the above class into three classes with separate responsibilities.
     *
     * 2. Open-closed principle
     *
     * Software entities (e.g., classes, modules, functions) should be open for an extension, but closed for modification.
     *
     * Consider the below method of the class VehicleCalculations:
     *
     * public class VehicleCalculations {
     *     public double calculateValue(Vehicle v) {
     *         if (v instanceof Car) {
     *             return v.getValue() * 0.8;
     *         if (v instanceof Bike) {
     *             return v.getValue() * 0.5;
     *
     *     }
     * }
     * Suppose we now want to add another subclass called Truck. We would have to modify the above class by adding another
     * if statement, which goes against the Open-Closed Principle.
     * A better approach would be for the subclasses Car and Truck to override the calculateValue method:
     *
     * public class Vehicle {
     *     public double calculateValue() {...}
     * }
     * public class Car extends Vehicle {
     *     public double calculateValue() {
     *         return this.getValue() * 0.8;
     * }
     * public class Truck extends Vehicle{
     *     public double calculateValue() {
     *         return this.getValue() * 0.9;
     * }
     * Adding another Vehicle type is as simple as making another subclass and extending from the Vehicle class.
     *
     * 3. Liskov substitution principle
     *
     * The Liskov Substitution Principle (LSP) applies to inheritance hierarchies such that derived classes
     * must be completely substitutable for their base classes.
     *
     * Consider a typical example of a Square derived class and Rectangle base class:
     *
     * public class Rectangle {
     *     private double height;
     *     private double width;
     *     public void setHeight(double h) { height = h; }
     *     public void setWidht(double w) { width = w; }
     *     ...
     * }
     * public class Square extends Rectangle {
     *     public void setHeight(double h) {
     *         super.setHeight(h);
     *         super.setWidth(h);
     *     }
     *     public void setWidth(double w) {
     *         super.setHeight(w);
     *         super.setWidth(w);
     *     }
     * }
     * The above classes do not obey LSP because you cannot replace the Rectangle base class with its derived class Square.
     * The Square class has extra constraints, i.e., the height and width must be the same. Therefore, substituting
     * Rectangle with Square class may result in unexpected behavior.
     *
     * 4. Interface segregation principle
     *
     * The Interface Segregation Principle (ISP) states that clients should not be forced to depend upon interface members
     * they do not use. In other words, do not force any client to implement an interface that is irrelevant to them.
     *
     * Suppose there’s an interface for vehicle and a Bike class:
     *
     * public interface Vehicle {
     *     public void drive();
     *     public void stop();
     *     public void refuel();
     *     public void openDoors();
     * }
     * public class Bike implements Vehicle {
     *
     *     // Can be implemented
     *     public void drive() {...}
     *     public void stop() {...}
     *     public void refuel() {...}
     *
     *     // Can not be implemented
     *     public void openDoors() {...}
     * }
     * As you can see, it does not make sense for a Bike class to implement the openDoors() method as a bike does not
     * have any doors! To fix this, ISP proposes that the interfaces be broken down into multiple, small cohesive
     * interfaces so that no class is forced to implement any interface, and therefore methods, that it does not need.
     *
     * 5. Dependency inversion principle
     *
     * The Dependency Inversion Principle (DIP) states that we should depend on abstractions (interfaces and abstract classes)
     * instead of concrete implementations (classes). The abstractions should not depend on details; instead,
     * the details should depend on abstractions.
     *
     * Consider the example below. We have a Car class that depends on the concrete Engine class; therefore,
     * it is not obeying DIP.
     *
     * public class Car {
     *     private Engine engine;
     *     public Car(Engine e) {
     *         engine = e;
     *     }
     *     public void start() {
     *         engine.start();
     *     }
     * }
     * public class Engine {
     *    public void start() {...}
     * }
     * The code will work, for now, but what if we wanted to add another engine type, let’s say a diesel engine?
     * This will require refactoring the Car class.
     * However, we can solve this by introducing a layer of abstraction. Instead of Car depending directly on Engine,
     * let’s add an interface:
     *
     * public interface Engine {
     *     public void start();
     * }
     * Now we can connect any type of Engine that implements the Engine interface to the Car class:
     *
     * public class Car {
     *     private Engine engine;
     *     public Car(Engine e) {
     *         engine = e;
     *     }
     *     public void start() {
     *         engine.start();
     *     }
     * }
     * public class PetrolEngine implements Engine {
     *    public void start() {...}
     * }
     * public class DieselEngine implements Engine {
     *    public void start() {...}
     * }
     *
     */
}
