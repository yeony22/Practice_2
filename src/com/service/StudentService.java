package com.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dto.StudentDTO;

import static com.common.JDBCTemplate.*;

public class StudentService {
	private StudentDAO sDAO = new StudentDAO();
	
	public int insertStudent(StudentDTO sDTO) {
		Connection con = getConnection();
		
		int result = sDAO.insertStudent(con, sDTO);
		
		try {
			if(result > 0)
				con.commit();
			else
				con.rollback();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
	public ArrayList<StudentDTO> selectStudentList() {
		Connection con = getConnection();
		
		ArrayList<StudentDTO> list = sDAO.selectStudentList(con);
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public StudentDTO selectStudentOne(int id) {

		Connection con = getConnection();
		
		 StudentDTO sDTO  = sDAO.selectStudentOne(con, id);
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sDTO;
	}

	public int updateStudent(StudentDTO sDTO) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = sDAO.updateStudent(con, sDTO);
		
		try {
			if(result > 0)
				con.commit();
			else
				con.rollback();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}

}
