import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateArrayListInsertionOrderNotPreserved {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add(20);
		al.add(75);
		al.add(14);
		al.add(14);
		al.add(20);
		al.add(2);
		al.add(1);
		
		System.out.println("Before Remove Duplicate elements:"+al);
		
		
	
		HashSet hs = new HashSet();
		
		  /* Adding ArrayList elements to the HashSet
	     * in order to remove the duplicate elements and 
	     * not to preserve the insertion order.
	     */
		hs.addAll(al);
		
			
		// Removing ArrayList elements
		al.clear();

		// Adding HashSet elements to the ArrayList
		al.addAll(hs);
	
		System.out.println("Before Remove Duplicate elements:"+al);
	}
}
