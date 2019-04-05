<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

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
	
.active {
	color: #FFD9EC;
	background-color: #5D5D5D;
	font-weight: bold;
}	
	
</style>

<script type="text/javascript" 
	src="/springHome/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
	function goPage(pageNumber) {
		var curPage= $("#curPage");
		
// 		 $("#curPage")의 의미? 
// 		 #: css 에서 id를 들고올때 사용했다면 여기서도 마찬가지이다
// 		document.getElementById('curPage') 를 실행한것 -> 이것이 jquery의 힘!!
// 	jquery는 전부 자바스크립트로 만든것! jquery를 사용함을 통해 자바스크립트를 일일히 작성시키는 시간을 줄이고자
		
//		자바스크립트로 curPage.value = adfdaf; 한 의미가  제이쿼리로 표현하면 아래와 같다
		curPage.val(pageNumber);
		
		
		$("#pagingForm").submit();
	}
	
	window.onload = function () {
		var curPageDoc = $("#curPage");
		var id = "#pageButton" + curPageDoc.val();
		
		$(id).addClass('active');
	}
</script>


<!-- <SCRIPT TYPE="TEXT/JAVASCRIPT" >

$(DOCUMENT).READY(FUNCTION(){
	VAR TEST = $('#PAGINGNAV').HTML();
	ALERT(TEST);
});

</SCRIPT> -->


<!-- <nav> 네이게이션 의미하는 태그 </nav> -->
 	<nav id="pagingNav">
 		<ul>
		<!-- ㄷ 한자 적용 -->
 			<li>
 				<a href="#" 
 					onclick="goPage(${pagingMap.memberPaging.prevPage});">
 				<span>≪</span></a>
 			</li>
 			
 			<c:forEach var="num" begin="${pagingMap.memberPaging.blockBegin}" 
 					end="${pagingMap.memberPaging.blockEnd}">
 				
 				<li id="pageButton${num}">
 					<a href="#" onclick="goPage(${num});">
 						<c:out value="${num}"/>
 					</a>
 				</li>
 				
 			</c:forEach>
 			
 			<li><a href="#" onclick="goPage(${pagingMap.memberPaging.nextPage});">
 				<span>≫</span></a></li>
 		</ul>
 	</nav>

