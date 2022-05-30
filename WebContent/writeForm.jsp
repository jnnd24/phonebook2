<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 등록</h1>
	<h2>등록폼</h2>
	<p>
		전화번호를 등록하려면<br>
		아래 항목을 기입하고 "등록"버튼을 클릭하세요
	</p>
	
	<form action="./pbc?write" method="get">
		<label for="pName">이름(name)</label>
		<input id="pName" type="text" name="name" value=""><br>
		<label for="pHp">핸드폰(hp)</label>
		<input id="pHp" type="text" name="hp" value=""><br>
		<label for="pCompany">회사(company)</label>
		<input id="pCompany" type="text" name="company" value=""><br>
		<input type="text" name="action" value="write">
		<button type="submit">등록</button><br>
	</form>

</body>
</html>