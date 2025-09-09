# Kotlin Design Patterns

A comprehensive collection of design patterns implemented in Kotlin, demonstrating modern software architecture principles and best practices.

## Table of Contents

- [Creational Patterns](#creational-patterns)
- [Structural Patterns](#structural-patterns)
- [Behavioral Patterns](#behavioral-patterns)

##  Creational Patterns

Creational patterns provide various object creation mechanisms, increasing flexibility and reuse of existing code.

### Builder Pattern
**File:** `BuilderPattern.kt`  
**Description:** Immutable object construction with readable API. Allows step-by-step construction of complex objects while keeping them immutable and ensuring proper validation.

### Factory Method Pattern
**File:** `FactoryMethod.kt`  
**Description:** Subclass decides product creation. Provides an interface for creating objects but lets subclasses alter the type of objects that will be created.

### Abstract Factory Pattern
**File:** `AbstractFactory.kt`  
**Description:** Factory of factories for related product families. Creates families of related objects without specifying their concrete classes.

### Simple/Static Factory Pattern
**File:** `SimpleOrStaticFactory.kt`  
**Description:** Static method to create products based on type. Encapsulates object creation logic in a single static method for simple use cases.

### Prototype Pattern
**File:** `PrototypeUsingDataClass.kt`  
**Description:** Clone objects using Kotlin data class copy(). Creates new objects by copying existing instances, leveraging Kotlin's built-in copy functionality.

### Singleton Pattern
**Files:**
- `SingletonUsingObject.kt` - Kotlin object singleton
- `SingletonDoubleChecked.kt` - Double-checked locking singleton

**Description:** Ensures a class has only one instance and provides global access to it. Two implementations: thread-safe Kotlin object and traditional double-checked locking.

## Structural Patterns

Structural patterns explain how to assemble objects and classes into larger structures while keeping the structures flexible and efficient.

### Adapter Pattern
**File:** `Adapter.kt`  
**Description:** Bridge incompatible interfaces. Allows objects with incompatible interfaces to work together by creating a wrapper that translates one interface to another.

### Decorator Pattern
**File:** `Decorator.kt`  
**Description:** Add features to objects without altering core functionality. Dynamically adds new behaviors to objects by wrapping them in decorator classes.

### Facade Pattern
**File:** `Facade.kt`  
**Description:** Hide complexity behind a simple interface. Provides a simplified interface to a complex subsystem, making it easier to use.

##  Behavioral Patterns

Behavioral patterns focus on communication between objects and the assignment of responsibilities between them.

### Command Pattern
**File:** `Command.kt`  
**Description:** Encapsulate actions as objects. Turns requests into stand-alone objects containing all information about the request, enabling parameterization, queuing, and undo operations.

### Observer Pattern
**File:** `Observer.kt`  
**Description:** Pub-sub mechanism for state change notifications. Defines a one-to-many dependency between objects so that when one object changes state, all dependents are notified automatically.

### Strategy Pattern
**File:** `StrategyPattern.kt`  
**Description:** Interchangeable algorithms at runtime. Defines a family of algorithms, encapsulates each one, and makes them interchangeable without changing client code.

## Pattern Categories

| Category | Count | Purpose |
|----------|-------|---------|
| **Creational** | 6 | Object creation mechanisms |
| **Structural** | 3 | Object composition and relationships |
| **Behavioral** | 3 | Communication patterns and responsibilities |

