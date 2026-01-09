# Zoo Management System (OOP Assignment 2)

## Description
This project is a Java-based Zoo Management System designed to demonstrate the core principles of Object-Oriented Programming. It manages various entities within a zoo, such as Animals and ZooKeepers, and provides functionality to store, filter, and sort data.

## Installation & Running
1.  **Prerequisites:** Ensure you have Java JDK (version 8 or higher) installed.
2.  **Compilation:** Open your terminal/IDE and compile the files:
    ```bash
    javac *.java
    ```
3.  **Execution:** Run the main class:
    ```bash
    java Main
    ```

## Requirements Implemented

### 1. Data Abstraction
- Created an **abstract class** `Creature` as a blueprint for all living entities in the zoo.
- It prevents the direct instantiation of generic creatures, focusing on specific types (Animal/ZooKeeper).

### 2. Encapsulation
- All class fields (e.g., `name`, `age`, `species`) are marked as **private**.
- Access is provided through **public getters and setters**, ensuring data integrity.

### 3. Inheritance
- **Animal** and **ZooKeeper** classes extend the `Creature` base class.
- This promotes code reuse and establishes a clear "is-a" relationship.

### 4. Polymorphism
- **Method Overriding:** The `toString()` method is overridden across the hierarchy to provide specific details for each object type.
- Used polymorphic behavior when printing objects from the data pool.

### 5. Data Pool Management
- Implemented a **List-based data pool** in the `Zoo` class using `ArrayList`.
- **Filtering:** Added functionality to find animals by their species.
- **Sorting:** Implemented sorting by age using `Comparator`.

### 6. Standard Method Overriding
- Overridden `toString()` for meaningful object representation.
- Overridden `equals()` and `hashCode()` in the `Creature` class to allow proper object comparison based on state rather than memory address.