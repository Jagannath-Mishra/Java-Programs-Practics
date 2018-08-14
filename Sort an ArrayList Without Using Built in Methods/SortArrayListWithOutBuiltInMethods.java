import java.util.ArrayList;

public class SortArrayListWithOutBuiltInMethods {
	
	public ArrayList<Integer> sortArrayList(ArrayList<Integer> al){
		
		int n = al.size();
		
		for (int i=0; i < n; i++) {
			
			for (int j =0; j < n-i-1; j++) {
				
				if(al.get(j) > al.get(j+1)) {
					int temp = al.get(j);
					al.set(j, al.get(j+1));
					al.set(j+1, temp);
				}
				
			}
		}
		
		
		return al;
	}

	public static void main( String args[]) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(5);
		al.add(85);
		al.add(50);
		al.add(200);
		al.add(10);
		SortArrayListWithOutBuiltInMethods obj =  new SortArrayListWithOutBuiltInMethods();
		
		System.out.println(obj.sortArrayList(al));
	}	
	
}

