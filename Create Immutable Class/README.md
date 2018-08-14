# How to Create immutable Class in java?

Immutable class is good for caching purpose because you don’t need to worry about the value changes. Other benefit of immutable class is that it is inherently thread-safe, so you don’t need to worry about thread safety in case of multi-threaded environment.

### To create immutable class in java, you have to do following steps.

1. Declare the class as final so it can’t be extended.
2. Make all fields private so that direct access is not allowed.
3. Don’t provide setter methods for variables
4. Make all mutable fields final so that it’s value can be assigned only once.
5. Initialize all the fields via a constructor performing deep copy.
6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
