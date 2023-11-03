<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}" scope="application" />
<header>
	<div class="header-container">
		<div class="header-left">
			<div id="logo">
				<a href="/">Traveen</a>
			</div>
			<div id="menulist">
				<a href="#">여행지</a> <a href="#">애프터 트래빈</a> <a href="${root}/notice/list">공지사항</a>
			</div>
		</div>
		<c:if test="${empty userinfo}">
			<button id="btn-header-login">로그인</button>
		</c:if>
		<c:if test="${not empty userinfo}">
			<button id="btn-header-myinfo">마이페이지</button>
		</c:if>
	</div>
	<i class="fa-solid fa-bars fa-2x" style="color: #454545" id="hamburger"></i>
</header>
<script>
document.querySelector("#btn-header-myinfo").addEventListener("click", function() {
	console.log("sss");
	location.href = "${root}/user/myinfo";
});

	document.querySelector("#btn-header-login").addEventListener("click", function() {
		location.href = "${root}/user/login";
	});
	

</script>