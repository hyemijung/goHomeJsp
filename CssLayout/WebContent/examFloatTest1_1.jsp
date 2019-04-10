<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
* {
   margin: 0;
   padding: 0;
}

li {
   list-style-type: none;
}

body {
   font: 12px "굴림", Gulim;
   margin: 10px;
}

#container {
   width: 500px;
   padding: 10px;
   background: #fdd;
   border: 5px solid #caa;
}

h1 {
   text-align: center;
   padding: 10px;
/*    background-color: red; */
}

p {
   text-align: justify;
}

.green {
   float: left;
   width: 200px;
   padding: 15px;
   background: #dda;
}

.coffee {
   float: right;
   width: 200px;
   padding: 15px;;
   background: #ba7;
}

/*  #ttt {  */
/*     clear: both;  */
/* }  */
</style>

</head>
<body>

   <div id="container" style="overflow: auto;"> 
<!--    overflow를 사용하면 의미없는 div 태그를 안만들어도 된다 -->
      <h1>녹차와 커피</h1>
      
      <div class="green">
         <p>녹차를 처음으로 생산하여 사용하기 시작한 곳은 중국과 인도이다. 그 후 일본·실론·자바·수마트라 등 아시아 각
            지역으로 전파되었으며, 오늘날에는 중국에 이어 일본이 녹차 생산국으로 자리잡고 있다.</p>
      </div>

      <div class="coffee">
         <p>커피는 영어로 ‘coffee’, 식물학적으로는 ‘coffea’로 불린다. 커피나무에서 생산된 생두(生豆)를 일정
            시간 동안 볶은 뒤 곱게 분쇄하고 물을 이용하여 그 성분을 추출해 낸 음료로, 오늘날 전세계적으로 가장 인기있는 기호식품
            중 하나다.</p>
      </div>
      <div id="ttt"></div>
   </div>


</body>
</html>