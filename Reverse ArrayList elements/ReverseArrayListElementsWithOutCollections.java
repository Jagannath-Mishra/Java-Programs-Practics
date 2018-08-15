import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayListElementsWithOutCollections {


	
	public static void main(String[] args) {
		
		  ArrayList<String> arrayList= new ArrayList<>();
		  arrayList.add("Apple");
		  arrayList.add("Banana");
		  arrayList.add("Orange");
		  
		  System.out.println("Before Reversing elements:"+arrayList);
		  
		  ArrayList temp = new ArrayList(arrayList);
		  
		  arrayList.clear();
		  
		  for(int i = temp.size() -1; i >=0 ; i--) {
			  arrayList.add((String) temp.get(i));
		  }
		  
		  System.out.println("Aftere Reversing elements:"+arrayList);
				  
	}
}
