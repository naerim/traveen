<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}" />
<header>
	<div class="header-container">
		<div class="header-left">
			<div id="logo">
				<a href="/">Traveen</a>
			</div>
			<div id="menulist">
				<a href="#">여행지</a> <a href="#">애프터 트래빈</a> <a href="#">공지사항</a>
			</div>
		</div>
		<button id="btn-header-login">로그인</button>
	</div>
	<i class="fa-solid fa-bars fa-2x" style="color: #454545" id="hamburger"></i>
</header>
<script>
	document.querySelector("#btn-header-login").addEventListener("click", function() {
		location.href = "${root}/user/login";
	});
</script>