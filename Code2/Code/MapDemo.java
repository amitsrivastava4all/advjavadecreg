package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<>();
		map.put("ram", 2222);
		map.put("shyam", 2222);
		map.put("ram", 3333);
		map.put("tom", 4222);
		System.out.println(map);
		
		// Traverse
		/*Set<String> sets = map.keySet();
		Iterator<String> keys =sets.iterator();
		while(keys.hasNext()){
			String key = keys.next(); 
			System.out.println("Key "+key+" Value "+map.get(key));
		}*/
		for(Map.Entry<String, Integer> m : map.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		
		//map.remove("ram");
		HashMap<String,ArrayList<Integer>> map2 = new HashMap<>();
		ArrayList<Integer> i = new ArrayList<>();
		i.add(100);i.add(200);
		map2.put("ram", i);
		System.out.println(map2);
		
		
		

	}

}
