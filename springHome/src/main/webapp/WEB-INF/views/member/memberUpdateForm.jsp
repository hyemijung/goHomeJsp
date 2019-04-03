<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	window.onload = function(){
		var memberNameInputObj = document.getElementById("memberName");
		
		
		
		memberNameInputObj.style.backgroundColor = '#E7E7E7';
		
	}

</script>

<meta charset="UTF-8">
<title>정보수정</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/Header.jsp"/>

	<h1>정보수정</h1>
	<form action="./updateCtr.do" method="post">
	<input type="hidden" name="no" value="${memberVo.no}">
	<table> 
		<tr>
			<td>이름</td>
			<td><input type= "text" name="name" id="memberName" 
			 value="${memberVo.name}"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" 
		 value="${memberVo.email}" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" required="required"></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><fmt:formatDate value="${memberVo.createDate}"
			pattern="yyyy년 mm월 dd일" /></td>
		</tr>
		<tr>
		<td></td>
			<td>
				<input type="submit" value="수정">
				<input type="button" value="탈퇴">
				<input type="reset" value="뒤로">
			</td>
		</tr>
	</table>
	</form>
	
	
<!-- 	<form action="./listOne.do" method="post"> -->
<%-- 		<input type="hidden" name="no" value="${memberVo.no}"> --%>
<%-- 		이름 : <input type= "text" name="name" value="${memberVo.name}"></br> --%>
<!-- 		이메일 : <input type="text" name="email"  -->
<%-- 		readonly="readonly" value="${memberVo.email}"></br> --%>
<!-- 		암호 : <input type="password" name="password"></br> -->
<%-- 		가입일 : <fmt:formatDate value="${memberVo.createDate}" --%>
<%-- 			pattern="yyyy년 mm월 dd일" /></br> --%>
<!-- 		<input type="submit" value="수정"> -->
<!-- 		<input type="button" value="탈퇴"> -->
<!-- 		<input type="reset" value="취소"> -->
<!-- 	</form> -->
	</br></br><button disabled="disabled">^ㅠ^</button>
	<!-- 엌ㅋㅋ -->
	
	
	
		<jsp:include page="/WEB-INF/views/Tail.jsp"/>
</body>
</html>