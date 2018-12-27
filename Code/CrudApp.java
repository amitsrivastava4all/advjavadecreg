package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class CustomerOperations{
	private static ArrayList<Customer> customers = new ArrayList<>();
	static void addCustomer(int id , String name , String city){
		Customer customer = new Customer(id, name, city);
		customers.add(customer);
	}
	static ArrayList<Customer> getCustomers(){
		return customers;
	}
	static String search(int id , String name , String city){
		Customer searchCustomer = new Customer(id , name, city);
		return customers.contains(searchCustomer)?"Found ":"Not Found";
	}
	static void sort(){
		Collections.sort(customers);
		
	}
	static String delete(int id ){
		Customer searchCustomer = new Customer(id);
		int index = customers.indexOf(searchCustomer);
		if(index>=0){
			customers.remove(index);
			return "Record Deleted";
		}
		else{
			return "Can't Delete Record Not Found";
		}
		//return index>=0?"Record Delete ":"Can't Delete Not Found";
	}
}
class Customer implements Comparable<Customer>{
	private int id;
	private String name;
	private String city;
	
	@Override
	public int compareTo(Customer object){
			//return this.name.compareToIgnoreCase(object.name);
		//return object.name.compareToIgnoreCase(this.name);
		return ((Integer)this.id).compareTo(object.id);
	}
	Customer(int id){
		this.id = id;
	}
	Customer(int id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public boolean equals(Object object){
		if(this==object){
			return true;
		}
		if(object instanceof Customer){
			Customer customer = (Customer) object;
			if(this.id == customer.id && this.name==null){
				return true;
			}
			if(this.id==customer.id && this.name.equals(customer.name) && this.city.equals(customer.city)){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString(){
		return "id "+id+ "name "+name+" City "+city+"\n";
	}
	
}
public class CrudApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("1. Add a Customer");
			System.out.println("2. Search a Customer");
			System.out.println("3. Delete a Customer");
			System.out.println("4. Update a Customer");
			System.out.println("5. Sort  Customers");
			System.out.println("6. Count Customers");
			System.out.println("7. Total Balance of All Customers");
			System.out.println("8 . Print");
			System.out.println("9 . exit");
			int choice = s.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the Id ");
				int id = s.nextInt();
				System.out.println("Enter the Name");
				String name = s.next();
				System.out.println("Enter the City");
				String city = s.next();
				CustomerOperations.addCustomer(id, name, city);
				break;
			case 2:
				System.out.println("Enter the Id ");
				int id1 = s.nextInt();
				System.out.println("Enter the Name");
				String name1 = s.next();
				System.out.println("Enter the City");
				String city1 = s.next();
				System.out.println(CustomerOperations.search(id1, name1, city1));
				break;
			case 3:
				System.out.println("Enter the Id ");
				int id2 = s.nextInt();
				System.out.println(CustomerOperations.delete(id2));
				break;
			case 5:
				CustomerOperations.sort();
				System.out.println(CustomerOperations.getCustomers());
				break;
			case 8:
				System.out.println(CustomerOperations.getCustomers());
				break;
			}
			
		}

	}

}
