<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function contentPrintFnc() {
		var contentTxtObj = document.getElementById('contendTxt');
		
		alert(contentTxtObj.id);
		
		var rootContextObj = document.getElementById('rootContext')
		
		userViewContent.innerHTML = contentTxtObj.value;
	}


</script>


</head>
<body id='rootContext'>

	<input type="text" id="contendTxt"> 
	
	<input type="button" value="화면에 입력한 내용을 출력하는 버튼" 
		onclick="contentPrintFnc();">

	<div id="userViewContent" style="border: 1px solid black; width: 100px; height: 50px;">
	
	</div>

</body>
</html>