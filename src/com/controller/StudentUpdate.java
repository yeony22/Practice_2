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
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/studentUpdate.do")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		int room = Integer.parseInt(request.getParameter("room"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		StudentDTO sDTO = new StudentDTO(id, grade, room, name, phone);
		
		StudentService sService = new StudentService();
		
		int result = sService.updateStudent(sDTO);
		
		if(result > 0) {
			System.out.println("데이터 변경 성공");
			response.sendRedirect("index.jsp");
		}
		else
			System.out.println("변경 실패");
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
