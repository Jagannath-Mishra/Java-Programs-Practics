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