# Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
## Examples :
```
Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.
Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
Method 1 (Simple)
Use two loops. In the outer loop, pick elements one by one and in the inner loop calculate the difference of the picked element with every other element in the array and compare the difference with the maximum difference calculated so far. Below is the implementation of the above approach :
```
## PROGRAM

```
public class ArrayMaxDiff {

	public int maxDifference(int[] arr){
		int diff = Math.abs(arr[1] - arr[0]);
		int size = arr.length;
		for(int i = 0; i < size; i++){
			for(int j = i+1;  j < size ; j++){
				//System.out.print(i+"-"+j+"  ");
				if(arr[j] - arr[i] > diff){
					diff = arr[j] - arr[i];
				}
			}
			//System.out.println("");
		}
		return diff;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {111, 1, 10000, 10, 1110} ;
		ArrayMaxDiff ob =  new ArrayMaxDiff();
		System.out.println(ob.maxDifference(arr));
	}
}


```
