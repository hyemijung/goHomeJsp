<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	pageContext.getOut();   // 페이지컨텍스트 - JSP 페이지를 실행하는 동안만 유지된다 // 이미 만들어져 있는 기본 보관소
%>

	<a href='./auth/login'>회원목록 페이지로 이동</a>

</body>
</html>