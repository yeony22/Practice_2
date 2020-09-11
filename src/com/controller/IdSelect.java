
  package com.controller;
  
  import java.io.IOException; import java.util.ArrayList;
  
  import javax.servlet.ServletException; import
  javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse;
  
  import com.dto.StudentDTO; import com.service.StudentService; import
  com.common.JDBCTemplate.*;
  
 /**
	 * Servlet implementation class IdSelect
	 */

  
  
  @WebServlet("/selectId.do") public class IdSelect extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
 /**
	 * @see HttpServlet#HttpServlet()
	 */

  
  
  public IdSelect() { super(); }
  
 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

  
  
  protected void doGet(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException { StudentService sService =
  new StudentService(); ArrayList<StudentDTO> list =
  sService.selectStudentList();
  
  request.setAttribute("list", list);
  request.getRequestDispatcher("views/score/insertScore.jsp").forward(request,
  response); }
  
 /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
		  protected void doPost(HttpServletRequest request, HttpServletResponse
		  response) throws ServletException, IOException { doGet(request, response); }
		  
		  }
		 