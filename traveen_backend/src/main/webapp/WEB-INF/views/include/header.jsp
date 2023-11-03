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
		<div class="header-right">
			<button id="btn-header-login" style="<c:if test="${not empty userinfo}">display: none</c:if>">로그인</button>
			<c:if test="${not empty userinfo}">
				<div id="header-username"><b>${userinfo.userName}</b>님, 반갑습니다.</div>
			</c:if>
			<button id="btn-header-myinfo" style="<c:if test="${empty userinfo}">display: none</c:if>">마이페이지</button>
		</div>
	</div>
	<i class="fa-solid fa-bars fa-2x" style="color: #454545" id="hamburger"></i>
</header>
<script>
	document.querySelector("#btn-header-login").addEventListener("click", function() {
		location.href = "${root}/user/login";
	});

	document.querySelector("#btn-header-myinfo").addEventListener("click", function() {
		location.href = "${root}/user/myinfo";
	});
	
	<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>

</script>