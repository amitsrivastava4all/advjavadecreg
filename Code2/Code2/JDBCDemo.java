package collections;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCDemo {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		
		Class.forName(rb.getString("driver"));
		Connection con = null;
		con = DriverManager.getConnection(rb.getString("url"),rb.getString("userid")
				,rb.getString("password"));
		if(con!=null){
			System.out.println("Connection Created...");
			//con.close();
		}
		return con;
		
	}
	
	public static void read(String sal, String name) throws SQLException, ClassNotFoundException{
		Connection con = null;
		//Statement stmt = null;
		CallableStatement cstmt=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isFound = false;
		//int sal = 9000;
		try{
		con = getConnection();
		//stmt = con.createStatement();  // DML
		pstmt = con.prepareStatement("select id , name, salary from emp where salary>? and name=?");
		pstmt.setInt(1, Integer.parseInt(sal));
		pstmt.setString(2, name);
		rs = pstmt.executeQuery();
		//rs = stmt.executeQuery("select id , name, salary from emp where salary>"+sal);
		while(rs.next()){
			isFound = true;
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("salary"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
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
