<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Traveen</title>
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/login.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../include/header.jsp"%>
	<section>
		<div class="auth-top">
			<h2>로그인</h2>
		</div>
		<form class="input-box" id="form-login" method="post" action="#">
			<div class="input-box-one">
				<label for="userId">아이디</label> <input type="text" id="userId"
					name="userId" placeholder="아이디를 입력해주세요." autofocus />
			</div>
			<div class="input-box-one">
				<label for="userPwd">비밀번호</label> <input type="password"
					id="userPwd" name="userPwd" placeholder="비밀번호를 입력해주세요." />
			</div>
			<div class="input-mid-box">
				<div class="checkbox-box">
					<label> <input type="checkbox" /> 아이디 기억하기
					</label>
				</div>
				<a href="${root}/user/join">회원가입</a>
			</div>
			<input type="submit" id="btn-login" value="로그인" />
		</form>
		<div class="line"></div>
		<button id="kakao-login">
			<img src="./img/icon_kakao.png" alt="" />카카오 로그인
		</button>
		<div class="input-buttom-box">
			<a href="#">아이디 찾기</a>
			<div class="vertical"></div>
			<a href="#">비밀번호 찾기</a>
		</div>
	</section>
	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>
</body>
<script>
	document.querySelector("#btn-login").addEventListener("click", function() {
		if (!document.querySelector("#userId").value) {
			alert("아이디 입력!!");
			return;
		} else if (!document.querySelector("#userPwd").value) {
			alert("비밀번호 입력!!");
			return;
		} else {
			let form = document.querySelector("#form-login");
			form.setAttribute("action", "${root}/user/login");
			form.submit();
		}
	});
</script>
</html>