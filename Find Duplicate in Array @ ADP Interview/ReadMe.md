# How to find duplicate in array and highest value of repatative element. 

### Example : array = {1,8,4,2,5,6,3,4,5,87,2,1,5,4,6,6,6,4,7,10,8,2,5};
	      ###### Note: repeatative element: {1=2, 2=3, 3=1, 4=4, 5=4, 6=4, 87=1, 7=1, 8=2, 10=1}
	      ###### Greatest Among : 4=4, 5=4, 6=4
#### Output Should Be : 6

##### Code Here:
```

public class FindDuplicatesInArray {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = {1,8,4,2,5,6,3,4,5,87,2,1,5,4,6,6,6,4,7,10,8,2,5};
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i=0;i<array.length;i++) {
			Integer val = (Integer) hm.get(array[i]);
			if(hm.containsKey(array[i])) {
				hm.put(array[i], val + 1 );
			}
			else
				hm.put(array[i],1);
			
		}
	
		System.out.println(hm);
		
		Integer maxValueInHashMap = Collections.max(hm.values());

		
		for(Entry<Integer, Integer> ent : hm.entrySet()) {
			if(ent.getValue() == maxValueInHashMap) {
				ts.add(ent.getKey());
			}
		}
		System.out.println(ts.last());
		
	}
	
	
}
```
