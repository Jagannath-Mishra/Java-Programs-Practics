import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicateArrayListUsingCoreLogic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add(20);
		al.add(75);
		al.add(14);
		al.add(14);
		al.add(20);
		al.add(2);
		al.add(1);
		al.add(75);
		al.add(14);
		al.add(14);
		al.add(20);
		al.add(75);
		al.add(14);
		al.add(14);
		al.add(20);
		al.add(75);
		al.add(14);
		al.add(14);
		al.add(20);
		
		System.out.println("Before Remove Duplicate elements:"+al);
		
		for(int i =0 ; i<al.size();i++) {
			
			for(int j=i+1; j<al.size();j++) {
				if(al.get(j).equals(al.get(i)))
						{
							al.remove(j);
							j--;
				
						}
			}
		}
		System.out.println("After Removing duplicate elements:"+al);
	}
}
