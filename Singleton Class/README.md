# How to Create Singleton Class in Java ?

In object-oriented programming, a singleton class is a class that can have only one object (an instance of the class) at a time.

## To design a singleton class:

1. Make a private and static object of class type and then assign a null value to it.
2. Make constructor as private.
3. Write a static method that has return type object of this singleton class. 
   Here, the concept of Lazy initialization in used to write this static method.

### Normal class vs Singleton class:

 Difference in normal and singleton class in terms of instantiation is that, For normal class we use constructor, whereas for singleton class we use getInstance() method (Example code:I). In general, to avoid confusion we may also use the class name as method name while defining this method (Example code:II).


### Implementing Singleton class with getInstance() method

```


// Java program implementing Singleton class
// with getInstance() method
class Singleton
{
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;
 
    // variable of type String
    public String s;
 
    // private constructor restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }
 
    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
 
        return single_instance;
    }
}
 
// Driver Class
class Main
{
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
 
        // instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
 
        // instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
 
        // changing variable of instance x
        x.s = (x.s).toUpperCase();
 
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
 
        // changing variable of instance z
        z.s = (z.s).toLowerCase();
 
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}

```


## Why you need Double checked Locking of Singleton Class?
One of the common scenario, where a Singleton class breaks its contracts is multi-threading. If you ask a beginner to write code for Singleton design pattern, there is good chance that he will come up with something like below :
```
private static Singleton _instance;

public static Singleton getInstance() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
}
```
and when you point out that this code will create multiple instances of Singleton class if called by more than one thread parallel, he would probably make this whole getInstance() method synchronized, as shown in our 2nd code example getInstanceTS() method.


Though it’s a thread-safe and solves issue of multiple instance, it's not very efficient. You need to bear cost of synchronization all the time you call this method, while synchronization is only needed on first class, when Singleton instance is created.

This will bring us to double checked locking pattern, where only critical section of code is locked. Programmer call it double checked locking because there are two checks for _instance == null, one without locking and other with locking (inside synchronized) block.

Here is how double checked locking looks like in Java :
```
public static Singleton getInstanceDC() {
        if (_instance == null) {                // Single Checked
            synchronized (Singleton.class) {
                if (_instance == null) {        // Double checked
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
}
```
On surface this method looks perfect, as you only need to pay price for synchronized block one time, but it still broken, until you make _instance variable volatile.

Without volatile modifier it's possible for another thread in Java to see half initialized state of _instance variable, but with volatile variable guaranteeing happens-before relationship, all the write will happen on volatile _instance before any read of _instance variable.

This was not the case prior to Java 5, and that's why double checked locking was broken before. Now, with happens-before guarantee, you can safely assume that this will work.

By the way this is not the best way to create thread-safe Singleton, you can use Enum as Singleton, which provides inbuilt thread-safety during instance creation. Another way is to use static holder pattern.
Double Checked Locking on Singleton in Java

/*
 * A journey to write double checked locking of Singleton class in Java.
 */
```
class Singleton {

    private volatile static Singleton _instance;

    private Singleton() {
        // preventing Singleton object instantiation from outside
    }

    /*
     * 1st version: creates multiple instance if two thread access
     * this method simultaneously
     */

    public static Singleton getInstance() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }

    /*
     * 2nd version : this definitely thread-safe and only
     * creates one instance of Singleton on concurrent environment
     * but unnecessarily expensive due to cost of synchronization
     * at every call.
     */

    public static synchronized Singleton getInstanceTS() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }
 
    /*
     * 3rd version : An implementation of double checked locking of Singleton.
     * Intention is to minimize cost of synchronization and  improve performance,
     * by only locking critical section of code, the code which creates
 instance of Singleton class.
     * By the way this is still broken, if we don't make _instance volatile,
 as another thread can
     * see a half initialized instance of Singleton.
     */

    public static Singleton getInstanceDC() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }
}
```
That's all about double checked locking of Singleton class in Java. This is one of the controversial way to create thread-safe Singleton in Java, with simpler alternatives available in terms of using Enum as Singleton class. I don't suggest you to implement your Singleton like that as there are many better way to implement Singleton pattern in Java. Though, this question has historical significance and also teaches how concurrency can introduce subtle bugs. As I said before, this is very important from interview point of view. Practice writing double checked locking of Singleton class by hand before going for any Java interview. This will develop your insight on coding mistakes made by Java programmers. On related note, In modern day of Test driven development, Singleton is regarded as anti pattern because of difficulty it present to mock its behaviour, so if you are TDD practitioner better avoid using Singleton pattern
