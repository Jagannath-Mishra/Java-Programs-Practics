
public class FindGreaterAmontThreeUsingNestedIfElse {
public static void main(String[] args) {


	int x = 61;
	int y = 55;
	int z = 61;
	
	if(x>=y && x>=z) 
		System.out.println("Greater is x : "+ x);
	else if(y>=x && y>=z)
		System.out.println("Greater is x : "+ y);
	else if(z>=x && z>=y)
		System.out.println("Greater is x : "+ z);
	
}
}
