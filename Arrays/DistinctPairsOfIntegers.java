package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class DistinctPairsOfIntegers {
	//Finding the number of distinct pairs of integers that sum up to an integer
	public static int compute(int[] input, int k){
		
		 Map<Integer, Integer> frequencies = new HashMap<>();
		    int pairsCount = 0;      

		    for(int i=0; i<input.length; i++){
		        int value = input[i];
		        int complement = k - input[i];

		        if(frequencies.containsKey(complement)){                
		            int freq = frequencies.get(complement) - 1;
		            pairsCount++;
		            //System.out.println(value + ", " + complement);    
		            if(freq == 0){
		                frequencies.remove(complement);
		            }else{
		                frequencies.put(complement, freq);
		            }
		        }else{
		            if(frequencies.containsKey(value)){         
		                frequencies.put(value, frequencies.get(value) + 1);             
		            }else{
		                frequencies.put(value, 1);
		            }
		        }
		    }
		    return pairsCount;
		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2, 2, 2, 3, 4, 4, 4};
		System.out.println(compute(a, 8));
	}
}

