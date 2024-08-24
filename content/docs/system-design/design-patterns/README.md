+++
title= "Design Patterns"
tags = [ "system-design", "software-architecture", "patterns" ]
author = "Me"
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