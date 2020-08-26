package com.service;

import com.dto.MemberDTO;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.dao.MemberDAO;

public class MemberService {
	private MemberDAO mdao;
	
	public MemberService() {
		mdao = new MemberDAO();
	}
	public int insertMember(MemberDTO m) {
		Connection con = getConnection();
		int result = mdao.insertMember(con, m);
		
		if (result > 0)
			commit(con);
		else
			rollback(con);
		
		return result;
	}

	public ArrayList<MemberDTO> selectList() {
		Connection con = getConnection();
		
		ArrayList<MemberDTO> list = mdao.selectMember(con);
		
		close(con);
		
		return list;
	}
	
	public MemberDTO selectOne(String custno) {
		Connection con = getConnection();
		
		MemberDTO member = mdao.selectMemberOne(con, Integer.parseInt(custno));
		
		close(con);
		
		return member;
	}
	
	public ArrayList<MemberDTO> selectSellerList(){
		Connection con = getConnection();
		
		ArrayList<MemberDTO> list = mdao.selectSeller(con);
		
		close(con);
		
		return list;
	}
	
	public int updateMember(MemberDTO m) {
		Connection con = getConnection();
		
		int result = mdao.updateMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
}
