+++
title= "Design Patterns"
tags = [ "system-design", "software-architecture", "patterns" ]
author = "Me"
showToc = true
TocOpen = false
draft = false
hidemeta = false
comments = false
disableShare = false
disableHLJS = false
hideSummary = false
searchHidden = true
ShowReadingTime = true
ShowBreadCrumbs = true
ShowPostNavLinks = true
ShowWordCount = true
ShowRssButtonInSectionTermList = true
UseHugoToc = true
+++



## Design Patterns 

Before we get to the design patterns themselves, there is just one more piece of housekeeping that I wanted to mention, and that is to do with the so-called Gamma categorization.

Typically, in design pattern literature, regardless of which language of design patterns we are talking about, we split all the design patterns into several different categories. These categories are often called Gamma categorization, named after Erich Gamma, one of the authors of the original Gang of Four book that uses C++ and Smalltalk.

### Gamma Categorization

1. **Creational Patterns**
    - These patterns deal with the creation or construction of objects.
    - Object construction can be more complicated than simply invoking a constructor.
    - **Explicit Creation**: Directly calling the constructor with arguments to initialize an object.
    - **Implicit Creation**: Using mechanisms like dependency injection frameworks or reflection to create objects behind the scenes.
    - **Wholesale Creation**: A single statement or constructor call is sufficient to initialize the object.
    - **Piecewise Initialization**: Several steps or statements are needed to fully initialize an object.

2. **Structural Patterns**
    - Concerned with the structure of classes and their members.
    - Focus on how classes and objects are composed to form larger structures.
    - Examples include wrappers that mimic the underlying interface they wrap.
    - Emphasize good API design, making interfaces convenient and usable for others.
    - Structural patterns often involve replicating or enhancing interfaces for better usability.

3. **Behavioral Patterns**
    - Unlike creational and structural patterns, behavioral patterns don't follow a central theme.
    - They address different problems and solve them in unique ways using various object-oriented mechanisms.
    - There may be some overlap (e.g., Strategy and Template Method patterns), but each pattern generally solves a specific problem with its own approach.
    - Behavioral patterns focus on the interaction and responsibility of objects.




# Factory Pattern 

## Factory Method and Factory Class Implementation

The Factory Method and the Factory Class design patterns, which are essential for creating objects in a way that is both flexible and adheres to object-oriented principles like the Single Responsibility Principle and Open/Closed Principle.

The discussion begins by introducing a simple Point class and evolves into explaining how to initialize points using both Cartesian and Polar coordinates while maintaining clean and understandable code.

### Factory Method Pattern

The Factory Method is a design pattern that provides an alternative to using constructors (initializers) directly for object creation. It allows for the creation of objects without specifying the exact class of the object that will be created.

#### Problem Statement:
Initially, the Point class is designed to accept Cartesian coordinates (x, y). However, if we want to add support for polar coordinates (rho, theta), we encounter issues:

- Redefining the constructor for different coordinate systems isn’t possible.
- Expanding the constructor to handle multiple coordinate systems can lead to cluttered and complex code, breaking the Single Responsibility Principle.

#### Solution:
Instead of overloading or expanding the constructor, we can create factory methods:
- Factory methods are static methods that handle the creation of objects with different initialization requirements.
- These methods clearly indicate the type of initialization (Cartesian or Polar) and keep the initialization logic encapsulated.

```python
from enum import Enum
from math import *

class CoordinateSystem(Enum):
    CARTESIAN = 1
    POLAR = 2

class Point:
    def __init__(self, a, b, system=CoordinateSystem.CARTESIAN):
        if system == CoordinateSystem.CARTESIAN:
            self.x = a
            self.y = b
        elif system == CoordinateSystem.POLAR:
            self.x = a * sin(b)
            self.y = a * cos(b)

    def __str__(self):
        return f'x: {self.x}, y: {self.y}'

    @staticmethod
    def new_cartesian_point(x, y):
        return Point(x, y)

    @staticmethod
    def new_polar_point(rho, theta):
        return Point(rho * sin(theta), rho * cos(theta))
```
In this implementation: new_cartesian_point(x, y) and new_polar_point(rho, theta) are static factory methods that create a Point object based on the coordinate system.

### Factory Class Pattern
A Factory Class centralizes the creation logic of related objects. When a class starts accumulating too many factory methods, it's often a good idea to move these methods into a separate class.

#### Problem Statement
As the number of factory methods grows, the Point class might become cluttered. This violates the Single Responsibility Principle as the class is handling both the creation and representation of points.

#### Solution
Extract the factory methods into a separate PointFactory class:

- This class will be responsible for the creation of Point objects.
- This separation ensures that the Point class only focuses on representing a point, while the factory handles object creation.

```python
class PointFactory:
    @staticmethod
    def new_cartesian_point(x, y):
        return Point(x, y)

    @staticmethod
    def new_polar_point(rho, theta):
        return Point(rho * sin(theta), rho * cos(theta))
```

In the PointFactory class: new_cartesian_point(x, y) and new_polar_point(rho, theta) methods are moved here, separating concerns.

#### Usage

```python
if __name__ == '__main__':
    p1 = Point(2, 3, CoordinateSystem.CARTESIAN)
    p2 = PointFactory.new_cartesian_point(1, 2)
    p3 = Point.Factory.new_cartesian_point(5, 6)  # Using nested factory class
    p4 = Point.factory.new_cartesian_point(7, 8)  # Singleton factory instance
    print(p1, p2, p3, p4)
```

In this example:

- PointFactory.new_cartesian_point(1, 2) creates a Cartesian point using the factory class.
- Point.factory.new_cartesian_point(7, 8) demonstrates using a singleton factory instance.

## Abstract Factory Design Pattern Implementation

The abstract factory design pattern allows for the creation of families of related objects without specifying their concrete classes. This implementation demonstrates how to use abstract factories to create different types of drinks (e.g., tea and coffee) using a vending machine scenario.

### Step-by-Step Implementation

- **HotDrink Abstract Base Class**: An abstract base class HotDrink is defined with an abstract method consume. Concrete drink classes (e.g., Tea, Coffee) inherit from this base class and implement the consume method.
- **Concrete Drink Classes**: Two concrete classes, Tea and Coffee, inherit from HotDrink and provide specific implementations of the consume method.
- **HotDrinkFactory Abstract Base Class**: An abstract base class HotDrinkFactory is defined with a method prepare. This method is meant to be overridden by concrete factory classes to prepare specific types of drinks.
- **Concrete Factory Classes**: Two concrete factory classes, TeaFactory and CoffeeFactory, inherit from HotDrinkFactory. These classes implement the prepare method to create instances of Tea and Coffee, respectively.
- **HotDrinkMachine Class**: The HotDrinkMachine class simulates a vending machine that can prepare different types of drinks. It uses an enumeration AvailableDrink to list available drink types. The machine maintains a list of factory instances for each drink type.
- **Drink Preparation**: The make_drink method in HotDrinkMachine allows the user to select a drink type and specify the amount. The corresponding factory prepares the drink, and the consume method is called to simulate drinking it.

```python
from abc import ABC
from enum import Enum, auto

# Abstract base class for drinks
class HotDrink(ABC):
    def consume(self):
        pass

# Concrete drink classes
class Tea(HotDrink):
    def consume(self):
        print('This tea is nice but I\'d prefer it with milk')

class Coffee(HotDrink):
    def consume(self):
        print('This coffee is delicious')

# Abstract base class for drink factories
class HotDrinkFactory(ABC):
    def prepare(self, amount):
        pass

# Concrete factory classes
class TeaFactory(HotDrinkFactory):
    def prepare(self, amount):
        print(f'Put in tea bag, boil water, pour {amount}ml, enjoy!')
        return Tea()

class CoffeeFactory(HotDrinkFactory):
    def prepare(self, amount):
        print(f'Grind some beans, boil water, pour {amount}ml, enjoy!')
        return Coffee()

# Vending machine class for preparing drinks
class HotDrinkMachine:
    class AvailableDrink(Enum):  # Lists available drinks
        COFFEE = auto()
        TEA = auto()

    factories = []
    initialized = False

    def __init__(self):
        if not self.initialized:
            self.initialized = True
            for d in self.AvailableDrink:
                name = d.name[0] + d.name[1:].lower()
                factory_name = name + 'Factory'
                factory_instance = eval(factory_name)()
                self.factories.append((name, factory_instance))

    def make_drink(self):
        print('Available drinks:')
        for f in self.factories:
            print(f[0])

        s = input(f'Please pick drink (0-{len(self.factories)-1}): ')
        idx = int(s)
        s = input(f'Specify amount: ')
        amount = int(s)
        return self.factories[idx][1].prepare(amount)

# Standalone function to prepare drinks
def make_drink(type):
    if type == 'tea':
        return TeaFactory().prepare(200)
    elif type == 'coffee':
        return CoffeeFactory().prepare(50)
    else:
        return None

# Main function to demonstrate the vending machine
if __name__ == '__main__':
    hdm = HotDrinkMachine()
    drink = hdm.make_drink()
    drink.consume()
```

### Key Concepts
- Abstract Base Classes (ABC): Used to define a common interface for a group of related objects.
- Concrete Implementations: Specific classes that implement the abstract methods defined in the base classes.
- Factory Pattern: A design pattern used to create objects without specifying the exact class of the object that will be created.
- Duck Typing: Python's dynamic typing feature where the type of an object is determined by its behavior (methods and properties) rather than its inheritance from a specific class.

This pattern is particularly useful in scenarios where you need to create families of related objects and want to ensure that the objects are created in a consistent manner.


# Prototype Design Pattern

The prototype design pattern is a creational design pattern that allows an object to be cloned, creating new instances by copying an existing object, known as the prototype. This pattern is particularly useful when creating a new object from scratch is resource-intensive or when an object should be replicated with slight modifications.

## Motivation
In many real-world scenarios, objects are not designed from scratch but are built upon existing designs. The prototype pattern follows this approach by allowing an existing object to be duplicated and then customized without affecting the original object. This is especially useful when the construction of objects is complex or resource-heavy.

## Key Concepts
Prototype: The original object that will be copied.
- Cloning: Creating a new instance by copying the prototype.
- Deep Copy: A type of copy where all attributes of the object are recursively copied, ensuring that the new object does not reference the same attributes as the original.
- Shallow Copy: A type of copy where only the object's references are copied, meaning that both the original and the copied object share the same references.

## Example Implementation in Python
```python
import copy

class Address:
    def __init__(self, street_address, city, country):
        self.country = country
        self.city = city
        self.street_address = street_address

    def __str__(self):
        return f'{self.street_address}, {self.city}, {self.country}'

class Person:
    def __init__(self, name, address):
        self.name = name
        self.address = address

    def __str__(self):
        return f'{self.name} lives at {self.address}'
```

### Usage

Creating a Prototype:
```python
john = Person("John", Address("123 London Road", "London", "UK"))
print(john)
```

Cloning with Deep Copy:
```python
jane = copy.deepcopy(john)
jane.name = "Jane"
jane.address.street_address = "124 London Road"
print(john, jane)
```
Output
```sh
John lives at 123 London Road, London, UK
John lives at 123 London Road, London, UK Jane lives at 124 London Road, London, UK
```
In this example, jane is created as a deep copy of john. This means jane has the same initial properties as john, but changes to jane do not affect john.

Shallow Copy Example (Not Recommended for This Case):
```python
jane = copy.copy(john)
jane.name = "Jane"
jane.address.street_address = "124 London Road"
print(john, jane)
```

Output
```sh
John lives at 124 London Road, London, UK Jane lives at 124 London Road, London, UK
```
## Benefits of the Prototype Pattern
- Efficiency: Reduces the overhead of creating complex objects from scratch.
- Flexibility: Allows the creation of new objects by varying the state of the existing objects.
- Decoupling: Clients are decoupled from the specific classes they are using, as they interact with the prototype instead of directly with the class.

# Singleton Design Pattern

The singleton design pattern ensures that a class has only one instance and provides a global point of access to that instance. This pattern is often used when exactly one object is needed to coordinate actions across the system, such as when managing shared resources like databases or configuration settings.

## Motivation
The singleton pattern is motivated by scenarios where certain classes should only be instantiated once. Common examples include:

- Database Connections: You typically only want one instance of a database connection throughout the lifecycle of an application to avoid redundant connections and ensure consistent access to the data.
- Object Factories: An object factory is often stateless and doesn't require multiple instances, making a singleton a natural choice.

The pattern is often criticized because its improper use can lead to design issues, such as hidden dependencies and difficulties in testing. However, when used appropriately, it can be a powerful tool for managing global state.

## Key Concepts
Single Instance: The singleton pattern restricts the instantiation of a class to one "single" instance.
- Global Access: Provides a global point of access to that instance.
- Lazy Instantiation: The singleton instance is created only when it is actually needed, rather than at the time of application startup.

## Example Implementation in Python

```python
import random

class Database:
    initialized = False

    def __init__(self):
        # Initialization logic (e.g., loading a database) would go here.
        pass

    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Database, cls).__new__(cls, *args, **kwargs)
        return cls._instance
```

### Usage

```python
# Creating the Singleton Instance
database = Database()

# Verifying Singleton Behavior
if __name__ == '__main__':
    d1 = Database()
    d2 = Database()

    print(d1 == d2)  # True, as both d1 and d2 refer to the same instance
    print(database == d1)  # True, database and d1 refer to the same instance
```

- Overriding __new__: The __new__ method is overridden to control the object allocation. If an instance already exists (_instance is not None), the existing instance is returned. If no instance exists, a new one is created and assigned to _instance.
- Initialization (__init__): The __init__ method is called every time an instance is created or accessed. In a singleton, this can cause issues if initialization logic (e.g., loading resources) is placed here. To avoid repeated initialization, consider adding a guard clause to prevent the execution of initialization logic if the instance is already initialized.


### Potential Issues
- Repeated Initialization: Even though the singleton ensures that only one instance of the class exists, the __init__ method might still be called multiple times. This can be problematic if __init__ performs expensive operations, like loading a database. One way to handle this is by adding an initialization flag.
- Testing: Singletons can make unit testing challenging, as they introduce hidden dependencies. In testing, you may need to reset or mock the singleton instance to ensure tests are isolated from each other.

## Benefits of the Singleton Pattern
- Controlled Access: Ensures a class has only one instance, which is useful for resources like configuration settings or loggers.
- Global State: Provides a global point of access to the instance, making it easy to share the instance across different parts of the application.


## Singleton Using a Decorator
A decorator can be used to implement the Singleton pattern by controlling the instantiation of a class and ensuring that only one instance of the class is ever created.

Code Example:

```python
def singleton(class_):
    instances = {}

    def get_instance(*args, **kwargs):
        if class_ not in instances:
            instances[class_] = class_(*args, **kwargs)
        return instances[class_]

    return get_instance


@singleton
class Database:
    def __init__(self):
        print('Loading database')


if __name__ == '__main__':
    d1 = Database()
    d2 = Database()
    print(d1 == d2)  # True, indicating that d1 and d2 are the same instance
```
- The singleton decorator keeps a dictionary of instances.
- When a class is instantiated, the decorator checks if an instance of the class already exists. If not, it creates one; otherwise, it returns the existing instance.
- The initializer is only called once, preventing multiple initializations.

## Singleton Using a Metaclass
A metaclass can also be used to create a Singleton. The metaclass ensures that only one instance of the class is created, similar to the decorator approach.

Code Example:

```python
class Singleton(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]


class Database(metaclass=Singleton):
    def __init__(self):
        print('Loading database')


if __name__ == '__main__':
    d1 = Database()
    d2 = Database()
    print(d1 == d2)  # True, indicating that d1 and d2 are the same instance
```

- The Singleton metaclass overrides the __call__ method, which is responsible for object creation.
- It checks if an instance of the class exists; if not, it creates one using the super() function.
- This approach is similar to the decorator but leverages Python's metaclass capabilities.

## Monostate (Borg) Singleton Pattern
The Monostate pattern is a variation of the Singleton pattern where all instances of the class share the same state. Unlike the traditional Singleton, it allows multiple instances but with shared state.

Code Example:
```python
class CEO:
    __shared_state = {
        'name': 'Steve',
        'age': 55
    }

    def __init__(self):
        self.__dict__ = self.__shared_state

    def __str__(self):
        return f'{self.name} is {self.age} years old'


class Monostate:
    _shared_state = {}

    def __new__(cls, *args, **kwargs):
        obj = super(Monostate, cls).__new__(cls, *args, **kwargs)
        obj.__dict__ = cls._shared_state
        return obj


class CFO(Monostate):
    def __init__(self):
        self.name = ''
        self.money_managed = 0

    def __str__(self):
        return f'{self.name} manages ${self.money_managed}bn'


if __name__ == '__main__':
    ceo1 = CEO()
    print(ceo1)

    ceo1.age = 66
    ceo2 = CEO()
    ceo2.age = 77
    print(ceo1)
    print(ceo2)

    ceo2.name = 'Tim'
    ceo3 = CEO()
    print(ceo1, ceo2, ceo3)

    cfo1 = CFO()
    cfo1.name = 'Sheryl'
    cfo1.money_managed = 1
    print(cfo1)

    cfo2 = CFO()
    cfo2.name = 'Ruth'
    cfo2.money_managed = 10
    print(cfo1, cfo2, sep='\n')
```
- In the Monostate pattern, the __shared_state or _shared_state dictionary is used to store the state of the class.
- Each instance shares the same state by setting self.__dict__ to reference this shared state.
- Changes made through any instance will affect all other instances since they all reference the same state.

## Singleton Testing

The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. In this example, the Singleton is implemented using a metaclass.
```python
class Singleton(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]
```
Here, the Singleton metaclass keeps a dictionary of instances, ensuring that only one instance of a class exists. If an instance already exists, it returns the existing instance instead of creating a new one.

**Database Class**: The Database class uses the Singleton pattern to ensure that only one instance of the database is loaded into memory.
```python
class Database(metaclass=Singleton):
    def __init__(self):
        self.population = {}
        f = open('capitals.txt', 'r')
        lines = f.readlines()
        for i in range(0, len(lines), 2):
            self.population[lines[i].strip()] = int(lines[i + 1].strip())
        f.close()
```
The Database class reads from a file named capitals.txt to load population data for various cities.

**Singleton Record Finder**: The SingletonRecordFinder class uses the Database singleton to calculate the total population of a list of cities.

```python
class SingletonRecordFinder:
    def total_population(self, cities):
        result = 0
        for c in cities:
            result += Database().population[c]
        return result
```
This approach tightly couples the record finder to the singleton database, which can make testing difficult.

**Configurable Record Finder**: To improve testability, the ConfigurableRecordFinder allows dependency injection, enabling the use of different databases for testing.

```python
class ConfigurableRecordFinder:
    def __init__(self, db):
        self.db = db

    def total_population(self, cities):
        result = 0
        for c in cities:
            result += self.db.population[c]
        return result
```

This class takes a database object as an argument, making it possible to inject a dummy database during testing.

**Dummy Database for Testing**: The DummyDatabase class is a mock database used for unit testing.
```python
class DummyDatabase:
    population = {
        'alpha': 1,
        'beta': 2,
        'gamma': 3
    }

    def get_population(self, name):
        return self.population[name]
```

This class provides predictable, hardcoded population data to facilitate reliable testing.

**Unit Tests**: The following unit tests ensure the Singleton behavior and verify the functionality of both the SingletonRecordFinder and ConfigurableRecordFinder.

```python
import unittest

class SingletonTests(unittest.TestCase):
    def test_is_singleton(self):
        db = Database()
        db2 = Database()
        self.assertEqual(db, db2)

    def test_singleton_total_population(self):
        """ This tests on a live database :( """
        rf = SingletonRecordFinder()
        names = ['Seoul', 'Mexico City']
        tp = rf.total_population(names)
        self.assertEqual(tp, 17500000 + 17400000)  # what if these change?

    ddb = DummyDatabase()

    def test_dependent_total_population(self):
        crf = ConfigurableRecordFinder(self.ddb)
        self.assertEqual(
            crf.total_population(['alpha', 'beta']),
            3
        )

if __name__ == '__main__':
    unittest.main()
```
- test_is_singleton: Verifies that only one instance of the Database class exists.
- test_singleton_total_population: Tests the total population calculation using the SingletonRecordFinder with live data.
- test_dependent_total_population: Tests the total population calculation using the ConfigurableRecordFinder with a dummy database.

These tests demonstrate the importance of decoupling code from singletons to allow for better testability.


# Adapter Design Pattern 

The Adapter Design Pattern allows objects with incompatible interfaces to work together. It acts as a bridge between two interfaces, adapting one interface to another that the client expects.

## Problem Statement
When building software systems, it is common to encounter situations where an existing class or component has an interface that does not match the interface required by a specific client. Modifying the existing class to meet the new interface could lead to breaking other parts of the system or complicating the code unnecessarily. In such cases, the Adapter Pattern provides a solution by creating a wrapper (adapter) around the existing class to adapt its interface to the expected one.

## Real-World Analogy
A travel adapter is a perfect analogy for the Adapter Pattern. Electrical devices have different plug types and voltage requirements based on the country they are designed for. Instead of modifying each device to fit into different outlets, a travel adapter converts the plug type to fit the outlet and allows the device to function properly.

Participants
- Target (Client Interface): The interface expected by the client.
- Adaptee: The existing interface that needs to be adapted.
- Adapter: The class that implements the Target interface and adapts the Adaptee to the Target.

## Example Implementation
Consider a scenario where you are given a legacy API that includes a Point class and a draw_point function for drawing points. However, you are working with a system where graphical objects are represented by lines and rectangles.

Given API
```python
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def draw_point(p):
    print('.', end='')
```

Working Classes
```python
class Line:
    def __init__(self, start, end):
        self.start = start
        self.end = end

class Rectangle(list):
    def __init__(self, x, y, width, height):
        super().__init__()
        self.append(Line(Point(x, y), Point(x + width, y)))
        self.append(Line(Point(x + width, y), Point(x + width, y + height)))
        self.append(Line(Point(x, y), Point(x, y + height)))
        self.append(Line(Point(x, y + height), Point(x + width, y + height)))
```
**Adapter Implementation**
The `LineToPointAdapter` adapts the Line class to be compatible with the draw_point function by converting the line into a series of points.

```py
class LineToPointAdapter(list):
    count = 0

    def __init__(self, line):
        self.count += 1
        print(f'{self.count}: Generating points for line '
              f'[{line.start.x},{line.start.y}]→'
              f'[{line.end.x},{line.end.y}]')

        left = min(line.start.x, line.end.x)
        right = max(line.start.x, line.end.x)
        top = min(line.start.y, line.end.y)
        bottom = max(line.start.y, line.end.y)

        if right - left == 0:
            for y in range(top, bottom + 1):
                self.append(Point(left, y))
        elif line.end.y - line.start.y == 0:
            for x in range(left, right + 1):
                self.append(Point(x, top))
```
Usage Example
The `draw` function can now work with rectangles by using the `LineToPointAdapter` to convert lines into points.

```py
def draw(rcs):
    print("\n\n--- Drawing some stuff ---\n")
    for rc in rcs:
        for line in rc:
            adapter = LineToPointAdapter(line)
            for p in adapter:
                draw_point(p)

if __name__ == '__main__':
    rs = [
        Rectangle(1, 1, 10, 10),
        Rectangle(3, 3, 6, 6)
    ]
    draw(rs)
    draw(rs)
```

The Adapter Pattern is a useful design pattern when you need to integrate classes with incompatible interfaces. It allows you to reuse existing code without modifying it, thereby promoting flexibility and reusability in software design.

## Implementing a Cache
A cache is a data structure that stores the results of expensive function calls and reuses those results when the same inputs occur again. By implementing a cache in the adapter, we can avoid regenerating temporary objects, improving the efficiency of the code.

Modifying the Adapter to Use a Cache: The LineToPointAdapter class is modified to include a cache, which is a dictionary that maps hash values of Line objects to their corresponding points. This way, if a Line has already been converted to points, the adapter can retrieve the points from the cache instead of regenerating them.

### Steps in the Cache Implementation:
**Calculate Hash Value**: The adapter first calculates a unique hash value for the Line object. This hash value is used as the key in the cache dictionary.

```python
self.h = hash(line)
```
**Check Cache**: Before generating points, the adapter checks if the points for the given line are already present in the cache.

```python
if self.h in self.cache:
    return
```
**Generate Points if Not Cached**: If the points are not in the cache, the adapter generates them and stores them in the cache.

```python
points = []
# (Point generation logic)
self.cache[self.h] = points
```
**Iterate Over Cached Points**: The __iter__ method is overridden to return an iterator over the cached points.

```python
def __iter__(self):
    return iter(self.cache[self.h])
```

By incorporating caching into the adapter, we can significantly reduce the number of temporary objects generated, thereby improving the performance and efficiency of the system. This approach is especially beneficial when the adapter is repeatedly invoked with the same data.

# Bridge Design Pattern 

The Bridge design pattern is used to decouple an abstraction from its implementation, allowing both to vary independently. This pattern is particularly useful when dealing with a potential "Cartesian product complexity explosion," which occurs when multiple abstractions and implementations multiply the number of classes needed.

## Code Structure
- **Renderer Interface**: 
  - **Renderer**: An abstract base class that defines the method render_circle(radius). This method serves as the interface for rendering shapes.
- Concrete Implementations of Renderer:
  - **VectorRenderer**: A concrete implementation of Renderer. It provides a specific implementation for rendering circles in a vector form.
  - **RasterRenderer**: Another concrete implementation of Renderer. It renders circles in a raster (pixel-based) form.
- **Shape Base Class**:
  - **Shape**: An abstract base class that requires a Renderer to be passed during initialization. This class defines the methods draw() and resize(factor), which are intended to be overridden by derived classes.
- **Concrete Shape Implementation**:
  - **Circle**: A concrete implementation of the Shape class. It includes a radius attribute and provides specific implementations for the draw() and resize(factor) methods.
    - `draw()`: Uses the associated Renderer to render the circle based on its radius.
    - `resize(factor)`: Resizes the circle by multiplying its radius by the given factor.
- **Main Execution**: The script demonstrates the usage of the Bridge pattern by creating instances of VectorRenderer and RasterRenderer, and then using these renderers to draw and resize a Circle.

## Code Example
```python
class Renderer:
    def render_circle(self, radius):
        pass

class VectorRenderer(Renderer):
    def render_circle(self, radius):
        print(f'Drawing a circle of radius {radius}')

class RasterRenderer(Renderer):
    def render_circle(self, radius):
        print(f'Drawing pixels for circle of radius {radius}')

class Shape:
    def __init__(self, renderer):
        self.renderer = renderer

    def draw(self): 
        pass

    def resize(self, factor): 
        pass

class Circle(Shape):
    def __init__(self, renderer, radius):
        super().__init__(renderer)
        self.radius = radius

    def draw(self):
        self.renderer.render_circle(self.radius)

    def resize(self, factor):
        self.radius *= factor

if __name__ == '__main__':
    raster = RasterRenderer()
    vector = VectorRenderer()
    circle = Circle(vector, 5)
    circle.draw()
    circle.resize(2)
    circle.draw()
```
## Usage
- **Renderers**: The VectorRenderer and RasterRenderer provide different ways to render the Circle.
- **Shapes**: The Circle class can be extended or modified without altering the renderer classes, showcasing the flexibility provided by the Bridge pattern.
## Advantages
- **Decoupling**: The Bridge pattern decouples abstraction (Shape) from implementation (Renderer), enabling both to evolve independently.
- **Reduced Complexity**: By separating concerns, the pattern avoids a complexity explosion that could result from combining multiple abstractions and implementations.
## Limitations
- **Open/Closed Principle**: The pattern requires modifications to existing classes (e.g., adding new methods to Renderer and its subclasses) when new shapes or renderers are introduced, which might violate the open/closed principle.


# Composite Design Pattern 

The Composite Design Pattern is a structural design pattern that allows you to treat individual objects and compositions of objects uniformly. This pattern provides a way to group objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly, thereby simplifying the client code.

## Motivation
In software development, there are scenarios where you need to work with both individual objects and collections of objects. For example, in a graphics application, you might have simple shapes like circles and squares, but you might also want to group these shapes together to form complex structures.

The Composite Design Pattern enables you to treat both individual objects (e.g., a circle or a square) and groups of objects (e.g., a group of shapes) uniformly. This pattern allows you to define a common interface for all objects in the composition, so clients can interact with both individual components and composites through the same interface.

## Implementation
### Base Class
The base class, GraphicObject, serves as the foundation for both individual components (e.g., Circle and Square) and composite objects (e.g., a group of shapes). It contains a list of children that represent the group of objects and a color property.
```py
class GraphicObject:
    def __init__(self, color=None):
        self.color = color
        self.children = []
        self._name = 'Group'

    @property
    def name(self):
        return self._name

    def _print(self, items, depth):
        items.append('*' * depth)
        if self.color:
            items.append(self.color)
        items.append(f'{self.name}\n')
        for child in self.children:
            child._print(items, depth + 1)

    def __str__(self):
        items = []
        self._print(items, 0)
        return ''.join(items)
```

### Concrete Classes

Concrete classes like Circle and Square inherit from GraphicObject and override the name property to return their specific type. These classes can be treated as both individual objects and as part of a composite object.

```py
class Circle(GraphicObject):
    @property
    def name(self):
        return 'Circle'

class Square(GraphicObject):
    @property
    def name(self):
        return 'Square'
```

### Example Usage
Below is an example of how you can use the Composite Design Pattern to create and manipulate both individual shapes and groups of shapes.

```py
if __name__ == '__main__':
    drawing = GraphicObject()
    drawing._name = 'My Drawing'
    drawing.children.append(Square('Red'))
    drawing.children.append(Circle('Yellow'))

    group = GraphicObject()  # no name
    group.children.append(Circle('Blue'))
    group.children.append(Square('Blue'))
    drawing.children.append(group)

    print(drawing)
```

### Output
The output of the above code will display a hierarchy of the shapes and groups within the drawing:

```sh
*My Drawing
**Red
**Square
**Yellow
**Circle
**Group
***Blue
***Circle
***Blue
***Square
```

## Neural Network Example
This documentation describes an implementation of the Composite Design Pattern in the context of modeling a neural network. The pattern is used to treat individual neurons and layers of neurons uniformly, allowing them to be connected seamlessly. This approach simplifies the handling of connections within a neural network by making scalar elements behave like collections.

### Key Components

1. Connectable Class
- Purpose: Provides a base class that allows any derived class to connect to other instances of Connectable. Implements the Iterable interface, enabling the uniform treatment of single elements and collections.
- Methods:
  - connect_to(self, other): Connects the current instance (self) to another Connectable instance (other). Iterates over elements of self and other, creating two-way connections between them.
  - __iter__(self): Defines iteration over instances, yielding self in the case of scalar objects.
2. Neuron Class
- Purpose: Represents a single neuron within a neural network. Inherits from Connectable to enable connections with other neurons or layers of neurons.
- Attributes:
  - name: The name of the neuron.
  - inputs: A list of neurons connected as inputs to this neuron.
  - outputs: A list of neurons connected as outputs from this neuron.
- Methods:
  - __init__(self, name): Initializes a neuron with a name, and empty input/output lists.
  - __str__(self): Returns a string representation of the neuron, including its name, the number of inputs, and the number of outputs.
3. NeuronLayer Class
- Purpose: Represents a layer of neurons. Inherits from both list and Connectable, allowing it to behave like a list of neurons while also supporting connections.
- Attributes:
  - name: The name of the neuron layer.
- Methods:
  - __init__(self, name, count): Initializes a neuron layer with a specified number of neurons. Each neuron in the layer is named according to the layer's name and its index.
  - __str__(self): Returns a string representation of the neuron layer, including its name and the number of neurons it contains.

### Example Usage
#### Connecting Neurons and Layers
The following code demonstrates how to create neurons and layers, and connect them using the connect_to method:

```py
if __name__ == '__main__':
    neuron1 = Neuron('n1')
    neuron2 = Neuron('n2')
    layer1 = NeuronLayer('L1', 3)
    layer2 = NeuronLayer('L2', 4)

    neuron1.connect_to(neuron2)
    neuron1.connect_to(layer1)
    layer1.connect_to(neuron2)
    layer1.connect_to(layer2)

    print(neuron1)
    print(neuron2)
    print(layer1)
    print(layer2)
```

#### Output
This example produces the following output:

```sh
n1, 0 inputs, 4 outputs
n2, 4 inputs, 0 outputs
L1 with 3 neurons
L2 with 4 neurons
```

#### Explanation
- Neuron 1 (n1) is connected to Neuron 2 (n2) and Layer 1 (L1). This results in n1 having 4 outputs (3 to L1 and 1 to n2), while n2 has 4 inputs (3 from L1 and 1 from n1).
- Layer 1 (L1) is connected to Layer 2 (L2), creating connections between all neurons in L1 and L2.
- The connect_to method in Connectable enables this flexibility, allowing neurons and layers to be interconnected regardless of their types.


# Decorator Pattern

The Decorator Pattern is a structural design pattern used to add additional behaviors or responsibilities to objects dynamically. Unlike subclassing, where additional functionality is achieved through inheritance, the decorator pattern allows the augmentation of an object’s behavior without modifying its structure or the need for inheritance. This promotes adherence to the Open/Closed Principle and Single Responsibility Principle in software design.

## Motivation
The main motivation for using the decorator pattern is to add features or functionality to existing objects in a flexible and reusable way. Instead of altering the original object or creating numerous subclasses for every possible combination of features, decorators allow you to "wrap" an object with new functionality dynamically.

## Implementation
General Approach
- Inheritance: One way to augment a class is by inheriting from it and adding new features. However, this approach can become cumbersome if multiple combinations of features are needed, leading to an explosion of subclasses.
- Decorators: A more flexible approach is to use decorators, which are objects that wrap the original object and add new behaviors to it. Decorators can be stacked, allowing for dynamic and combinatorial behavior modification.

### Python-Specific Implementation
In Python, the decorator pattern can be implemented using higher-order functions, where a function wraps another function to extend its behavior. Python also provides special syntax for applying decorators to functions, using the @decorator_name syntax.

```python
import time

def time_it(func):
    def wrapper():
        start = time.time()  # Measure start time
        result = func()  # Call the original function
        end = time.time()  # Measure end time
        print(f'{func.__name__} took {int((end-start)*1000)}ms')  # Print execution time
        return result
    return wrapper

@time_it  # Applying the time_it decorator
def some_op():
    print('Starting op')
    time.sleep(1)  # Simulate a time-consuming operation
    print('We are done')
    return 123

if __name__ == '__main__':
    some_op()
```
#### Explanation
**Decorator Function (time_it)**:
- Purpose: Measures the execution time of the function it decorates.
- How It Works:
  - It defines an inner function (wrapper) that wraps the original function.
  - The wrapper function records the start time, executes the original function, records the end time, and then prints the time taken to execute the function.
  - Finally, it returns the result of the original function.

**Decorated Function (some_op)**:

- A simple function that simulates a time-consuming operation using time.sleep(1).
- The @time_it decorator is applied to this function, meaning that every time some_op is called, it will be wrapped in the timing logic defined in time_it.

**Execution**:
- When some_op is called, the execution time is measured and printed due to the decorator, illustrating how the decorator pattern can be used to augment behavior without modifying the original function.

### Key Points
- Flexible Augmentation: Decorators allow the addition of functionality in a flexible manner without altering the original object or function.
- Reusability: Decorators can be reused across different functions or objects, promoting code reusability.
- Adherence to Design Principles: The decorator pattern supports the Open/Closed Principle by allowing the extension of an object's behavior without modifying its code.

## Classic Implementation of Decorator Pattern in Object-Oriented Programming

The Decorator Pattern is a structural design pattern used to dynamically add behavior to individual objects without affecting the behavior of other objects from the same class. This is achieved by creating decorator classes that wrap the original class, augmenting its functionality. This approach adheres to the Open/Closed Principle by allowing functionality to be extended without modifying existing code.

### Motivation
In object-oriented programming, there often arises a need to extend the functionality of a class without modifying its code. Traditional inheritance can lead to an explosion of subclasses for every combination of features, making the system complex and hard to maintain. The decorator pattern offers a more flexible and reusable solution by allowing the dynamic composition of behaviors.

### Implementation
**Core Components**
Abstract Base Class (Shape):
- The abstract base class provides a common interface for all shapes, ensuring that concrete classes and decorators can be treated uniformly.
Concrete Classes (Circle, Square):
- These classes represent the basic shapes. They implement the core functionality, such as resizing or defining specific properties like radius or side length.
Decorator Classes (ColoredShape, TransparentShape):
- These classes are decorators that add additional functionality, such as color or transparency, to the basic shapes. They wrap a shape object and extend its behavior.
```python
from abc import ABC

class Shape(ABC):
    def __str__(self):
        return ''

class Circle(Shape):
    def __init__(self, radius=0.0):
        self.radius = radius

    def resize(self, factor):
        self.radius *= factor

    def __str__(self):
        return f'A circle of radius {self.radius}'

class Square(Shape):
    def __init__(self, side):
        self.side = side

    def __str__(self):
        return f'A square with side {self.side}'

class ColoredShape(Shape):
    def __init__(self, shape, color):
        if isinstance(shape, ColoredShape):
            raise Exception('Cannot apply ColoredDecorator twice')
        self.shape = shape
        self.color = color

    def __str__(self):
        return f'{self.shape} has the color {self.color}'

class TransparentShape(Shape):
    def __init__(self, shape, transparency):
        self.shape = shape
        self.transparency = transparency

    def __str__(self):
        return f'{self.shape} has {self.transparency * 100.0}% transparency'

if __name__ == '__main__':
    circle = Circle(2)
    print(circle)

    red_circle = ColoredShape(circle, "red")
    print(red_circle)

    red_half_transparent_square = TransparentShape(red_circle, 0.5)
    print(red_half_transparent_square)

    # Example of double decoration
    mixed = ColoredShape(ColoredShape(Circle(3), 'red'), 'blue')
    print(mixed)
```
### Explanation
**Abstract Base Class (Shape)**:

- Provides a base class for all shapes, enforcing a uniform interface. In this case, it only defines a __str__ method, which is overridden by concrete shapes and decorators.
**Concrete Shapes (Circle, Square)**:

These classes inherit from Shape and provide specific implementations for geometric shapes.
- Circle: Implements radius-related functionality and includes a resize method.
- Square: Represents a square and stores the length of its side.
**Decorator Classes (ColoredShape, TransparentShape)**:

- ColoredShape: Adds color to a shape. It checks if the shape has already been colored to prevent applying the same decorator twice.
- TransparentShape: Adds transparency to a shape and converts the transparency value into a percentage for display.

**Combining Decorators**:

Decorators can be stacked, allowing for multiple extensions of the original shape's functionality. For example, a circle can be both colored and transparent.
The code demonstrates how to combine these decorators to create complex shapes with multiple features.


### Key Points
- Dynamic Behavior Extension: The decorator pattern allows you to dynamically add functionality to objects at runtime, promoting flexibility and reusability.
- Adherence to Design Principles: The pattern adheres to the Open/Closed Principle by allowing objects to be extended without modifying their code.
- Preventing Redundant Decoration: The implementation includes checks to prevent the same decorator from being applied multiple times, avoiding redundant or conflicting behaviors.

### Limitations
- Access to Original Methods: Decorators do not automatically provide access to the original object's methods unless explicitly programmed. For example, the resize method of Circle is not accessible once the shape is decorated.
- Complexity: When multiple decorators are stacked, it can become difficult to manage the interactions between them, particularly if they modify the same aspect of the object.


## File Decorator Implementation with Logging
This documentation outlines the implementation of a class decorator that wraps around a file object, allowing additional functionality such as logging while maintaining access to the file’s original methods. The approach leverages dynamic programming to proxy all operations from the decorator to the underlying file, minimizing the need to manually override each file method.

### Class: FileWithLogging
The FileWithLogging class is a decorator for file objects, allowing additional operations (like logging) to be performed whenever certain methods (e.g., writelines) are called on the file. It also ensures that all other file operations behave as if they were directly performed on the original file.

```python
class FileWithLogging:
  def __init__(self, file):
    self.file = file

  def writelines(self, strings):
    self.file.writelines(strings)
    print(f'wrote {len(strings)} lines')

  def __iter__(self):
    return self.file.__iter__()

  def __next__(self):
    return self.file.__next__()

  def __getattr__(self, item):
    return getattr(self.__dict__['file'], item)

  def __setattr__(self, key, value):
    if key == 'file':
      self.__dict__[key] = value
    else:
      setattr(self.__dict__['file'], key)

  def __delattr__(self, item):
    delattr(self.__dict__['file'], item)
```

**Constructor: __init__(self, file)**: Initialize the decorator with the file to be wrapped.
**Method: writelines(self, strings)**: Write multiple lines to the file and log how many lines were written.
**Method: __iter__(self)**: Allow the decorated file to be used in a loop, forwarding iteration to the original file.
**Method: __next__(self)**: Support fetching the next line in a loop, just like the original 
**Method: __getattr__(self, item)**: Forward all method and attribute calls to the original file, ensuring the decorator acts just like the file.
**Method: __setattr__(self, key, value)**: Set attributes either on the decorator or the original file, depending on the key.
**Method: __delattr__(self, item)**: Delete attributes from the original file.

### Example Usage:
```python
file = FileWithLogging(open('hello.txt', 'w'))
file.writelines(['hello', 'world'])  # Logs: wrote 2 lines
file.write('testing')
file.close()
```

The FileWithLogging class decorates a file to add logging and ensure it retains all original file behaviors. It demonstrates how to wrap an object and dynamically forward calls, making it an effective example of enhancing functionality without modifying the original class.


# Facade Design Pattern 

The Facade Design Pattern provides a simplified interface to a complex subsystem. It offers an easy-to-use API while hiding the complexities of underlying systems. In software systems, this allows clients to perform operations with minimal code, while still enabling power users to access lower-level functionality when needed.

In this example, a Console class is implemented as a facade to manage Buffer and Viewport components, which handle the complexity of text manipulation in a console-based system.

Components:
Buffer Class:

Purpose: Represents a low-level construct that holds characters in a 1D list (simulating a text buffer).
Attributes:
width: Width of the buffer (default: 30).
height: Height of the buffer (default: 20).
buffer: A list of characters initialized to blank spaces (' '), with a total size of width * height.
Methods:
__getitem__(item): Allows access to elements in the buffer using indexing.
write(text): Appends text to the buffer.
Code:

python
Copy code
class Buffer:
    def __init__(self, width=30, height=20):
        self.width = width
        self.height = height
        self.buffer = [' '] * (width * height)

    def __getitem__(self, item):
        return self.buffer.__getitem__(item)

    def write(self, text):
        self.buffer += text
Viewport Class:

Purpose: Acts as a view into a section of the buffer, allowing partial content to be displayed or manipulated.
Attributes:
buffer: Holds a reference to a Buffer object.
offset: Represents the starting point of the viewport within the buffer (default: 0).
Methods:
get_char_at(index): Retrieves a character from the buffer at a specified index, adjusted by the viewport's offset.
append(text): Appends text to the buffer.
Code:

python
Copy code
class Viewport:
    def __init__(self, buffer=Buffer()):
        self.buffer = buffer
        self.offset = 0

    def get_char_at(self, index):
        return self.buffer[self.offset + index]

    def append(self, text):
        self.buffer += text
Console Class (Facade):

Purpose: Provides a high-level interface for interacting with the system by internally managing a buffer and viewport. It also exposes some lower-level functionality for advanced users.
Attributes:
buffers: A list to manage multiple Buffer objects.
viewports: A list to manage multiple Viewport objects.
current_viewport: The active Viewport being used by the console.
Methods:
write(text): High-level method that writes text to the current buffer via the viewport.
get_char_at(index): Low-level method that allows the user to directly access characters in the buffer.
Code:

python
Copy code
class Console:
    def __init__(self):
        b = Buffer()
        self.current_viewport = Viewport(b)
        self.buffers = [b]
        self.viewports = [self.current_viewport]

    # High-level method
    def write(self, text):
        self.current_viewport.buffer.write(text)

    # Low-level method
    def get_char_at(self, index):
        return self.current_viewport.get_char_at(index)
Usage Example:

The console can be used for both high-level operations (e.g., writing to the buffer) and low-level operations (e.g., retrieving characters from the buffer).
Code:

python
Copy code
if __name__ == '__main__':
    c = Console()
    c.write('hello')  # High-level write
    ch = c.get_char_at(0)  # Low-level character access
    print(ch)  # Output: 'h'
Key Concepts:
High-Level API: Provides a simple interface for common tasks, such as writing to the console, without requiring knowledge of the underlying structure (write method in Console).
Low-Level API: Exposes detailed functionality for advanced users, allowing direct manipulation of buffer and viewport objects (get_char_at method in Console).
Buffer and Viewport: Handle the complexity of managing text and presenting it in specific areas of the console.
Multifunctional Facade: The Console class serves as both a simplified and powerful interface, providing flexibility for different user requirements.


# Flyweight Pattern 

This documentation explains the implementation of the Flyweight Design Pattern, a space optimization technique used to minimize memory consumption in scenarios where multiple objects share similar data. By externalizing and reusing common data, the Flyweight Pattern ensures that only a small number of objects are instantiated, reducing redundancy and optimizing resource usage.

Problem Statement
The goal is to prevent redundant memory usage when storing common or repetitive data across multiple objects. For example, in a massively multiplayer online game or a text editor, many users may have similar names, and it would be inefficient to store identical or similar strings repeatedly.

To address this, the Flyweight Pattern externalizes the common data and stores references to it, rather than storing the data directly in each object.

Example Scenario
Consider a system where 10,000 users are created, and each user has a first and last name. Without optimization, the system would store each full name as a unique string, resulting in significant memory overhead. Even though there are only 200 unique first and last names (100 first names and 100 last names), the traditional approach leads to the storage of 10,000 full names.

The Flyweight Pattern reduces memory usage by storing only 200 unique strings and referencing them via indices, rather than duplicating the full names for each user.

Implementation
The following implementation demonstrates the Flyweight Design Pattern using Python:

User Class (Inefficient Implementation):
This class stores the full name of each user as a single string.
Memory consumption increases with each new user, even if the first and last names are identical.
python
Copy code
class User:
    def __init__(self, name):
        self.name = name
User2 Class (Flyweight Implementation):
This class optimizes memory usage by storing first and last names externally in a static list (strings) and referencing them via indices.
When a user object is created, the first and last names are split, and their indices are stored instead of the actual strings.
The get_or_add function checks if the name is already stored. If it is, it returns the index; otherwise, it adds the name to the list and returns the new index.
The __str__ method reconstructs the full name by concatenating the indexed first and last names from the static list.
python
Copy code
class User2:
    strings = []

    def __init__(self, full_name):
        def get_or_add(s):
            if s in self.strings:
                return self.strings.index(s)
            else:
                self.strings.append(s)
                return len(self.strings)-1
        self.names = [get_or_add(x) for x in full_name.split(' ')]

    def __str__(self):
        return ' '.join([self.strings[x] for x in self.names])
Random Name Generation:
A function random_string is used to generate random first and last names of length 8, simulating user names for the purpose of the experiment.
python
Copy code
def random_string():
    chars = string.ascii_lowercase
    return ''.join([random.choice(chars) for x in range(8)])
Main Program:
The program creates 10,000 users using the inefficient User class and then optimizes memory usage by switching to the User2 class, which utilizes the Flyweight Pattern.
python
Copy code
if __name__ == '__main__':
    users = []

    first_names = [random_string() for x in range(100)]
    last_names = [random_string() for x in range(100)]

    for first in first_names:
        for last in last_names:
            users.append(User(f'{first} {last}'))

    u2 = User2('Jim Jones')
    u3 = User2('Frank Jones')
    print(u2.names)
    print(u3.names)
    print(User2.strings)

    users2 = []

    for first in first_names:
        for last in last_names:
            users2.append(User2(f'{first} {last}'))
Benefits of Flyweight Pattern
Memory Optimization: Instead of creating new strings for each user, the Flyweight Pattern reuses existing strings by referencing them via indices. This reduces memory consumption significantly.
Efficient Storage: Only 200 unique strings are stored, regardless of the number of users. The full names are reconstructed dynamically when needed, saving memory and reducing overhead.
Example Output
The code first prints the indices corresponding to the first and last names for two users: 'Jim Jones' and 'Frank Jones'.
It also prints the shared static list of unique strings (User2.strings), which stores the first and last names.
This approach demonstrates how the Flyweight Pattern effectively reduces redundant memory usage in scenarios with repetitive data.


Text Formatting Example
Overview
This document demonstrates the implementation of the Flyweight Design Pattern for text formatting, showcasing memory optimization in cases where only specific portions of text require formatting. The solution compares a naive approach to text formatting with a more efficient implementation using the Flyweight pattern.

Problem Statement
When formatting large amounts of text, such as capitalizing certain letters or words, allocating resources for each character in the text can become inefficient, especially when only a small subset of the text needs formatting.

For example, in a naive implementation, formatting operations (e.g., capitalizing letters) are applied using an array of boolean values to track whether each character in the text should be capitalized. This approach consumes unnecessary memory when formatting operations are sparse across large texts.

The Flyweight pattern offers an optimized solution by sharing the formatting information across text segments, reducing memory usage.

Naive Approach
FormattedText Class
Purpose: A simple approach to formatting text, where a boolean array tracks which characters need to be capitalized.
Initialization: Takes a string of plain text as input and creates an array of booleans (caps), initialized to False.
Capitalization: Uses the capitalize() method to update the boolean array for characters within the specified range.
String Representation: The __str__() method checks the boolean array when generating the final formatted string.
Code:

python
Copy code
class FormattedText:
    def __init__(self, plain_text):
        self.plain_text = plain_text
        self.caps = [False] * len(plain_text)

    def capitalize(self, start, end):
        for i in range(start, end):
            self.caps[i] = True

    def __str__(self):
        result = []
        for i in range(len(self.plain_text)):
            c = self.plain_text[i]
            result.append(c.upper() if self.caps[i] else c)
        return ''.join(result)
Example Usage:
python
Copy code
ft = FormattedText('This is a brave new world')
ft.capitalize(10, 15)
print(ft)
Output:

csharp
Copy code
This is a BRAVE new world
Optimized Approach with Flyweight Pattern
BetterFormattedText Class
Purpose: Optimizes memory usage by applying formatting only to the specified ranges of text, using the Flyweight pattern.
TextRange (Flyweight Class): Defines a range of text positions and tracks whether characters in the range should be capitalized, bold, italicized, etc.
Flyweight Management: The get_range() method creates and returns TextRange objects that define formatting operations on specific segments of the text, which are then stored in a formatting list.
String Representation: The __str__() method processes each character and checks if it falls within a TextRange that requires formatting.
Code:

python
Copy code
class BetterFormattedText:
    def __init__(self, plain_text):
        self.plain_text = plain_text
        self.formatting = []

    class TextRange:
        def __init__(self, start, end, capitalize=False, bold=False, italic=False):
            self.start = start
            self.end = end
            self.capitalize = capitalize

        def covers(self, position):
            return self.start <= position <= self.end

    def get_range(self, start, end):
        range = self.TextRange(start, end)
        self.formatting.append(range)
        return range

    def __str__(self):
        result = []
        for i in range(len(self.plain_text)):
            c = self.plain_text[i]
            for r in self.formatting:
                if r.covers(i) and r.capitalize:
                    c = c.upper()
            result.append(c)
        return ''.join(result)
Example Usage:
python
Copy code
bft = BetterFormattedText('This is a brave new world')
bft.get_range(16, 19).capitalize = True
print(bft)
Output:

vbnet
Copy code
This is a brave NEW world
Key Differences
Memory Usage: The naive approach (FormattedText) allocates a boolean array with the same length as the text, which can be inefficient for large texts with sparse formatting. The optimized approach (BetterFormattedText) only stores formatting data for specific ranges, reducing memory consumption.
Flyweight Design: By utilizing TextRange objects, the Flyweight pattern ensures that formatting information is shared across text segments and not unnecessarily duplicated.


# Proxy Design Pattern
Overview
The Proxy Design Pattern is a structural design pattern that provides an interface to another object while controlling access to it. Proxies can serve various purposes, such as controlling access, managing resource allocation, or adding additional functionality to an object without altering its interface.

Types of Proxies
Communication Proxy: Facilitates communication between objects that may be in different processes or environments, abstracting the complexities involved in remote method invocations.

Logging Proxy: Adds logging capabilities to track method calls and interactions with the underlying object.

Virtual Proxy: Delays the initialization of an object until it's actually needed, thereby saving resources and improving performance.

Protection Proxy: Controls access to the object based on certain criteria or conditions, often used for security and access control.

Examples
1. Protection Proxy
Scenario: A Car class with a method drive should only allow drivers above a certain age to drive.

Implementation:

Car: Represents the real object with a method drive.
CarProxy: Acts as a proxy to the Car class, adding access control to the drive method based on the driver's age.
Code:

python
Copy code
class Car:
    def __init__(self, driver):
        self.driver = driver

    def drive(self):
        print(f'Car being driven by {self.driver.name}')

class CarProxy:
    def __init__(self, driver):
        self.driver = driver
        self.car = Car(driver)

    def drive(self):
        if self.driver.age >= 16:
            self.car.drive()
        else:
            print('Driver too young')

class Driver:
    def __init__(self, name, age):
        self.name = name
        self.age = age

if __name__ == '__main__':
    car = CarProxy(Driver('John', 12))
    car.drive()
Explanation: The CarProxy class restricts access to the Car's drive method based on the driver's age, ensuring that only eligible drivers can operate the car.

2. Virtual Proxy
Scenario: A Bitmap class that loads an image from a file but should delay this loading until the image is actually needed.

Implementation:

Bitmap: Represents the real object that performs expensive operations like loading an image from disk.
LazyBitmap: A proxy that defers the creation of a Bitmap object until its draw method is called.
Code:

python
Copy code
class Bitmap:
    def __init__(self, filename):
        self.filename = filename
        print(f'Loading image from {filename}')

    def draw(self):
        print(f'Drawing image {self.filename}')

class LazyBitmap:
    def __init__(self, filename):
        self.filename = filename
        self.bitmap = None

    def draw(self):
        if not self.bitmap:
            self.bitmap = Bitmap(self.filename)
        self.bitmap.draw()

def draw_image(image):
    print('About to draw image')
    image.draw()
    print('Done drawing image')

if __name__ == '__main__':
    bmp = LazyBitmap('facepalm.jpg')
    draw_image(bmp)
Explanation: The LazyBitmap class only initializes the Bitmap object when it is needed (i.e., when draw is called), avoiding the overhead of loading the image until it is actually used.


## Proxy vs Decorator Design Patterns
Both the Proxy and Decorator Design Patterns are structural patterns that can appear similar but serve different purposes and exhibit distinct behaviors. 

### Summary of Differences
- **Interface Handling**: A proxy provides the same interface as the object it proxies, while a decorator may provide an enhanced or extended interface.
- **Object Handling**: A proxy can manage objects that are not yet constructed, implementing lazy initialization. A decorator, on the other hand, works with an already constructed object and adds new behavior.
- **Functionality**: The proxy's primary role is to control access or manage resource usage, whereas the decorator focuses on adding new functionalities or operations.

In essence, while both patterns involve wrapping or acting as intermediaries for objects, the Proxy Pattern is more about controlling access or managing resource use, and the Decorator Pattern is about dynamically extending an object's capabilities.

# Citations

The following notes is curated from 
- ChatGPT
- Udemy: Design Patterns in Python - Dmitri Nesteruk
- Udemy: Design Patterns in Java - Dmitri Nesteruk
- Udemy: SOLID Principles: Introducing Software Architecture & Design by George S