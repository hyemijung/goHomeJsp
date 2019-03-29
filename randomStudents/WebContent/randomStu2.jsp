<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<script type="text/javascript">
	var studentArr = new Array();
	
	studentArr[0] = "이명선";
	studentArr[1] = "조혜선";
	studentArr[2] = "정혜미";
	
	var inputContextObj = "";
	
// 	for (var i = 0; i < array.length; i++) {
// 		addObj = document.getElementById('inputContext');
// 		studentArr[i] = addObj;
// 	}
	
	
	function randomStuFnc() {
		
	}
		
	
	function addStuFnc() {
 		
		var inputContextObj = document.getElementById("inputContext");
		var userViewContentObj = document.getElementById("userViewContent");
		
		studentArr.push(inputContextObj.value);
		
		userViewContentObj.innerHTML = studentArr;
	}

</script>
<body>
	<input type="text" id="contendTxt"> 
	
	<input type="button" value="화면에 입력한 내용을 출력하는 버튼" 
		onclick="addStuFnc();">

	<div id="userViewContent" style="border: 1px solid black; width: 100px; height: 50px;">
	
	</div>
</body>
</html>