# How to Sort an ArrayList Objects Using Comparable ?

Code Here: 
```
public class SortArrayListUsingComparable {

	public static void main(String[] args) {
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(10,25,"Jagannath",25000.00));
		al.add(new Student(5,25,"Jagannath",24000.00));
		al.add(new Student(20,25,"Jagannath",18000.00));
		al.add(new Student(15,25,"Jagannath",12000.00));
		al.add(new Student(48,25,"Jagannath",11000.50));
		al.add(new Student(85,25,"Jagannath",11000.75));
		
		Collections.sort(al);
		
		System.out.println(al);
	}
}

class Student implements Comparable{
	Integer id;
	Integer age;
	String Name;
	Double salary;

	
	
	
	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", age=" + age + ", Name=" + Name + ", salary=" + salary + "]";
	}



	public Student(Integer id, Integer age, String name, double d) {
		super();
		this.id = id;
		this.age = age;
		Name = name;
		this.salary = d;
	
	}

	


	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.salary.compareTo(s.salary);
	}
}
```
