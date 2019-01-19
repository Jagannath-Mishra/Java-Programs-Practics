# SORT ARRAY in EVEN and ODD 


```

public static void main(String[] args) {
		
		 int[] b = {10,1,24,2,5, 5,1};
		 int n = b.length;
		 for(int i = 0; i<n ; i++)
		 
		 {
			for(int j = 0; j<n-i-1 ; j++) {
				if(b[j] % 2 != 0 ){
					int temp = b[j];
					b[j] = b[j+1];
					b[j+1] = temp;
				}
			}
		 }
		 
		 for(int x : b){
			 System.out.println(x);
		 }
		 
		 
	}
  
```
