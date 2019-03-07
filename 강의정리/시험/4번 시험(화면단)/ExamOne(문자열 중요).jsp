<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
table, tr, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 210px;
}

#btnTdBox{
	text-align: right;
}
</style>

<title>회원가입</title>

<script type="text/javascript">
	function registerFnc() {
// 		var inputIdObj = document.getElementById('id');
// 		var inputNameObj = document.getElementById('name');
// 		var inputPwdObj = document.getElementById('pwd');
// 		var inputPwdChkObj = document.getElementById('pwdChk');

		var tableObjArr = document.getElementsByTagName('table');
		var userInfoObj = tableObjArr[0];
		var trObjArr = userInfoObj.getElementsByTagName('tr');		
		
// 		var tdObj = trObjArr[0].getElementsByTagName('td')[1];
// 		var inputObj = tdObj.getElementsByTagName('input')[0];
		
// 		var tdObj2 = trObjArr[1].getElementsByTagName('td')[1];
// 		var inputObj2 = tdObj2.getElementsByTagName('input')[0];

// 		var tdObj3 = trObjArr[2].getElementsByTagName('td')[1];
// 		var inputObj3 = tdObj3.getElementsByTagName('input')[0];
		var tdObj = '';
		var inputObjArr = new Array();
		for (var i = 0; i < trObjArr.length-1; i++) {
			tdObj = trObjArr[i].getElementsByTagName('td')[1];
			inputObjArr[i] = tdObj.getElementsByTagName('input')[0];
		}
		
		for (var i = 0; i < inputObjArr.length; i++) {
			alert(inputObjArr[i].value);
		}
		
// 		alert(inputObj.value);
// 		alert(inputObj2.value);
// 		alert(inputObj3.value);
		
		var msgStrArr = new Array();
		msgStrArr[0] = "ID를 입력하세요!";
		msgStrArr[1] = "아이sadf!";
		msgStrArr[2] = "아이디를 sdf32423입력하세요!";
		msgStrArr[3] = "마지막";
		msgStrArr[3] = "마지막";
		
		for (var i = 0; i < inputObjArr.length; i++) {
			if (inputObjArr[i].value == "") {
				alert(msgStrArr[i]);
				inputIdObj.focus();
			} 
		}
		
	}
</script>
</head>
<body>

	<form action="#" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" id='id' class='id' name="id" size="15"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id='name' class='name' name="name" size="15"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" id='pwd' class='pwd' name="pwd" size="15"></td>
			</tr>
			<tr>
				<td>password확인</td>
				<td><input type="password" id='pwdChk' class='pwdChk' name="pwdChk" size="15"></td>
			</tr>
			<tr>
				<td id="btnTdBox" colspan="2">
					<input type="button" value="가입" onclick="registerFnc();">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>