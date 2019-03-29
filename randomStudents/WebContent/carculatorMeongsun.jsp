<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   div{
      border: 2px solid black;
      width:200px;
      height:20px;
   }
</style>
<script type="text/javascript">


/* 명선씨 코드  */
 * 
 */
   function addFnc(){
      var fstNum = document.getElementById("fstNum").value;
      var sndNum = document.getElementById("sndNum").value;
      
      var divObj = document.getElementById("divObj");
      var add = (parseInt(fstNum) + parseInt(sndNum));
      
      divObj.innerHTML += fstNum + " + " + sndNum + " = ";
//       var add = fstNum + sndNum;
      divObj.innerHTML += add;
   }
   function minusFnc(){
      var fstNum = document.getElementById("fstNum").value;
      var sndNum = document.getElementById("sndNum").value;
      
      var divObj = document.getElementById("divObj");
      
      var minus = (fstNum - sndNum);
      divObj.innerHTML = minus;
   }
   
   function multiplyFnc(){
      var fstNum = document.getElementById("fstNum").value;
      var sndNum = document.getElementById("sndNum").value;
      
      var divObj = document.getElementById("divObj");
      
      var multiply = (fstNum*sndNum);
      divObj.innerHTML = multiply;
   }
   

   function divideFnc(){
      var fstNum = document.getElementById("fstNum").value;
      var sndNum = document.getElementById("sndNum").value;
      
      var divObj = document.getElementById("divObj");
      
//       var divide = Math.floor(fstNum/sndNum);
      var divide = fstNum/sndNum;
      divObj.innerHTML = divide;
   }
   

</script>
<title>Insert title here</title>
</head>
<body>
   
   
   <input type="number" name="fstNum" id="fstNum">
   <input type= "number" name="sndNum" id="sndNum">
   
   <button onclick="addFnc();">+</button>
   <button onclick="minusFnc();">-</button>
   <button onclick="multiplyFnc();">*</button>
   <button onclick="divideFnc();">/</button>
   
   <h2>출력결과</h2>
   
   <div id="divObj">
   
   </div>
   
</body>
</html>