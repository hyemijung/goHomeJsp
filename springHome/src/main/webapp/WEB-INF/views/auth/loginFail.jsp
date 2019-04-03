<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" 
content="2;url=/springHome/auth/login.do"> <!-- 2초뒤에 자동 새로고침 -->
<title>로그인 실패</title>
</head>
<body>
	<p>로그인을 실패하였습니다.</p></br>
	<p>이메일 또는 암호가 일치하지 않습니다</p></br>
	<p>잠시 후 다시 로그인 화면으로 이동합니다</p>
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
</body>
</html>