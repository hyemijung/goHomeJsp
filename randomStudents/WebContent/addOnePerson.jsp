<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addFnc() {
		var addObj = document.getElementById("inputContext");
		var userViewObj = document.getElementById("userViewContent");
		userViewObj.innerHTML = addObj.value;
		
	}


</script>


</head>
<body>
	 <input type="text" id="inputContext" value=""  > 
	 
	 <input type="button" value="한명 추가" onclick="addFnc();"> 
	
	<div id="userViewContent" style="border: 1px solid black; width: 100px; height: 50px;">
	
	</div>
</body>
</html>