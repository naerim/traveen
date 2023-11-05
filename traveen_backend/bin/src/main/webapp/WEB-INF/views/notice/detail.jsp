<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Traveen</title>
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/notice.css" />
<link rel="stylesheet" href="../css/notice-detail.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<!-- header -->
	<%@ include file="../include/header.jsp"%>

	<!-- section -->
	<section>
		<h2 class="title">공지사항</h2>
		<h4 class="subtitle">Traveen의 공지사항을 확인해보세요.</h4>
		<div class="table-container">
			<div class="top-box">
				<div class="left">${notice.title}</div>
				<div class="right">
					<div class="date">${fn:substring(notice.createDate, 0, 10)}</div>
					<div class="hit">조회수 ${notice.viewCount}</div>
				</div>
			</div>
			<div class="content-box">
				<div class="content-title">${notice.title}</div>
				<div class="content">${notice.content}</div>
			</div>
			<div class="line"></div>
			<div class="btn-notice-admin-box" style="<c:if test="${userinfo.position ne M}">display: none</c:if>">
				<button id="btn-modify">수정</button>
				<button id="btn-delete">삭제</button>
			</div>
		</div>
		<div class="btn-notice-box">
			<button id="btn-notice-list">목록</button>
		</div>
	</section>

	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>
</body>
<script>
	document.querySelector("#btn-delete").addEventListener("click", function() {
		location.href = "${root}/notice/delete?idx=${notice.idx}";
	});
	document.querySelector("#btn-modify").addEventListener("click", function() {
		location.href = "${root}/notice/modify?idx=${notice.idx}";
	});
	document.querySelector("#btn-notice-list").addEventListener("click", function() {
		location.href = "${root}/notice/list";
	});
</script>
</html>
