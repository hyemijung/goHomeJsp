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
	<c:forEach var="memberVo" items="${memberList}">
		
		<tr>
			<td>${memberVo.no}</td>
			<td><a href='./listOne.do?no=${memberVo.no}'>${memberVo.name}</a></td>
			<td>${memberVo.email}</td>
			<td><fmt:formatDate value="${memberVo.createDate}" pattern="yyyy년 MM월 dd일  hh시 mm분(ss초)" /></td>
			<td style="text-align: center;"><a href='./deleteCtr.do?mno=${memberVo.no}'>[삭제]</a></td>
		</tr>
		</c:forEach>
	</table>
	
  <%-- 액션태그? <jsp: >
	<jsp:include > 	include는 다른페이지에 삽입하는 기술 (공통단- 필요한곳에서 다 사용해라)
	<jsp:param> 	pram을 던지는것 -> 컨트롤로에서 모델에 pagingMap을 담았기 때문에 여기서 사용가능 한것
  --%>

	<jsp:include page="/WEB-INF/views/common/paging.jsp">
		<jsp:param value="${pagingMap}" name="pagingMap"/>
	</jsp:include>
	
	<form action="./list.do" id="pagingForm" method="post">
		<input type="hidden" id="curPage" name="curPage"
			value="${pagingMap.memberPaging.curPage}">
	</form>
	
		
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
	
<!-- 	<img alt="fdgd" src="./springHome/resources/images/test.jpg"> -->
		
</body>
</html>