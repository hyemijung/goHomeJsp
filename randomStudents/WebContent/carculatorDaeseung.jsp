<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var view = "하나의 페이지에서 다 존재해 그게 객체야 ~ 당연히 다쓰지 어디까지? html 끝날때 까지";
	/* 요기다가 쓴다는건 전역변수같이 쓸수있다 - 절대 사라지지않는 변수
	window.onload 에서도 쓰고 function에서도 쓰고  
	하지만 이런식으론 사용하지 않는다  */
	
	var number1Val = "";
	var number2Val = "";
	var resultObj = "";
	var num1 = "";
	var num2 = "";
   
	
	/* 대승씨는 함수안에 함수를 넣으려고함 - 함수안에 있는 함수는 지역변수같은 함수가 됨. 한번만 사용되고 사라져서 부를 수 없음
	다른 함수를    window.onload = function() { 다른함수 여기 넣음   } 안에 넣으려함 
	이건 부를수 없는 함수 안에 넣은 것
	
	window.onload = function() { 페이지 초기화를 위한 화면을 예쁘게 꾸밀지를 넣는 것  }
	onload의 힘: 이 함수에서는 사용자에게 보여지는 첫번째 화면이나 레이아웃을 꾸밀때 사용되는 곳이다*/
  
	window.onload = function() {
      
       number1Val = document.getElementById("number1").value;
       number2Val = document.getElementById("number2").value;
       resultObj = document.getElementById("result");
       num1 = Number(number1Val);
       num2 = Number(number2Val);
   
   
   }
    
   
   function addFnc() {
   
      resultObj.value = num1 + num2;
      
      resultObj.style.width = "200px";
      resultObj.style.border = "3px solid black";
      
      resultObj.innerHTML = num1+" + "+num2+" = "+resultObj.value;
       
      
   }
   
   function minFnc() {
   
      resultObj.value = num1 - num2;
      
      resultObj.style.width = "200px";
      resultObj.style.border = "3px solid black";
            
      resultObj.innerHTML = num1+" - "+num2+" = "+resultObj.value;
       
      
   }
   
   function mulFnc() {

      resultObj.value = num1 * num2;
      
      resultObj.style.width = "200px";
      resultObj.style.border = "3px solid black";

      resultObj.innerHTML = num1+" * "+num2+" = "+resultObj.value;
       
      
   }
   
   function divFnc() {
      
      resultObj.value = num1 / num2;
      
      resultObj.style.width = "200px";
      resultObj.style.border = "3px solid black";
      
      resultObj.innerHTML = num1+" / "+num2+" = "+resultObj.value;
       
      
   }
   

</script>


</head>
<body>
   <input type="text" id='number1' >
   <input type="text" id='number2' >
   <input type="button" value="+" onclick='addFnc();'>
   <input type="button" value="-" onclick='minFnc();'>
   <input type="button" value="*" onclick='mulFnc();'>
   <input type="button" value="/" onclick='divFnc();'>
   <br>
   
   <h3>출력결과</h3>
   <div id="result"></div>
   
   
   
</body>

<script type="text/javascript">

 	alert(view);

</script>
</html>