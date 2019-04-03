<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>


<body>

<jsp:include page="/WEB-INF/views/Header.jsp"/>
	<h2>사용자 로그인</h2>

	<div>
		<form action="loginCtr.do" method="post" > <!-- 정보를 안전하게 지키기 위해 post -->
			<table>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" /></td><!-- 이메일과 패스워드가 -->
				</tr>											<!-- 여기서 가공처리 됨 -->
				<tr>
					<td>암호</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr> <!-- request나 session 모두 넘어감 -->
			</table>
		</form>
	</div>
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
</body>
</html>