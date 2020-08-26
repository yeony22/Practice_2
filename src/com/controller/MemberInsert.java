package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/memberInsert.do") // 회원 등록 페이지
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public MemberInsert() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		MemberDTO m = new MemberDTO(custname, phone, address, grade, city);
		
		MemberService mService = new MemberService();
		int result = mService.insertMember(m);
		
		if(result > 0){
			System.out.println("데이터 추가 성공");
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("데이터 추가 실패");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
		
}
