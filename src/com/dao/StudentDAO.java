package com.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dto.StudentDTO;

public class StudentDAO {
	private Properties prop;

	public StudentDAO() {
		prop = new Properties();

		String filePath = StudentDAO.class.getResource("/config/student-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));

		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int insertStudent(Connection con, StudentDTO s) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertStudent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, s.getGrade());
			pstmt.setInt(2, s.getRoom());
			pstmt.setString(3, s.getName());
			pstmt.setString(4, s.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}

}
