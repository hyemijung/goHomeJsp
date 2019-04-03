<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	/*  	window.onload = function(){
	 var memberNameInputObj = document.getElementById("memberName");
	
	
	
	 memberNameInputObj.style.backgroundColor = '#E7E7E7'; 
	
	 } */

	function pageMoveFnc() {
		location.href = "list.do";
	}
</script>

<meta charset="UTF-8">
<title>정보수정</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/Header.jsp" />

	<h1>정보수정</h1>
	<form action="./update.do" method="get" id="formObj">
		<input type="hidden" name="no" value="${memberVo.no}">
		<table>
			<tr>
				<td style="background-color: skyblue; width: 70px;">이름</td>
				<!-- 			<td><input type= "text" name="name" id="memberName"  -->
				<%-- 			 value="${memberVo.name}" disabled="disabled"></td> --%>
				<td>${memberVo.name}</td>
			</tr>
			<tr>
				<td style="background-color: skyblue;">이메일</td>
				<td>${memberVo.email}</td>
				<!-- 			<td><input type="text" name="email"  -->
				<%-- 		 value="${memberVo.email}" disabled="disabled"></td> --%>
			</tr>
			<tr>
				<td style="background-color: skyblue;">암호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td style="background-color: skyblue;">가입일</td>
				<td><fmt:formatDate value="${memberVo.createDate}"
						pattern="yyyy년 mm월 dd일" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="button" value="뒤로가기" onclick="pageMoveFnc();">
				</td>
			</tr>
		</table>
	</form>


	<form action="./listOne.do" method="post">
		<input type="hidden" name="no" value="${memberVo.no}"> <input
			type="hidden" name="name" value="${memberVo.name}"></br> <input
			type="hidden" name="email" readonly="readonly"
			value="${memberVo.email}"></br> <input type="hidden"
			name="password"></br>
		<%-- 		<fmt:formatDate value="${memberVo.createDate}" --%>
		<%--  			pattern="yyyy년 mm월 dd일" /></br> --%>
		<!-- 		<input type="submit" value="수정"> -->
		<!-- 		<input type="button" value="탈퇴"> -->
		<!-- 		<input type="reset" value="취소"> -->
	</form>
	<button disabled="disabled">disabled</button>
	<!-- 엌ㅋㅋ -->



	<jsp:include page="/WEB-INF/views/Tail.jsp" />
</body>
</html>