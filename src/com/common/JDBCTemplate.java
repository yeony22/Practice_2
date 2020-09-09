package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("ClassNotFoundException:" + e.getMessage());
		System.out.println("드라이버 로딩 실패");
	} 
	
	try {
		String url="jdbc:mysql://localhost:3306/practice3?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		conn = DriverManager.getConnection(url, "conn", "Weak");
		conn.setAutoCommit(false);
	} catch (SQLException e) {
		System.out.println("SQL 예외  : " + e.getMessage());
		System.out.println("SQL state : " + e.getSQLState());
		System.out.println("vendor 에러 : " + e.getErrorCode());
	}
	return conn;
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
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) 
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit (Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
