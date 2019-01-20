package com.brainmentors.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	static Connection getConnection() throws SQLException, ClassNotFoundException{
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

}
