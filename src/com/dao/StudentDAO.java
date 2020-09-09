package com.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dto.StudentDTO;
import com.common.JDBCTemplate.*;

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

	public ArrayList<StudentDTO> selectStudentList(Connection conn) {
		
		//list 객체를 인스턴스
		ArrayList<StudentDTO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null; // sql실행
		ResultSet rs = null; // select결과 처리
		
		String sql = "SELECT * FROM student";

		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				StudentDTO sDTO = new StudentDTO();
				
				sDTO.setId(rs.getInt("ID"));
				sDTO.setGrade(rs.getInt("GRADE"));
				sDTO.setRoom(rs.getInt("ROOM"));
				sDTO.setName(rs.getString("NAME"));
				sDTO.setPhone(rs.getString("PHONE"));
				
				list.add(sDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
					e2.printStackTrace();
				}
			} try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
					e2.printStackTrace();
			
			}
		
		return list;
	}

}
