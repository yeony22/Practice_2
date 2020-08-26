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

import com.dto.MemberDTO;

import static com.common.JDBCTemplate.*;


public class MemberDAO {
	private Properties prop;	//sql별도로 보관하는 properties 객체 생성
	
	public MemberDAO() {
		prop = new Properties();
		
		String filePath = MemberDAO.class.getResource("/config/shopping-query.properties").getPath();
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public int insertMember(Connection con, MemberDTO m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getCustname());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getGrade());
			pstmt.setString(5, m.getCity());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}	
		
		return result;
	}
	
	public ArrayList<MemberDTO> selectMember(Connection con) {
		ArrayList<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null; // sql 문을 db로 보내는 객체
		ResultSet rset = null; 	// sql 질의에 의해 생성된 테이블을 저장하는 객체
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberDTO m = new MemberDTO();
				
				m.setCustno(rset.getInt("CUSTNO"));
				m.setCustname(rset.getString("CUSTNAME"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setJoindate(rset.getDate("JOINDATE"));
				m.setGrade(rset.getString("GRADE"));
				m.setCity(rset.getString("CITY"));
	
				list.add(m);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {

			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public MemberDTO selectMemberOne(Connection con, int custno) {
		MemberDTO member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, custno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new MemberDTO();
				
				member.setCustno(rset.getInt("CUSTNO"));
				member.setCustname(rset.getString("CUSTNAME"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setJoindate(rset.getDate("JOINDATE"));
				member.setGrade(rset.getString("GRADE"));
				member.setCity(rset.getString("CITY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
		
	}
	
	public ArrayList<MemberDTO> selectSeller(Connection con) { 
		ArrayList<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSales");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery(); // 쿼리 실행
			
			while(rset.next()) {
				MemberDTO m = new MemberDTO();
				
				m.setCustno(rset.getInt("CUSTNO"));
				m.setCustname(rset.getString("CUSTNAME"));
				m.setGrade(rset.getString("GRADE"));
				m.setSales(rset.getInt("SALES"));
				
				list.add(m);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int updateMember(Connection con, MemberDTO m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getCustname());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getGrade());
			pstmt.setString(5, m.getCity());
			pstmt.setInt(6, m.getCustno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}

