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
<link rel="stylesheet" href="../css/notice-list.css" />
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
		<!-- top-box -->
		<div class="top-box">
			<div class="left">총 4건</div>
			<form class="right" id="form-search" action="#" method="post">
				<input type="hidden" name="pgno" value="1" /> <select
					name="select-notice" id="select-notice">
					<option value="">전체</option>
					<option value="subject">제목</option>
				</select> <input type="text" name="keyword" id="keyword"
					placeholder="검색어를 입력해주세요." /> <input type="submit" id="btn-search"
					value="검색" />
				<button type="button" id="btn-regist" onclick="location.href='${root}/notice/regist'">글 등록</button>
		</div>
		<div class="table-container">
			<!-- table -->
			<table>
				<!-- thead -->
				<thead>
					<tr>
						<th width="8%">NO.</th>
						<th width="67%">제목</th>
						<th width="15%">게시일</th>
						<th width="10%">조회수</th>
					</tr>
				</thead>
				<!-- tbody -->
				<tbody>

					<c:if test="${not empty notices}">
						<c:forEach var="notice" items="${notices}" varStatus="status">
							<tr>
								<td>${fn:length(notices) - status.index}</td>
								<td class="subject"><a
									href="${root}/notice/view?idx=${notice.idx}"
									class="notice-title link-dark">${notice.title}</a></td>
								<td><c:out
										value="${fn:substring(notice.createDate, 0, 10)}" /></td>
								<td>${notice.viewCount}</td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${empty notices}">
						<tr>
							<td colspan="5">작성된 글이 없습니다.</td>
						</tr>
					</c:if>

				</tbody>
			</table>
		</div>
		<!-- pagination -->
		<div class="pagination-container">
			<div class="btn-prev">&#60;이전</div>
			<span class="divider"></span>
			<ul>
				<li>1</li>
				<li>2</li>
			</ul>
			<span class="divider"></span>
			<div class="btn-next">다음&#62;</div>
		</div>
	</section>
	<form id="form-param" method="get" action="">
		<input type="hidden" name="pgno" id="pgno" value="${pgno}"> <input
			type="hidden" name="key" value="${select-notice}"> <input
			type="hidden" name="word" value="${keyword}">
	</form>
	<form id="form-no-param" method="get" action="${root}/notice/view">
		<%--             <input type="hidden" name="pgno" value="${pgno}"> --%>
		<%--             <input type="hidden" name="key" value="${select-notice}"> --%>
		<%--             <input type="hidden" name="word" value="${keyword}"> --%>
		<input type="hidden" id="idx" name="idx" value="">
	</form>

	<script>
	//           let titles = document.querySelectorAll(".notice-title");
	//           titles.forEach(function (title) {
	//             title.addEventListener("click", function () {
	//               document.querySelector("#idx").value = this.getAttribute("data-no");
	//               document.querySelector("#form-no-param").submit();
	//             });
	//           });
// 		document.querySelector("#btn-regist").addEventListener("click",
// 				function() {
// 					window.location.href = "${root}/notice/regist";
// 				});
<!-- 	</script> -->
	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>
</body>

</html>