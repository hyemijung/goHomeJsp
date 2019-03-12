<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

<!-- 		<a href='./update?mNo='> + rs.getInt("mno") + ">" + -->
<!-- 		<a href='./update?mNo=sdf'>  -->
		 
		 
<!-- 여기로 갈수있도록 문자열 바꿔라	 http://localhost:8090/web04_194/member/one?email=s1%40test.com&pwd=1111 -->
		 
		 
		 
		 <h1>회원정보</h1>";
		 <form action='./update' method='post'>";
		 
		 번호: <input type='text' name='mno' readonly="readonly" disabled="disabled"><br/>";
		 이름: <input type='text' name='name'><br/>";
		 이메일: <input type='text' name='email'><br/>";
		 가입일:
		 
		 <input type='submit' value=추가>";
		 <input type='reset' value='취소' onclick="">";

		 </form>";

<!-- <a href = 'adfsffs'></a> -->

<p onclick="" style="border: 1px solid black;">이거 클릭해봐 </p>

<script type="text/javascript">
	
	
	location.href = './list';  // location은 자바 스크립트 언어 -> a 태그를 부르는 가장 작은 단위
// 	location.href = './상대주소'
	</script>

</body>
</html>