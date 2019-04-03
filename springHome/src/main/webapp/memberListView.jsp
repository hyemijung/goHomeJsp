<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	
	table, tr, td{
		border : 1px solid black;
		background-color: lightyellow;
	}
</style>

<title>회원 목록</title>
</head>
<body>
		<!-- 스프링 파일구조에 맞춰 다시 헤더 경로 잡기. 기존 경로 : /Header.jsp -->
	<jsp:include page="/WEB-INF/views/Header.jsp"/>
	<h1>내가 만든 회원목록 전체조회</h1>
	<div>
		<a href="add.do">신규회원</a>
		<!-- 별달리 넘길 정보가 없어서 이렇게 넘김 -->
	</div>
	</br>
	
	<table>		<!-- Vo로 바꿀 예정임 ㅎ -->
	<tr>
			<td>회원번호</td>
			<td>회원이름</td>
			<td>이메일</td>
			<td>가입일</td>
			<td>회원관리</td>
		</tr>
	<c:forEach var="memberDto" items="${memberList}">
		
		<tr>
			<td>${memberDto.no}</td>
			<td><a href='./update?no=${memberDto.no}'>${memberDto.name}</a></td>
			<td>${memberDto.email}</td>
			<td><fmt:formatDate value="${memberDto.createDate}" pattern="yyyy년 MM월 dd일  hh시 mm분(ss초)" /></td>
			<td style="text-align: center;"><a href='./delete?no=${memberDto.no}'>[삭제]</a></td>
		</tr>
		</c:forEach>
	</table>
	
	
	
	
	
	
	
	
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
		
</body>
</html>