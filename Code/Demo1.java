package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Demo1 {
	static void print(List<Integer> list){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<>();
		v.add(100);
		v.addElement(200);
		print(v);
		TreeMap<String,Integer> map = new TreeMap<>();
		map.put("delhi", 10);
		map.put("mumbai", 30);
		System.out.println("Temp "+map.get("delhi"));
		
		TreeSet<String> sets = new TreeSet<>();
		sets.add("ajay");
		sets.add("tim");
		sets.add("tim");
		sets.add("amit");
		sets.add("anil");
		sets.add("tim");
		Object obj = 10;
		obj = "Hello";
		obj = true;
		System.out.println("Sets "+sets);
//		ArrayList l   = new ArrayList();
//		l.add(10);
//		l.add("Hello");
		//Integer q = (Integer)l.get(0);
		//ArrayList<Integer> p = new ArrayList<>();
		List<Integer> p = new ArrayList<>();
		p.add(100); // p.add(new Integer(100));
		ArrayList<String> l = new ArrayList<>();
		l.add("amit");
		l.add("anil");
		l.add(0,"mike");
		l.add("ajay");
		l.add("tim");
		//l.sort(c);
		System.out.println(l.contains("amit")?"Found":"Not Found");
		System.out.println(l.indexOf("amit")>=0?"Found":"Not Found");
		Collections.sort(l);
		String e = l.get(0);
		System.out.println("E is "+e);
		//l.remove(0);
		//l.remove("mike");
		l.set(0, "ram");
		System.out.println(l);
		// Traverse 
//		for(int i = 0; i<l.size();i++){
//			if(l.get(i).startsWith("a")){
//				System.out.println(l.get(i));
//			}
//		}
		// Java 5
//		for(String name: l){
//			if(name.startsWith("a")){
//				System.out.println(name);
//			}
//		}
		// Java 4
//		Iterator<String> j = l.iterator();
//		while(j.hasNext()){
//			System.out.println(j.next());
//		}
		System.out.println("*******************");
//		ListIterator<String> k = l.listIterator();
//		while(k.hasNext()){
//			System.out.println(k.next());
//			//k.remove();
//		}
//		while(k.hasPrevious()){
//			System.out.println(k.previous());
//		}
		// Java 8
		System.out.println(l.size());
		Integer x[]= {10,20,30,40,50};
		List<Integer> i = Arrays.asList(x);
		//l.forEach(y->System.out.println(y));
		long result = i.parallelStream().filter(y->y>20).mapToInt(z->z).count();
		
		

	}

}
