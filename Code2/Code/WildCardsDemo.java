package collections;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class Q{
	
}
interface M{
	
}

class X implements M{
	
}
class Y extends X{
	
}
class Z extends X{
	
}

public class WildCardsDemo {
	
	public static void print2(X [] x){
		System.out.println("Print2 call");
	}
	
//	public static  void print(ArrayList<? super Y> xList){
//		System.out.println("Print Call");
//	}
//	public static  void print(ArrayList<? extends M> xList){
//		System.out.println("Print Call");
//	}
	
	public static  void print(ArrayList<?> xList){
		System.out.println("Print Call");
	}
	
	/*public static  void print(ArrayList<X> xList){
		System.out.println("Print Call");
	}*/
	
	public static  void print3(ArrayList<Object> objectList){
		System.out.println("Print Call.......");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Y y[] = new Y[10];
//		Z z [] = new Z[10];
//		X x [] = new X[10];
//		print2(z);
//		print2(y);
//		print2(x);
		//List<Integer>  k = Arrays.asList(10,20,30,40,50);
		//ArrayList<Integer> k1 = (ArrayList<Integer>)k;
		CopyOnWriteArrayList<Integer> k1 = new CopyOnWriteArrayList<>();
		for(int i =1 ; i<=5; i++){
			System.out.println(k1.add(i));
		}
		k1.add(100);
		System.out.println("Before Loop "+k1);
		for(Integer m1:k1){
			System.out.println(m1);
			k1.add(1000);
		}
		System.out.println("List is "+k1);
		//System.out.println(k);
		
		ArrayList<Object> w = new ArrayList<>();
		w.add(100);
		int ww = (Integer)w.get(0);
		w.add("Abcd");
		
		ArrayList<Q> qList = new ArrayList<>();
		ArrayList<Y> yList = new ArrayList<>();
		ArrayList<Z> zList = new ArrayList<>();
		ArrayList<X> xList = new ArrayList<>();
		//print(qList);
		print(xList);
		print(yList);
		//print3(xList);
		//print(zList);

	}

}
