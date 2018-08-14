

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SortArrayListUsingComparator {

	public static void main(String[] args) {
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(10,25,"Jagannath",25000.00));
		al.add(new Student(5,25,"Jagannath",24000.00));
		al.add(new Student(20,25,"Jagannath",18000.00));
		al.add(new Student(15,25,"Jagannath",12000.00));
		al.add(new Student(48,25,"Jagannath",11000.50));
		al.add(new Student(85,25,"Jagannath",11000.75));
		
		Collections.sort(al, new SortById());
		
		System.out.println(al);
	}
}

class Student {
	
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

}

class SortById implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		return s1.id-s2.id;
	}

}