package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentDTO;
import com.service.StudentService;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/studentList.do")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService ss = new StudentService();
		ArrayList<StudentDTO> list = ss.selectStudentList();
			
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/student/studentList.jsp").forward(request, response); // redirect는 response로 값만 보내고 
		// 값을 보낼 때는 requestDispatcher를 사용해서 .forward(request, response) 서버측 내용을 공유
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
