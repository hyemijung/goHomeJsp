<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>

</head>
<body>

<jsp:include page="/WEB-INF/views/Header.jsp"/>

	<h1>회원정보</h1>
	<form action="./updateCtr.do" method="post">
		<input type="hidden" name="no" value="${memberVo.no}">
		이름: <input type="text" name="name" id="memberName"
			value="${memberVo.name}" ><br>
		이메일: <input type="text" name="email" 
			value="${memberVo.email}" ><br>
		비밀번호: <input type="password" name="password" value="" required="required"><br>
		가입일: <fmt:formatDate value="${memberVo.createDate}"
				pattern="yyyy-MM-dd"/><br>
		<input type="submit" value="저장하기">
		<input type="button" value="삭제하기">
		<input type="button" value="이전 페이지">
	</form>

<jsp:include page="/WEB-INF/views/Tail.jsp"/>  

</body>
</html>