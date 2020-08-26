<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 등록</title>
</head>
<body>
	<form action ="${pageContext.request.contextPath}/insertMember.do"
	 	method="post">
			 <tr>
				<td>회원 번호(자동생성): </td>
				<td><input type="text" name = "custno">-자동 생성 됨-</td>
			</tr>
			<tr>
				<td>회원 성명 : </td>
				<td><input type="text" name="custname"></td>
			</tr>
			<tr>
				<td>회원 전화 : </td>
				<td><input type="text" name="phone"></td>
			</tr>
				<td>회원 주소 : </td>
				<td><input type="text" name="address"></td>		
			<tr>
				<td>가입 일자 : </td>
				<td><input type="date" name="joinDate" id="joinDate" readonly/> </td>
			</tr>
				<td>고객등급[A:VIP B:일반직원 C:직원] : </td>
				<td><input type="text" name="grade"/></td>
			<tr>
				<td>도시 코드 : </td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">등록</button>
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/memberList.do';">조회</button>
			</tr>
		</table>
	</form>
	 		
</body>
</html>