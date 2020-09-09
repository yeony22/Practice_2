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
 * Servlet implementation class ScoreInsert
 */
@WebServlet("/insertScore.do")
public class ScoreInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreInsert() {
        super();
    }
    // 주석_update_pushTest
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String exam = request.getParameter("exam");
		int korean = Integer.parseInt(request.getParameter("korean"));
		int engilsh = Integer.parseInt(request.getParameter("english"));
		int math = Integer.parseInt(request.getParameter("math"));
				
		StudentService sService = new StudentService();
		StudentDTO sDTO = new StudentDTO();
		
		sDTO.setId(id);
		sDTO.setExam(exam);
		sDTO.setKorean(korean);
		sDTO.setEngilsh(engilsh);
		sDTO.setMath(math);
	
		int result = sService.insertScore(sDTO);
		
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
