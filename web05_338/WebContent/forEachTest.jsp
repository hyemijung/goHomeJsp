<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	int[] num = new int[]{
			1, 2, 3
	};
	
	pageContext.setAttribute("numArr", num);

	String[] subject = new String[]{
			"국어", "영어", "수학"
	};
	
	pageContext.setAttribute("subjectArr", subject);
	
	int[] score = new int[]{
			30, 40, 100
	};
	
	pageContext.setAttribute("scoreArr", score);
	
%>


<body>
	<ul>
	<c:forEach var="numInt" items="${numArr}" var="subjectStr" items="${subjectArr}"
			 var="scoreInt" items="${scoreArr}" >
		${numInt} ${subjectStr} ${scoreInt}
	</c:forEach>
	
	
	
<%-- 	<c:forEach var="numInt" items="${numArr}" > --%>
<!-- 		<li> -->
<%-- 			${numInt}  --%>
<!-- 		</li> -->
<%-- 	</c:forEach> --%>
		
<%-- 	<c:forEach var="subjectStr" items="${subjectArr}"> --%>
<%-- 		${subjectStr} --%>
<%-- 	</c:forEach > --%>
	
<%-- 	<c:forEach var="scoreInt" items="${scoreArr}"> --%>
<%-- 		${scoreInt} --%>
<%-- 	</c:forEach> --%>
	
	
	</ul>

</body>
</html>