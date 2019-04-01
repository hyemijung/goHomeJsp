<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh"
	content="10;url=${pageContext.request.contextPath}/auth/login.do">
<!-- <script type="text/javascript"> -->
<!--  	alert('존재하지 않는 계정입니다.'); -->
<!--  	location.href = './login.do'; -->
<!-- </script> -->
<title>로그인 실패</title>
</head>
<body>

	<p>

<!-- (1 강사님)memberVo 객체를 생성해서 모델에 담아 보내는 경우 -->
 	사용자가 입력하신 아이디는 ${email.email} 입니다
 	<br>
	사용자가 입력하신 비밀번호는 ${email.password} 입니다.
 	<br>
<!-- (2 강사님)모델에 email과 password를 담아보내는 경우 -->
 	사용자가 입력하신 아이디는 ${email} 입니다
 	<br>
 	사용자가 입력하신 비밀번호는 ${password} 입니다.
<!--(3 기성씨) 모델에 paramMap을 담아 보내는 경우-->
	사용자가 입력하신 아이디는 ${paramMap.email} 입니다
 	<br>
 	사용자가 입력하신 비밀번호는 ${paramMap.pwd} 입니다.
</body>
</html>