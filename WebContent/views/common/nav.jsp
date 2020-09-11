<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.link {
		padding: 5px;
		color: black;
		font-weight:bolder;
		text-decoration: none;
	}
</style>
<nav style="width: 100%; height: 50px; margin-top: 10px;">
	<div style="color: black">
		<a class="link" href="${pageContext.request.contextPath}/views/student/insertStudent.jsp">학생 등록</a>
		<a class="link" href="${pageContext.request.contextPath}/studentList.do">학생 목록 조회/수정</a>
		<a class="link" href="${pageContext.request.contextPath}/selectId.do">학생 성적 등록</a>
		<a class="link" href="${pageContext.request.contextPath}/scoreList.do">학생 성적 조회</a>
	</div>
	
</nav>