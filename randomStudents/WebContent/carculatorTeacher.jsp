<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   span {
      border: 1px solid red;
      margin: 2px;
   }
</style>

<script type="text/javascript">

   function contentPrintFnc(operationObj){
      var firstNumObj = document.getElementById('firstNum');
      var secondNumObj = document.getElementById('secondNum');
      
//       alert(operationObj.value);
      
       
      var firstNum = Number(firstNumObj.value);
      var secondNum = Number(secondNumObj.value);
      
      var result = 0;
      var expression = "";
      
      switch (operationObj.value) {
      case '+':
         result = firstNum + secondNum;
         break;
      case '-':
         result = firstNum - secondNum;
         break;
      case '*':
         result = firstNum * secondNum;
         break;
      case '/':
         result = firstNum / secondNum;
         break;

      default:
         break;
      }
      
      expression = "" + firstNum + operationObj.value + secondNum + " = ";
      
      contentViewFnc(expression, result);
   }
   
   function contentViewFnc(expression, result){
      var userViewContentObj = document.getElementById('userViewContent');
      userViewContentObj.innerHTML = 
         '<span>' + expression + '</span><span>' + result + '</span>';
   }
</script>

</head>

<body>

   <input type="text" id="firstNum">
   <input type="text" id="secondNum">

   <input type="button" value="+" 
      onclick="contentPrintFnc(this);">
   <input type="button" value="-" 
      onclick="contentPrintFnc(this);">
   <input type="button" value="*" 
      onclick="contentPrintFnc(this);">
   <input type="button" value="/" 
      onclick="contentPrintFnc(this);">

   <h3>출력결과</h3>
   <div id='userViewContent' 
      style="border: 1px solid black; height: 20px; width: 250px;">
      
   </div>

</body>
</html>

