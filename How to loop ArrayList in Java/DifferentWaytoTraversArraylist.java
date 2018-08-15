import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class DifferentWaytoTraversArraylist {

	public static void main(String[] args) {
		
		ArrayList<String> games = new ArrayList<String>(10);
        games.add("Cricket");
        games.add("Soccer");
        games.add("Hockey");
        games.add("Chess");

      //Looping over ArrayList in Java using advanced for loop
        System.out.println("\n Looping over ArrayList in Java using advanced for loop ");
        for(String game: games) {
        	 //print each element from ArrayList
            System.out.println(game);
        }
        
        //Looping over ArrayList in Java using  for loop
        System.out.println("\n Looping over ArrayList in Java using for loop ");
        for(int i=0; i<games.size();i++) {
        	 //print each element from ArrayList
            System.out.println(games.get(i));
        
        }  
        
      //Looping over ArrayList in Java using  while loop
        System.out.println("\n Looping over ArrayList in Java using while loop ");
        int j = 0;
        while(j < games.size()) {
        	
        	System.out.println(games.get(j));
        	j++;
        }
        
        
        //Looping over ArrayList in Java using  Iterator
        System.out.println("\n Looping over ArrayList in Java using Iterator ");
        
        Iterator itr = games.iterator();
        
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        //Looping over ArrayList in Java using  ListIterator
        System.out.println("\n Looping over ArrayList in Java using ListIterator ");
        
        ListIterator litr = games.listIterator();
        
        while(litr.hasNext()) {
        	System.out.println(litr.next());
        }
	}
}
