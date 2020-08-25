package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection getConnection() {

		Connection conn = null; // DB 연동할 객체 생성

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 해당 클래스가 메모리에 로드 및 실행

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		}

		try { // drive 클래스를 이용해 커넥션 객체에 localhost:3306/practice1 과 연동 및 예외처리
			String url = "jdbc:mysql://localhost:3306/student_data?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			conn = DriverManager.getConnection(url, "root", "Weak"); // DB 로그인 정보로 연동
			conn.setAutoCommit(false); // commit 수동 설정

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		
//		try {
//			conn.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return conn;
	}

	// 오버로딩 기술 적용!
	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
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
