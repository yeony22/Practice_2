<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dto.*" %>

<%
	StudentDTO sDTO = (StudentDTO)request.getAttribute("student");
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
	<h1>학생 정보 수정</h1>
		<form action="${pageContext.request.contextPath}/studentUpdate.do" method="post" onsubmit="return fn_validate(this);">
	
	<table style="margin-left: 10px;">
			<tr>
				<td>번호 : </td>
				<td><%=sDTO.getId() %>
				<input type="hidden" name="id" value="<%=sDTO.getId() %>"/>
				</td>
			</tr>
			<tr>
				<td>학년 : </td>
				<td>
				<input type="text" name="grade" id="grade" value="<% sDTO.getGrade(); %>"/>
				</td>
			</tr>
			<tr>
				<td>반 : </td>
				<td>
				<input type="text" name="room" value="<% sDTO.getRoom(); %>"/>
				</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>
				<input type="text" name="name" value="<% sDTO.getName(); %>"/>
				</td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td>
				<input type="text" name="phone" value="<% sDTO.getPhone(); %>" placeholder="-제외"/>
				</td>
			</tr>
		</table>
		<div style="padding: 10px 0 0 90px;">
			<button type="submit">수정</button>
			<button type="button" onclick="Location.href='${pageContext.request.contextPath}/studentList.do';">조회</button>
		</div>
	</form>
	<jsp:include page="../common/footer.jsp"/>
	
		<script>
		
		function fn_validate(e){
			if(document.querySelector("#name").value == ''){
				alert('학생 명을 제대로 기입해주셔야 합니다!');
				
				return false;
			}
			
			alert("학생 정보 변경이 완료되었습니다!");
			
			return true;
		}
	
	</script>

</body>
</html>