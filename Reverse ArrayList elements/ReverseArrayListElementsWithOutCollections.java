import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayListElementsWithOutCollections {

	public static void main(String[] args) {
		
		  ArrayList<String> arrayList= new ArrayList<>();
		  arrayList.add("Apple");
		  arrayList.add("Banana");
		  arrayList.add("Orange");
		  
		  System.out.println("Before Reversing elements:"+arrayList);
		  Collections.reverse(arrayList);
		  
		  System.out.println("Aftere Reversing elements:"+arrayList);
				  
	}
}
