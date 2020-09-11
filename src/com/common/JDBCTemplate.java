package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		
		}
		try {
			String url = "jdbc:mysql://localhost:3306/practice3?characterEndoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
			con = DriverManager.getConnection(url, "root", "Weak");
			con.setAutoCommit(false);
			
		} catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null & !stmt.isClosed())
				stmt.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public static void commit(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.rollback();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
}
