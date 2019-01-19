package com.brainmentors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brainmentors.dto.UserDTO;
import com.brainmentors.utils.SQLConstants;



public class UserDAO implements SQLConstants {
	public String login(UserDTO userDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(USER_LOGIN_SQL);
			pstmt.setString(1,userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				return "Welcome "+userDTO.getUserid();
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return "Invalid Userid or Password";
	}
}
