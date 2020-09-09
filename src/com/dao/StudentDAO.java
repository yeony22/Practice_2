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

	public int insertStudent(Connection con, StudentDTO sDTO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertStudent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sDTO.getGrade());
			pstmt.setInt(2, sDTO.getRoom());
			pstmt.setString(3, sDTO.getName());
			pstmt.setString(4, sDTO.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
	public ArrayList<StudentDTO> selectStudentList(Connection con) {
		ArrayList<StudentDTO> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectStudentList");
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StudentDTO sDTO = new StudentDTO();
				
				sDTO.setId(rset.getInt("id"));
				sDTO.setGrade(rset.getInt("grade"));
				sDTO.setRoom(rset.getInt("room"));
				sDTO.setName(rset.getString("name"));
				sDTO.setPhone(rset.getString("phone"));
				
				list.add(sDTO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			
			}
		}
		return list;
	}
	
	public StudentDTO selectStudentOne(Connection con, int id) {
		StudentDTO sDTO = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectStudentOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sDTO = new StudentDTO();
				
				sDTO.setId(rset.getInt("id"));
				sDTO.setGrade(rset.getInt("grade"));
				sDTO.setRoom(rset.getInt("room"));
				sDTO.setName(rset.getString("name"));
				sDTO.setPhone(rset.getString("phone"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			
			}
		}
		return sDTO;
	}
	
	public int updateStudent(Connection con, StudentDTO sDTO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateStudent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sDTO.getGrade());
			pstmt.setInt(2, sDTO.getRoom());
			pstmt.setString(3, sDTO.getName());
			pstmt.setString(4, sDTO.getPhone());
			pstmt.setInt(5, sDTO.getId());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
			
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return result;
	}
	
	public int insertScore(Connection con, StudentDTO sDTO) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertScore");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sDTO.getId());
			pstmt.setString(2, sDTO.getExam());
			pstmt.setInt(3, sDTO.getKorean());
			pstmt.setInt(4, sDTO.getEngilsh());
			pstmt.setInt(5, sDTO.getMath());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return result;
	}
}
