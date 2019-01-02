package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

class ITCustomer{
	private int id;
	private String name;
	private double salary;
	public ITCustomer(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "ITCustomer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> i = new ArrayList<>();
		i.add(10);
		i.add(20);
		List<Integer> j = Collections.synchronizedList(i);
		System.out.println(i==j);
		LinkedHashSet<ITCustomer> custSet = new LinkedHashSet<>();
		custSet.add(new ITCustomer(1001, "Ram", 9999));
		custSet.add(new ITCustomer(1002, "Tim", 39999));
		custSet.add(new ITCustomer(1002, "Tim", 39999));
		custSet.add(new ITCustomer(1001, "Ram", 29999));
		System.out.println(custSet);
	}

}
