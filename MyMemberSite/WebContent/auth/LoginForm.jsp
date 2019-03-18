<%@page import="net.hm.user.HmMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">
	// 	window.onload = {
	// 		var forObj = document.getElementById('loginForm')  // 나중에 미래에 쓸꺼다
	// 	}

	function loginSubmitFnc() {
		var formObj = document.getElementById('loginForm');

		var emailObj = document.getElementById('email');
				
		if (emailObj.value == '') {
			alert("이메일을 입력하지 않았습니다")
			return false;  // 함수를 무조건 종료하기위해 return false 한것 
							// if문에 들어갓다면 절대 formObj.submit();은 수행되지않도록
		}
		
		var passwordObj = document.getElementById('pwd');
		
		if (passwordObj.value == '') {
			alert("암호를 입력해주세요!")
			return false;
		}
		
		formObj.submit();
	}
</script>

</head>

<%
	HmMemberDto memberDto = (HmMemberDto) session.getAttribute("member");
	if (memberDto == null) {
		System.out.println("세션에 회원 정보가 없습니다");
	} else {
		System.out.println(memberDto.getEmail());
		System.out.println("님의 정보가 존재합니다");

		// 		String contextPathStr = request.getContextPath() + "/member/list";

		// 		response.sendRedirect(contextPathStr);
	}
%>

<body>
	<h2>사용자 로그인</h2>
	<form action="./login" id="loginForm" method="post">
		이메일: <input type="text" id='email' name="email"><br> 
		암호: <input type="password" id='pwd' name="password"><br> 
			<input type="button" value="로그인" onclick="loginSubmitFnc()">
	</form>

	

</body>
</html>