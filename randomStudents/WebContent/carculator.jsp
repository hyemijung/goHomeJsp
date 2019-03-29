<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	var firstNumObj = "";
	var secondNumObj = "";
	var resultViewObj = "";
	
	window.onload = function () {
		 firstNumObj = document.getElementById("firstNum");
		 secondNumObj = document.getElementById("secondNum");
		 resultViewObj = document.getElementById("resultView");	
	}
	
	
	
	function plusFnc() {
		
// 		var firstNumObj = document.getElementById("firstNum");
// 		var secondNumObj = document.getElementById("secondNum");
// 		var resultViewObj = document.getElementById("resultView");
		var plusObj = parseInt(firstNumObj.value) + parseInt(secondNumObj.value);
		
		resultViewObj.innerHTML = plusObj;
	}
	
	function minusFnc() {
// 		var firstNumObj = document.getElementById("firstNum");
// 		var secondNumObj = document.getElementById("secondNum");
// 		var resultViewObj = document.getElementById("resultView");
		var minusObj = parseInt(firstNumObj.value) - parseInt(secondNumObj.value);
		resultViewObj.innerHTML = minusObj;
	}
	
	function mutliplyFnc() {
// 		var firstNumObj = document.getElementById("firstNum");
// 		var secondNumObj = document.getElementById("secondNum");
// 		var resultViewObj = document.getElementById("resultView");
		var mutliplyObj = Math.floor(parseInt(firstNumObj.value) * parseInt(secondNumObj.value));
		resultViewObj.innerHTML = mutliplyObj;
	}

	function divideFnc() {
// 		var firstNumObj = document.getElementById("firstNum");
// 		var secondNumObj = document.getElementById("secondNum");
// 		var resultViewObj = document.getElementById("resultView");
		
		var divideObj = parseInt(firstNumObj.value) / parseInt(secondNumObj.value);
		var divideObj2 = Math.floor(divideObj);
		resultViewObj.innerHTML = divideObj2;
	}

</script>

</head>
<body>
	<input type="number" id="firstNum" >
	<input type="number" id="secondNum" >
	<input type="button" id="plus" value="+" onclick="plusFnc();">
	<input type="button" id="minus" value="-" onclick="minusFnc();">
	<input type="button" id="mutiple" value="*" onclick="mutliplyFnc();">
	<input type="button" id="devide" value="/" onclick="divideFnc();">

	<h2>출력결과</h2>
	<div id=resultView style="border: 1px solid black; width: 100px; height: 50px;">
		
	
	
	</div>

</body>
</html>