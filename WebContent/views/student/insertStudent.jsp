<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 프로그램</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../common/nav.jsp"/>
	<h1>학생 정보 등록</h1>
	<form action="${pageContext.request.contextPath}/insertStudent.do" method="post">
		<table style="margin-left: 10px;">
			<tr>
				<td>학년 : </td>
				<td><input type="text" name="grade" id="grade"/></td>
			</tr>
			<tr>
				<td>반 : </td>
				<td><input type="text" name="room"/></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td><input type="text" name="phone"/></td>
			</tr>
		</table>
		<div style="padding: 10px 0 0 90px;">
			<button type="submit">등록</button>
			<button type="button" onclick="Location.href='${pageContext.request.contextPath}/studentList.do';">조회</button>
		</div>
	</form>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		function fn_validate(e){
			if(document.querySelector("#grade").value == "") {
				aleret("학년을 입력하세요.")
				return false;
			}
			if(document.querySelector("#room").value == "") {
				alert("반을 입력하세요.")
				return false;
			}
			if(document.querySelector("#name").value == "") {
				alert("이름을 입력하세요.")
				return false;
			}
			if(document.querySelector("#phone").value == "") {
				alert("전화번호를 입력하세요.")
				return false;
			}
			
			alert("학생 등록이 완료되었습니다.");
			
			return true;
		}
	</script>
</body>
</html>