
public class FindGreaterAmontThreeUsingIfElse {
public static void main(String[] args) {


	int x = 60;
	int y = 60;
	int z = 60;
	
	if(x >= y) {
		if(x >= z) {
			System.out.println("Greater is x : "+ x);
		}
		else
		{
			System.out.println("Greater is z : "+ z);
		}
	}
	else {
		if(y >= z) {
			System.out.println("Greater is y : "+ y);
		}
		else {
			System.out.println("Greater is z : "+ z);
		}
	}
}	
}
