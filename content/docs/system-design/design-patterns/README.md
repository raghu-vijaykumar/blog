+++
title= "Design Patterns"
tags = [ "system-design", "software-architecture", "patterns" ]
author = "Me"
date = 2024-08-26T00:01:00+05:30
showToc = true
TocOpen = false
draft = true
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