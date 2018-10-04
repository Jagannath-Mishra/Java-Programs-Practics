# Serialization and Deserialization in Java with Example


Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

The byte stream created is platform independent. So, the object serialized on one platform can be deserialized on a different platform.

To make a Java object serializable we implement the java.io.Serializable interface.
The ObjectOutputStream class contains writeObject() method for serializing an Object.
```
public final void writeObject(Object obj)
                       throws IOException
					   
```
The ObjectInputStream class contains readObject() method for deserializing an object.

```
public final Object readObject()
                  throws IOException,
               ClassNotFoundException
			   
```

## Advantages of Serialization
- To save/persist state of an object.
- To travel an object across a network.
- Only the objects of those classes can be serialized which are implementing java.io.Serializable interface.


Serializable is a marker interface (has no data member and method). It is used to “mark” java classes so that objects of these classes may get certain capability. Other examples of marker interfaces are:- Cloneable and Remote.

## Points to remember

- Instance Variables: These variables are serialized, so during deserialization we will get back the serialized state.

- Static Variables: These variables are not serialized, So during deserialization static variable value will loaded from the class.(Current value will be loaded.)

- transient Variables: transient variables are not serialized, so during deserialization those variables will be initialized with corresponding default values (ex: for objects null, int 0).

- Super class variables: If super class also implemented Serializable interface then those variables will be serialized, otherwise it won't serialize the super class variables. and while deserializing, JVM will run default constructor in super class and populates the default values. Same thing will happen for all superclasses.


- If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
- Only non-static data members are saved via Serialization process.
- Static data members and transient data members are not saved via Serialization process.So, if you don’t want to save value of a non-static data member then make it transient.
- Constructor of object is never called when an object is deserialized.
- Associated objects must be implementing Serializable interface.


## Example 1:

```
// Java code for serialization and deserialization  
// of a Java object 
import java.io.*; 
  
class Demo implements java.io.Serializable 
{ 
    public int a; 
    public String b; 
  
    // Default constructor 
    public Demo(int a, String b) 
    { 
        this.a = a; 
        this.b = b; 
    } 
  
} 
  
class Test 
{ 
    public static void main(String[] args) 
    {    
        Demo object = new Demo(1, "geeksforgeeks"); 
        String filename = "file.ser"; 
          
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(object); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
  
  
        Demo object1 = null; 
  
        // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            object1 = (Demo)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println("a = " + object1.a); 
            System.out.println("b = " + object1.b); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
  
    } 
} 
```		   




## Example 2:
```
// Java code for serialization and deserialization  
// of a Java object 
import java.io.*; 
  
class Emp implements Serializable { 
private static final long serialversionUID = 
                                 129348938L; 
    transient int a; 
    static int b; 
    String name; 
    int age; 
  
    // Default constructor 
public Emp(String name, int age, int a, int b) 
    { 
        this.name = name; 
        this.age = age; 
        this.a = a; 
        this.b = b; 
    } 
  
} 
  
public class SerialExample { 
public static void printdata(Emp object1) 
    { 
  
        System.out.println("name = " + object1.name); 
        System.out.println("age = " + object1.age); 
        System.out.println("a = " + object1.a); 
        System.out.println("b = " + object1.b); 
    } 
  
public static void main(String[] args) 
    { 
        Emp object = new Emp("ab", 20, 2, 1000); 
        String filename = "shubham.txt"; 
  
        // Serialization 
        try { 
  
            // Saving of object in a file 
            FileOutputStream file = new FileOutputStream 
                                           (filename); 
            ObjectOutputStream out = new ObjectOutputStream 
                                           (file); 
  
            // Method for serialization of object 
            out.writeObject(object); 
  
            out.close(); 
            file.close(); 
  
            System.out.println("Object has been serialized\n"
                              + "Data before Deserialization."); 
            printdata(object); 
  
            // value of static variable changed 
            object.b = 2000; 
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
  
        object = null; 
  
        // Deserialization 
        try { 
  
            // Reading the object from a file 
            FileInputStream file = new FileInputStream 
                                         (filename); 
            ObjectInputStream in = new ObjectInputStream 
                                         (file); 
  
            // Method for deserialization of object 
            object = (Emp)in.readObject(); 
  
            in.close(); 
            file.close(); 
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization."); 
            printdata(object); 
  
            // System.out.println("z = " + object1.z); 
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
  
        catch (ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException" + 
                                " is caught"); 
        } 
    } 
} 

```
