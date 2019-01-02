package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class NavDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> v = new LinkedList<>();
		Queue<Integer> k1 = new PriorityQueue<>();
		ArrayList<Integer> q = new ArrayList<>();
		List<Integer> m1 = Collections.synchronizedList(q);
		System.out.println(q==m1);
		synchronized (q) {
			q.add(100);
		}
		q.add(90);
		NavigableSet<Integer> i = new TreeSet<>();
		i.add(10);
		i.add(20);
		i.add(30);
		i.add(1);
		System.out.println(i);
		System.out.println(i.ceiling(21)); // >=
		System.out.println(i.floor(20)); //<=
		System.out.println(i.lower(10)); //<
		System.out.println(i.higher(20));  //>
		
		

	}

}
