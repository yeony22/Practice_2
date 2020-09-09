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
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../common/nav.jsp"/>
<%-- <form 
    action="<%=request.getContextPath()%>/studentList.do"  method="post"
  > --%>
	 <h1>학생 목록 조회/수정</h1>
	 <table border="1">
	 	<tr>
	 		<th>학생번호</th>
	 		<th>학년</th>
	 		<th>반</th>
	 		<th>학생명</th>
	 		<th>전화번호</th>
	 	</tr>
	 	<% for (StudentDTO sDTO : list) { %>
	 	<tr>
	 		<td>
	 		<a href="${pageContext.request.contextPath}/studentSelectOne.do?id=<%=sDTO.getId() %>"><%= sDTO.getId() %></a>
	 		</td>
	 		<td><%= sDTO.getGrade() %></td>
	 		<td><%= sDTO.getRoom() %></td>
	 		<td><%= sDTO.getName() %></td>
	 		<td><%= sDTO.getPhone() %></td>
	 	</tr>
	 	<% } %>
	 </table>
	<jsp:include page="../common/footer.jsp"/>
	 
</body>
</html>
