package collections;

import java.util.HashSet;

class Emp implements Comparable<Emp>{
	private int id;
	private String name;
	private double salary;
	@Override
	public int hashCode(){
		return name.length();
	}
	
	@Override
	public boolean equals(Object object){
		if(this==object){
			return true;
		}
		if(object instanceof Emp){
			Emp e = (Emp) object;
			if(this.id == e.id && this.name.equals(e.name) && this.salary == e.salary){
				return true;
			}
		}
		return false;
	}
	
	Emp(int id , String name, double salary){
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

	public String toString(){
		return "Id "+id+" Name "+name+" Salary "+salary;
	}


	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(o.name);
	}
}
public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Emp> sets = new HashSet<>();
		/*TreeSet<Emp> sets = new TreeSet<>
		((first,second)->first.getName().compareToIgnoreCase(second.getName()));
		*/
		Emp ram = new Emp(1001, "Ram", 9999);
		sets.add(ram);
		sets.add(new Emp(1002, "Shyam", 9999));
		sets.add(new Emp(1003, "Sohan", 9999));
		Emp ram2 = new Emp(1001, "Ram", 9999);
		sets.add(ram2);
		System.out.println(ram.hashCode()+" "+ram2.hashCode());
		System.out.println(sets);

	}

}
