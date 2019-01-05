package collections;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCDemo {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		
		Class.forName(rb.getString("driver"));
		Connection con = null;
		con = DriverManager.getConnection(rb.getString("url"),rb.getString("userid")
				,rb.getString("password"));
		con.setAutoCommit(false);
		if(con!=null){
			System.out.println("Connection Created...");
			//con.close();
		}
		return con;
		
	}
	
	public static void write(int id , String name, int salary) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2=null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement("insert into emp (id, name, salary) values(?,?,?)");
			pstmt2 = con.prepareStatement("insert into dept (id, name) values(?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, salary);
			int recCount = pstmt.executeUpdate();
			int recCount2 = pstmt2.executeUpdate();
			if(recCount>0 && recCount2>0){
				con.commit();
			}
			else{
				con.rollback();
			}
			System.out.println(recCount>0?"Record Added":"Not Added");
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}

			if(con!=null){
			con.close();
			}
		}
	}
	
	public static void read(String sal, String name) throws SQLException, ClassNotFoundException{
		Connection con = null;
		//Statement stmt = null;
		CallableStatement cstmt=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isFound = false;
		//int sal = 9000;
		ArrayList<Employee> empList = new ArrayList<>();
		try{
		con = getConnection();
		//stmt = con.createStatement();  // DML
		pstmt = con.prepareStatement("select id , name, salary from emp where salary>? or name=?");
		pstmt.setInt(1, Integer.parseInt(sal));
		pstmt.setString(2, name);
		rs = pstmt.executeQuery();
		//rs = stmt.executeQuery("select id , name, salary from emp where salary>"+sal);
		while(rs.next()){
			Employee emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"));
			empList.add(emp);
			isFound = true;
			//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("salary"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
		}
		else{
			System.out.println(empList);
		}
		}
		finally{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
//		if(stmt!=null){		
//			stmt.close();
//		}
		if(con!=null){
		con.close();
		}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//write(1000,"Tim",7777);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Salary");
		String sal = scanner.nextLine();
		System.out.println("Enter the Name");
		read(sal, scanner.nextLine());
		// TODO Auto-generated method stub
		//com.mysql.jdbc.Driver"
		// oracle.jdbc.driver.OracleDriver
		// 
		
		// jdbc:postgresql://hostname:port/dbname
		// jdbc:oracle:thin:@localhost:1521:SID
		// jdbc:mysql://hostname:port/dbname
//		Class.forName("org.postgresql.Driver");
//		System.out.println("Driver Loaded..");
//		Connection con = null;
//		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shopping","amit","amit123");
//		if(con!=null){
//			System.out.println("Connection Created...");
//			con.close();
//		}
	}

}
