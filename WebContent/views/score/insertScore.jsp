<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.dto.*" %>
<%
	ArrayList<StudentDTO> list = (ArrayList<StudentDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 프로그램</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/nav.jsp" />
	<h1>학생 성적 등록</h1>
	<form action="${pageContext.request.contextPath}/insertScore.do" method="post">
		<table border="1">
			<tr>
				<td>번호 :</td>
				<td>
					<select>
						<% for (StudentDTO sDTO : list) { %>
						<option><%= sDTO.getId() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>시험명 :</td>
				<td>
					<select name="exam">
						<option value="중간고사">중간고사</option>
						<option value="기말고사">기말고사</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>국어 점수 :</td>
				<td><input type="number" name="korean"/></td>
			</tr>
			<tr>
				<td>영어 점수 :</td>
				<td><input type="number" name="english"/></td>
			</tr>
			<tr>
				<td>수학 점수 :</td>
				<td><input type="number" name="math"/></td>
			</tr>
		</table>
		<div style="padding: 10px 0 0 90px;">
			<button type="submit">등록</button>
			<button type="button" onclick="Location.href='${pageContext.request.contextPath}/studentList.do';">조회</button>
		</div>
	</form>
</body>
</html>