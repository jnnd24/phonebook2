<%@page import="com.javaex.vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	PersonVo personVo = (PersonVo)request.getAttribute("personVo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 등록</h1>
	<h2>수정폼</h2>
	<p>
		전화번호를 수정하려면<br>
		아래 항목을 기입하고 "수정"버튼을 클릭하세요
	</p>
	
	<form action="./pbc?update" method="get">
		<label for="pName">이름(name)</label>
		<input id="pName" type="text" name="name" value=<%=personVo.getName() %>><br>
		<label for="pHp">핸드폰(hp)</label>
		<input id="pHp" type="text" name="hp" value=<%=personVo.getHp() %>><br>
		<label for="pCompany">회사(company)</label>
		<input id="pCompany" type="text" name="company" value=<%=personVo.getCompany() %>><br>
		<input type="text" name="personid" value=<%=personVo.getPersonId() %>><br>
		<input type="text" name="action" value="update"><br>
		<button type="submit">수정</button><br>
	</form>

</body>
</html>