<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

	nav > ul {
		list-style-type: none;
		padding: 0px;
		overflow: hidden;
		background-color: #333333;
		display: table;
		margin-left: auto;
		margin-right: auto;
	}

	nav > ul > li {
		float: left;
	}
	
	nav > ul > li > a {
		display: block;
 		color: white; 
		text-align: center;
		padding: 16px;
		text-decoration: none;
	}
	
/* 	hover : 두가지 속성, 양방향의 속성을 가진 것 - 여기선 마우스를 올릴때와 내릴때가 한꺼번에 적용된것(mouse over과 mouse out이 함께) */
	nav > ul > li > a:hover {
		color: #FFD9EC;
		background-color: #5D5D5D;
		font-weight: bold;
	}
</style>
<body>

<!-- <nav> 네이게이션 의미하는 태그 </nav> -->
 	<nav>
 		<ul>
		<!-- ㄷ 한자 적용 -->
 			<li><a href="#"><span>≪</span></a></li>
 			
 			<li><a href="#">1</a></li>
 			<li><a href="#">2</a></li>
 			<li><a href="#">3</a></li>
 			
 			<li><a href="#"><span>≫</span></a></li>
 		</ul>
 	</nav>

</body>
</html>