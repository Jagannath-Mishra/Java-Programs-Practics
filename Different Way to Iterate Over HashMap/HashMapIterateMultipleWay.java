package com.java.test.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapIterateMultipleWay {
  public static void main(String[] args) {
	
	  
	  HashMap<String, Integer> hm = new HashMap<String, Integer>();
	  
	  hm.put("Jagannath", 154);
	  hm.put("Gariyashee", 475);
	  hm.put("Sunil Kumar", 147);
	  hm.put("Ganesh", 107);
	  
	  
	  
	  for(Map.Entry<String, Integer> map: hm.entrySet()){
		  System.out.println(map.getKey()+" - " +map.getValue());
	  }
	  
	  Set<String> mset = hm.keySet();
	  
	  for(String s : mset){
		  Integer value = hm.get(s);
		  System.out.println(s+" - "+value);
	  }
	  
	//iterating over values only
	  
	  for(Integer value: hm.values()){
		  System.out.println("values = "+ value);
	  }
	  
	//iterating over keys only
	  
	  for(String key: hm.keySet()){
		  System.out.println("Key = "+key);
	  }
	  
	 // Method #3: Iterating using Iterator.
	 Iterator<Map.Entry<String, Integer>> itr = hm.entrySet().iterator();
	 
	 while(itr.hasNext()){
		 System.out.println(itr.next().getKey()+"--"+itr.next().getValue());
	 }
	  
}
}
