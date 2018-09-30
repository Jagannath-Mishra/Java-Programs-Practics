
#  Object Cloning Shallow Copy and Deep Copy


```
public class ObjectCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		ABC obj1 = new ABC();
		
		obj1.a = 20;
		obj1.b = 30;
		
		System.out.println(obj1);
		
		//Sallow Copy
		ABC obj2 = new ABC();
		
		obj2 =  obj1;
		
		System.out.println(obj2);
		
		obj2.a = 50;
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		//Deep Copy
		
		ABC obj3 =  new ABC();
		
		obj3.a =  obj1.a;
		obj3.b = obj1.b;
		
		obj3.b = 100;
		
		System.out.println(obj1);
		System.out.println(obj3);
		
		//Object Cloning
		
		ABC obj4 = (ABC) obj1.clone();
		
		obj4.a = 200;
		
		System.out.println(obj1);
		System.out.println(obj4);
		
	}
}

class ABC implements Cloneable{
	
	int a;
 	int b;
 	
	@Override
	public String toString() {
		return "ABC [a=" + a + ", b=" + b + "]";
	}
 	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
 	
}
```