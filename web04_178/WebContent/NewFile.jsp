<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>

	<h1>회원등록</h1>
	<form action='add' method='get'>
		이름: <input type="text" name='name'>
		이메일: <input type="text" name='email'>
		암호: <input type="password" name='password'>
		
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
	
	</form>
	
	
<div>
	<a href='./add'>신규 회원</a>
</div>

</body>
</html>