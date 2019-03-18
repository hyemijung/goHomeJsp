<%@page import="java.util.ArrayList"%>
<%@page import="net.hm.user.HmMemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번까지 전부</title>
</head>
<body>

	<jsp:include page="/Header.jsp"/>

	<h1>내가 만든 회원목록 전체 조회</h1>
	<div>
		<a href="./add" >신규 회원</a> 
	</div>
	<br/>
	
	<%
			ArrayList<HmMemberDto> memberList = 
			(ArrayList<HmMemberDto>)request.getAttribute("memberList");
			
				for(HmMemberDto memberDto : memberList){
		%>
<!-- 	여기가 내가 추가함 -->
<%-- 	<%=memberDto.getModifiedDate() %> --%>
<!-- 	저 표현식만 없으면 전부 Html로 인식함  -->
	
	<%=memberDto.getNo()%>,
	<a href='./update?no=<%=memberDto.getNo()%>'><%=memberDto.getName()%></a>,
	<%=memberDto.getEmail()%>,
	<%=memberDto.getPassword() %>,
	<%=memberDto.getCreateDate()%>,
	
	<a href='./delete?no=<%=memberDto.getNo()%>'>[삭제]</a> 수정한 날짜: <%=memberDto.getModifiedDate() %>
	<br>
	
	<%
		}
	%>
	
	<jsp:include page="/Tail.jsp"/>  

</body>
</html>