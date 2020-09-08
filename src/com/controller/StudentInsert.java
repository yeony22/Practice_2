package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentDTO;
import com.service.StudentService;

/**
 * Servlet implementation class StudentInsert
 */
@WebServlet("/insertStudent.do")
public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsert() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int grade = Integer.parseInt(request.getParameter("grade"));
		int room = Integer.parseInt(request.getParameter("room"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		StudentDTO sDTO = new StudentDTO();
		sDTO.setGrade(grade);
		sDTO.setRoom(room);
		sDTO.setName(name);
		sDTO.setPhone(phone);
		
		StudentService sService = new StudentService(); 
		
		int result = sService.insertStudent(sDTO);
		
		if(result > 0) {
			System.out.println("데이터 추가 성공");
			response.sendRedirect("index.jsp");
		}
		else
			System.out.println("데이터 추가 실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
